import java.util.Scanner;
import java.util.Stack;

class Edlin {
    public static void main(String[] args) {
        int activeLine[] = { 1 };
        String document[] = {
                "Bienvenidos al editor EDLIN",
                "Utilice el menu inferior para editar el texto",
                "------",
                "[L] permite definir la linea activa",
                "[E] permite editar la linea activa",
                "[I] permite intercambiar dos lineas",
                "[B] borra el contenido de la linea activa",
                "[C] copiar el contenido de una línea",
                "[P] pegar el contenido copiado en una línea",
                "[U] deshacer la última acción",
                "[R] rehacer la última acción",
                "[S] sale del programa",
                "",
                ""
        };

        Stack<String[]> undoStack = new Stack<>();
        Stack<String[]> redoStack = new Stack<>();

        String[] copiedText = { null };

        String[] persistentMessage = { "" };

        do {
            print(document, activeLine, persistentMessage);
        } while (processActions(document, activeLine, undoStack, redoStack, copiedText, persistentMessage));
    }

    static void print(String[] document, int[] activeLine, String[] persistentMessage) {
        clearScreen();
        printHorizontalLine();
        for (int line = 0; line < document.length; line++) {
            System.out.println(line + separator(line, activeLine[0]) + document[line]);
        }
        printHorizontalLine();

        if (!persistentMessage[0].isEmpty()) {
            System.out.println(persistentMessage[0]);
            persistentMessage[0] = "";
        }
    }

    static String separator(int line, int activeLine) {
        return line == activeLine ? ":*| " : ": | ";
    }

    static void printHorizontalLine() {
        System.out.println("-".repeat(50));
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static boolean processActions(String[] document, int[] activeLine, Stack<String[]> undoStack,
            Stack<String[]> redoStack, String[] copiedText, String[] persistentMessage) {
        System.out.println(
                "Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [P]egar | [U]ndo | [R]edo | [S]alir");

        switch (askChar()) {
            case 'S':
            case 's':
                return false;
            case 'L':
            case 'l':
                setActiveLine(document, activeLine);
                break;
            case 'E':
            case 'e':
                saveState(undoStack, document);
                clearRedoStack(redoStack);
                edit(document, activeLine);
                break;
            case 'I':
            case 'i':
                saveState(undoStack, document);
                clearRedoStack(redoStack);
                exchangeLines(document);
                break;
            case 'B':
            case 'b':
                saveState(undoStack, document);
                clearRedoStack(redoStack);
                delete(document, activeLine);
                break;
            case 'C':
            case 'c':
                copy(document, activeLine, copiedText, persistentMessage);
                break;
            case 'P':
            case 'p':
                saveState(undoStack, document);
                clearRedoStack(redoStack);
                paste(document, activeLine, copiedText, persistentMessage);
                break;
            case 'U':
            case 'u':
                undo(undoStack, redoStack, document);
                break;
            case 'R':
            case 'r':
                redo(undoStack, redoStack, document);
                break;
        }
        return true;
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static void delete(String[] document, int[] activeLine) {
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo [" +
                activeLine[0] + "]");
        if (askInt() == activeLine[0]) {
            document[activeLine[0]] = "";
        }
    }

    static void exchangeLines(String[] document) {
        int originLine, destinationLine;
        String temporaryLine;
        boolean validLine = true;

        do {
            System.out.print("Indique primera línea a intercambiar: ");
            originLine = askInt();

            System.out.print("Indique segunda línea a intercambiar: ");
            destinationLine = askInt();
            validLine = originLine >= 0 && originLine < document.length && destinationLine >= 0
                    && destinationLine < document.length;

        } while (!validLine);

        temporaryLine = document[destinationLine];
        document[destinationLine] = document[originLine];
        document[originLine] = temporaryLine;
    }

    static void edit(String[] document, int[] activeLine) {
        System.out.println("EDITANDO> " + document[activeLine[0]]);
        document[activeLine[0]] = askString();
    }

    static String askString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    static void setActiveLine(String[] document, int[] activeLine) {
        boolean validLine = true;
        do {
            System.out.print("Indique la nueva línea activa: ");
            activeLine[0] = askInt();
            validLine = activeLine[0] >= 0 && activeLine[0] < document.length;
        } while (!validLine);
    }

    static int askInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    static void saveState(Stack<String[]> stack, String[] document) {
        stack.push(document.clone());
    }

    static void clearRedoStack(Stack<String[]> redoStack) {
        redoStack.clear();
    }

    static void undo(Stack<String[]> undoStack, Stack<String[]> redoStack, String[] document) {
        if (!undoStack.isEmpty()) {
            redoStack.push(document.clone());
            String[] previousState = undoStack.pop();
            System.arraycopy(previousState, 0, document, 0, document.length);
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }

    static void redo(Stack<String[]> undoStack, Stack<String[]> redoStack, String[] document) {
        if (!redoStack.isEmpty()) {
            undoStack.push(document.clone());
            String[] nextState = redoStack.pop();
            System.arraycopy(nextState, 0, document, 0, document.length);
        } else {
            System.out.println("No hay acciones para rehacer.");
        }
    }

    static void copy(String[] document, int[] activeLine, String[] copiedText, String[] persistentMessage) {
        copiedText[0] = document[activeLine[0]];
        persistentMessage[0] = "Texto copiado: \"" + copiedText[0] + "\"";
    }

    static void paste(String[] document, int[] activeLine, String[] copiedText, String[] persistentMessage) {
        if (copiedText[0] == null) {
            persistentMessage[0] = "No hay contenido copiado para pegar.";
            return;
        }
        document[activeLine[0]] = copiedText[0];
        persistentMessage[0] = "Texto pegado en la línea " + activeLine[0] + ": \"" + copiedText[0] + "\"";
    }
}
