import java.util.Scanner;

class Edlin {
    private static final Scanner input = new Scanner(System.in);
    private static final int MAX_UNDO = 10;
    private static String[][] undoMatrix = new String[MAX_UNDO][];
    private static String[][] redoMatrix = new String[MAX_UNDO][];
    private static int undoIndex = 0;
    private static int undoCount = 0;
    private static int redoIndex = 0;
    private static int redoCount = 0;

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
                "[Z] deshacer la última acción",
                "[Y] rehacer la última acción",
                "",
                ""
        };

        do {
            print(document, activeLine);
        } while (processActions(document, activeLine));
    }

    static void print(String[] document, int[] activeLine) {
        clearScreen();
        printHorizontalLine();
        showLines(document, activeLine);
        printHorizontalLine();
    }

    static void showLines(String[] document, int[] activeLine) {
        for (int line = 0; line < document.length; line++) {
            System.out.println(line + separator(line, activeLine[0]) + document[line]);
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

    static boolean processActions(String[] document, int[] activeLine) {
        System.out.println(
                "Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir | [Z] deshacer | [Y] rehacer");

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
                edit(document, activeLine);
                break;
            case 'I':
            case 'i':
                exchangeLines(document);
                break;
            case 'B':
            case 'b':
                delete(document, activeLine);
                break;
            case 'Z':
            case 'z':
                undo(document);
                break;
            case 'Y':
            case 'y':
                redo(document);
                break;
        }
        return true;
    }

    static char askChar() {
        return input.next().charAt(0);
    }

    static void delete(String[] document, int[] activeLine) {
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo ["
                + activeLine[0] + "]");
        if (askInt() == activeLine[0]) {
            saveState(document);
            document[activeLine[0]] = "";
        }
    }

    static void exchangeLines(String[] document) {
        int originLine, destinationLine;
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

        saveState(document);
        String temp = document[originLine];
        document[originLine] = document[destinationLine];
        document[destinationLine] = temp;
    }

    static void edit(String[] document, int[] activeLine) {
        System.out.println("EDITANDO> " + document[activeLine[0]]);
        saveState(document);
        document[activeLine[0]] = askString();
    }

    static String askString() {
        input.nextLine();
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
        return input.nextInt();
    }

    static void saveState(String[] document) {
        undoMatrix[undoIndex] = document.clone();
        undoIndex = (undoIndex + 1) % MAX_UNDO;
        if (undoCount < MAX_UNDO) {
            undoCount++;
        }
        redoCount = 0;
    }

    static void undo(String[] document) {
        if (undoCount > 0) {
            undoIndex = (undoIndex - 1 + MAX_UNDO) % MAX_UNDO;
            String[] previousState = undoMatrix[undoIndex];
            redoMatrix[redoIndex] = document.clone();
            redoIndex = (redoIndex + 1) % MAX_UNDO;
            if (redoCount < MAX_UNDO) {
                redoCount++;
            }
            System.arraycopy(previousState, 0, document, 0, document.length);
            undoCount--;
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }

    static void redo(String[] document) {
        if (redoCount > 0) {
            redoIndex = (redoIndex - 1 + MAX_UNDO) % MAX_UNDO;
            String[] nextState = redoMatrix[redoIndex];
            undoMatrix[undoIndex] = document.clone();
            undoIndex = (undoIndex + 1) % MAX_UNDO;
            if (undoCount < MAX_UNDO) {
                undoCount++;
            }
            System.arraycopy(nextState, 0, document, 0, document.length);
            redoCount--;
        } else {
            System.out.println("No hay acciones para rehacer.");
        }
    }
}