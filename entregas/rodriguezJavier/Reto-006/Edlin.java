import java.util.Scanner;
import java.util.Stack;

class Edlin {
    public static void main(String[] args) {
        int activeLine[] = { 1 };
        String clipboard = "";
        Stack<String[]> history = new Stack<>();
        Stack<String[]> redoStack = new Stack<>();

        String document[] = {
                "Bienvenidos al editor EDLIN",
                "Utilice el menu inferior para editar el texto",
                "------",
                "[L] permite definir la linea activa",
                "[E] permite editar la linea activa",
                "[I] permite intercambiar dos lineas",
                "[B] borra el contenido de la linea activa",
                "[C] copia el contenido de la linea activa a otra",
                "[P] pega el contenido del portapapeles en una linea",
                "[D] deshacer el último cambio",
                "[R] rehacer el último cambio deshecho",
                "[S] sale del programa",
                "",
                ""
        };

        do {
            print(document, activeLine);
        } while (processActions(document, activeLine, clipboard, history, redoStack));
    }

    static void print(String[] document, int[] activeLine) {
        clearScreen();
        printHorizontalLine();
        for (int line = 0; line < document.length; line++) {
            System.out.println(line + separator(line, activeLine[0]) + document[line]);
        }
        printHorizontalLine();
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

    static boolean processActions(String[] document, int[] activeLine, String clipboard, Stack<String[]> history, Stack<String[]> redoStack) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [P]egar | [D]eshacer | [R]ehacer | [S]alir");

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
                saveState(document, history, redoStack);
                edit(document, activeLine);
                break;
            case 'I':
            case 'i':
                saveState(document, history, redoStack);
                exchangeLines(document);
                break;
            case 'B':
            case 'b':
                saveState(document, history, redoStack);
                delete(document, activeLine);
                break;
            case 'C':
            case 'c':
                clipboard = copy(document, activeLine);
                break;
            case 'P':
            case 'p':
                saveState(document, history, redoStack);
                paste(document, clipboard);
                break;
            case 'D':
            case 'd':
                document = undo(history, redoStack, document);
                break;
            case 'R':
            case 'r':
                document = redo(history, redoStack, document);
                break;
        }
        return true;
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static void delete(String[] document, int[] activeLine) {
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo ["
                + activeLine[0] + "]");
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
            validLine = originLine >= 0 && originLine < document.length;
        } while (!validLine);

        do {
            System.out.print("Indique segunda línea a intercambiar: ");
            destinationLine = askInt();
            validLine = destinationLine >= 0 && destinationLine < document.length;
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


    static String copy(String[] document, int[] activeLine) {
        System.out.println("Copiando el contenido de la línea activa [" + activeLine[0] + "]: " + document[activeLine[0]]);
        return document[activeLine[0]];
    }


    static void paste(String[] document, String clipboard) {
        if (clipboard.isEmpty()) {
            System.out.println("El portapapeles está vacío. Copie algo antes de pegar.");
            return;
        }
        System.out.print("Indique la línea donde desea pegar: ");
        int destinationLine = askInt();

        if (destinationLine >= 0 && destinationLine < document.length) {
            System.out.println("Pegando el contenido: \"" + clipboard + "\" en la línea " + destinationLine);
            document[destinationLine] = clipboard;
        } else {
            System.out.println("Número de línea inválido.");
        }
    }


    static void saveState(String[] document, Stack<String[]> history, Stack<String[]> redoStack) {
        history.push(document.clone());
        redoStack.clear();
    }


    static String[] undo(Stack<String[]> history, Stack<String[]> redoStack, String[] currentDocument) {
        if (history.isEmpty()) {
            System.out.println("No hay cambios para deshacer.");
            return currentDocument;
        }
        System.out.println("Deshaciendo el último cambio...");
        redoStack.push(currentDocument.clone());
        return history.pop();
    }


    static String[] redo(Stack<String[]> history, Stack<String[]> redoStack, String[] currentDocument) {
        if (redoStack.isEmpty()) {
            System.out.println("No hay cambios para rehacer.");
            return currentDocument;
        }
        System.out.println("Rehaciendo el último cambio...");
        history.push(currentDocument.clone());
        return redoStack.pop();
    }
}
