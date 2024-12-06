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
                "[C] copia la linea activa",
                "[P] pega en la linea activa",
                "[Z] deshacer",
                "[Y] rehacer",
                "[S] sale del programa",
                "",
                ""
        };

        String clipboard = "";
        Stack<String[]> undoStack = new Stack<>();
        Stack<String[]> redoStack = new Stack<>();

        do {
            print(document, activeLine);
        } while (processActions(document, activeLine, clipboard, undoStack, redoStack));
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
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println(); 
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static boolean processActions(String[] document, int[] activeLine, String clipboard, Stack<String[]> undoStack, Stack<String[]> redoStack) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [P]egar | [Z]deshacer | [Y]rehacer | [S]alir");

        char action = askChar();
        switch (action) {
            case 'S':   case 's':
                return false;
            case 'L':   case 'l':
                setActiveLine(document, activeLine);
                break;
            case 'E':   case 'e':
                edit(document, activeLine, undoStack);
                break;
            case 'I':   case 'i':
                exchangeLines(document, undoStack);
                break;
            case 'B':   case 'b':
                delete(document, activeLine, undoStack);
                break;
            case 'C':   case 'c':
                clipboard = copy(document, activeLine);
                break;
            case 'P':   case 'p':
                paste(document, activeLine, clipboard, undoStack);
                break;
            case 'Z':   case 'z':
                undo(document, undoStack, redoStack);
                break;
            case 'Y':   case 'y':
                redo(document, undoStack, redoStack);
                break;
        }
        return true;
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static void delete(String[] document, int[] activeLine, Stack<String[]> undoStack) {
        String[] previousState = document.clone();
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo ["+activeLine[0]+"]");
        if (askInt() == activeLine[0]) {
            document[activeLine[0]] = "";
            undoStack.push(previousState);
        }
    }

    static void exchangeLines(String[] document, Stack<String[]> undoStack) {
        int originLine, destinationLine;
        String temporaryLine;
        boolean validLine = true;

        String[] previousState = document.clone();

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

        undoStack.push(previousState);
    }

    static void edit(String[] document, int[] activeLine, Stack<String[]> undoStack) {
        String[] previousState = document.clone();
        System.out.println("EDITANDO> " + document[activeLine[0]]);
        document[activeLine[0]] = askString();
        undoStack.push(previousState);
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
        return document[activeLine[0]];
    }

    static void paste(String[] document, int[] activeLine, String clipboard, Stack<String[]> undoStack) {
        if (!clipboard.isEmpty()) {
            String[] previousState = document.clone();
            document[activeLine[0]] = clipboard;
            undoStack.push(previousState);
        } else {
            System.out.println("No hay nada en el portapapeles para pegar.");
        }
    }

    static void undo(String[] document, Stack<String[]> undoStack, Stack<String[]> redoStack) {
        if (!undoStack.isEmpty()) {
            String[] previousState = undoStack.pop();
            redoStack.push(document.clone());
            System.arraycopy(previousState, 0, document, 0, document.length);
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }

    static void redo(String[] document, Stack<String[]> undoStack, Stack<String[]> redoStack) {
        if (!redoStack.isEmpty()) {
            String[] previousState = redoStack.pop();
            undoStack.push(document.clone());
            System.arraycopy(previousState, 0, document, 0, document.length);
        } else {
            System.out.println("No hay acciones para rehacer.");
        }
    }
}
