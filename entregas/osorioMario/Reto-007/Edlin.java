import java.util.Scanner;
import java.util.Stack;

class Edlin {
    static Stack<String[]> history = new Stack<>();
    static Stack<String[]> redoHistory = new Stack<>();
    static String clipboard = "";

    public static void main(String[] args) {
        int activeLine[] = {1};
        String document[] = {
                "Bienvenidos al editor EDLIN",
                "Utilice el menú inferior para editar el texto",
                "------",
                "[L] permite definir la línea activa",
                "[E] permite editar la línea activa",
                "[I] permite intercambiar dos líneas",
                "[B] borra el contenido de la línea activa",
                "[C] copiar la línea activa",
                "[P] pegar el contenido copiado",
                "[Z] deshacer la última acción",
                "[Y] rehacer la última acción deshecha",
                "[G] guardar el archivo",
                "[O] abrir un archivo",
                "[S] sale del programa",
                "",
                ""
        };

        FileManager fileManager = new FileManager();

        do {
            print(document, activeLine);
        } while (processActions(document, activeLine, fileManager));
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

    static boolean processActions(String[] document, int[] activeLine, FileManager fileManager) {
        System.out.println("Comandos: [L]ínea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [P]egar | [Z]deshacer | [Y]rehacer | [G]guardar | [O]abrir | [S]alir");

        switch (askChar()) {
            case 'S': case 's':
                return false;
            case 'L': case 'l':
                setActiveLine(document, activeLine);
                break;
            case 'E': case 'e':
                saveState(document);
                edit(document, activeLine);
                break;
            case 'I': case 'i':
                saveState(document);
                exchangeLines(document);
                break;
            case 'B': case 'b':
                saveState(document);
                delete(document, activeLine);
                break;
            case 'C': case 'c':
                copy(document, activeLine);
                break;
            case 'P': case 'p':
                saveState(document);
                paste(document, activeLine);
                break;
            case 'Z': case 'z':
                undo(document);
                break;
            case 'Y': case 'y':
                redo(document);
                break;
            case 'G': case 'g':
                fileManager.saveToFile(document);
                break;
            case 'O': case 'o':
                fileManager.loadFromFile(document);
                break;
        }
        return true;
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static void saveState(String[] document) {
        history.push(document.clone());
        redoHistory.clear();
    }

    static void undo(String[] document) {
        if (!history.isEmpty()) {
            redoHistory.push(document.clone());
            String[] previousState = history.pop();
            System.arraycopy(previousState, 0, document, 0, document.length);
            System.out.println("Deshacer realizado.");
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }

    static void redo(String[] document) {
        if (!redoHistory.isEmpty()) {
            history.push(document.clone());
            String[] nextState = redoHistory.pop();
            System.arraycopy(nextState, 0, document, 0, document.length);
            System.out.println("Rehacer realizado.");
        } else {
            System.out.println("No hay acciones para rehacer.");
        }
    }

    static void delete(String[] document, int[] activeLine) {
        document[activeLine[0]] = "";
    }

    static void exchangeLines(String[] document) {
        int originLine, destinationLine;
        String temporaryLine;

        System.out.print("Primera línea: ");
        originLine = askInt();
        System.out.print("Segunda línea: ");
        destinationLine = askInt();

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
        System.out.print("Nueva línea activa: ");
        activeLine[0] = askInt();
    }

    static int askInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    static void copy(String[] document, int[] activeLine) {
        clipboard = document[activeLine[0]];
        System.out.println("Línea copiada.");
    }

    static void paste(String[] document, int[] activeLine) {
        document[activeLine[0]] = clipboard;
        System.out.println("Contenido pegado.");
    }
}
