package pyEdlin;

import java.util.*;

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
                "[U] deshacer la última acción",
                "[R] rehacer la última acción deshecha",
                "[C] copiar la linea activa",
                "[P] pegar el contenido copiado",
                ""
        };

        Stack<String[]> undoStack = new Stack<>();
        Stack<String[]> redoStack = new Stack<>();
        String clipboard = "";

        do {
            print(document, activeLine);
        } while (processActions(document, activeLine, undoStack, redoStack, clipboard));
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

    static boolean processActions(String[] document, int[] activeLine, Stack<String[]> undoStack, Stack<String[]> redoStack, String clipboard) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir | [U]ndo | [R]edo | [C]opiar | [P]egar");

        switch (askChar()) {
            case 'S':   case 's':
                return false;
            case 'L':   case 'l':
                setActiveLine(document, activeLine);
                break;
            case 'E':   case 'e':
                saveState(document, undoStack);
                edit(document, activeLine);
                break;
            case 'I':   case 'i':
                saveState(document, undoStack);
                exchangeLines(document);
                break;
            case 'B':   case 'b':
                saveState(document, undoStack);
                delete(document, activeLine);
                break;
            case 'U':   case 'u':
                undo(document, undoStack, redoStack);
                break;
            case 'R':   case 'r':
                redo(document, undoStack, redoStack);
                break;
            case 'C':   case 'c':
                clipboard = copy(document, activeLine);
                break;
            case 'P':   case 'p':
                saveState(document, undoStack);
                paste(document, activeLine, clipboard);
                break;
        }
        return true;
    }

    static void saveState(String[] document, Stack<String[]> stack) {
        stack.push(document.clone());
    }

    static void undo(String[] document, Stack<String[]> undoStack, Stack<String[]> redoStack) {
        if (!undoStack.isEmpty()) {
            redoStack.push(document.clone());
            String[] previousState = undoStack.pop();
            System.arraycopy(previousState, 0, document, 0, document.length);
        }
    }

    static void redo(String[] document, Stack<String[]> undoStack, Stack<String[]> redoStack) {
        if (!redoStack.isEmpty()) {
            undoStack.push(document.clone());
            String[] nextState = redoStack.pop();
            System.arraycopy(nextState, 0, document, 0, document.length);
        }
    }

    static String copy(String[] document, int[] activeLine) {
        return document[activeLine[0]];
    }

    static void paste(String[] document, int[] activeLine, String clipboard) {
        document[activeLine[0]] = clipboard;
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

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }
}
