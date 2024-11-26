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
                "[S] sale del programa",
                "",
                ""
        };

        Stack<String[]> history = new Stack<>();
        Stack<String[]> redoStack = new Stack<>();
        saveState(history, document); 

        do {
            print(document, activeLine);
        } while (processActions(document, activeLine, history, redoStack));
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

    static boolean processActions(String[] document, int[] activeLine, Stack<String[]> history, Stack<String[]> redoStack) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [Z]Control Z | [Y]Control Y | [S]alir");

        switch (askChar()) {
            case 'S': case 's':
                return false;
            case 'L': case 'l':
                saveState(history, redoStack, document);
                setActiveLine(document, activeLine);
                break;
            case 'E': case 'e':
                saveState(history, redoStack, document);
                edit(document, activeLine);
                break;
            case 'I': case 'i':
                saveState(history, redoStack, document);
                exchangeLines(document);
                break;
            case 'B': case 'b':
                saveState(history, redoStack, document);
                delete(document, activeLine);
                break;
            case 'Z': case 'z':
                undo(document, history, redoStack);
                break;
            case 'Y': case 'y':
                redo(document, history, redoStack);
                break;
        }
        return true;
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static void delete(String[] document, int[] activeLine) {
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo [" + activeLine[0] + "]");
        if (askInt() == activeLine[0]) {
            document[activeLine[0]] = "";
        }
    }

    static void exchangeLines(String[] document) {
        int originLine, destinationLine;
        String temporaryLine;
        boolean validLine;

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
        boolean validLine;
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

    static void saveState(Stack<String[]> history, Stack<String[]> redoStack, String[] document) {
        history.push(document.clone());
        redoStack.clear();
    }

    static void saveState(Stack<String[]> history, String[] document) {
        history.push(document.clone());
    }

    static void undo(String[] document, Stack<String[]> history, Stack<String[]> redoStack) {
        if (history.size() > 1) { 
            redoStack.push(history.pop()); 
            String[] previousState = history.peek(); 
            for (int i = 0; i < document.length; i++) {
                document[i] = previousState[i];
            }
            System.out.println("Última acción deshecha.");
        } else {
            System.out.println("No hay más acciones para deshacer.");
        }
    }

    static void redo(String[] document, Stack<String[]> history, Stack<String[]> redoStack) {
        if (!redoStack.isEmpty()) {
            history.push(redoStack.pop()); 
            String[] nextState = history.peek();
            for (int i = 0; i < document.length; i++) {
                document[i] = nextState[i];
            }
            System.out.println("Última acción rehecha.");
        } else {
            System.out.println("No hay acciones para rehacer.");
        }
    }
}
