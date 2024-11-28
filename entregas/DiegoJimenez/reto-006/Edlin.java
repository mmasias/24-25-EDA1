import java.util.Scanner;
import java.util.Stack;

class Edlin {
    public static void main(String[] args) {
        int[] activeLine = {1};
        String[] document = {
                "Bienvenidos al editor EDLIN",
                "Utilice el menú inferior para editar el texto",
                "------",
                "[L] permite definir la línea activa",
                "[E] permite editar la línea activa",
                "[I] permite intercambiar dos líneas",
                "[B] borra el contenido de la línea activa",
                "[D] deshace la última acción de la activa",
                "[R] rehacer la última acción deshecha",
                "[C] copia el contenido de la línea activa",
                "[P] pega el contenido de la línea activa",
                "[S] sale del programa",
                "",
                ""
        };

        // Pilas para deshacer y rehacer
        Stack<String> undoStack = new Stack<>();
        Stack<String> redoStack = new Stack<>();
        String[] clipboard = {""};

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

    static boolean processActions(String[] document, int[] activeLine, Stack<String> undoStack, Stack<String> redoStack,
                                  String[] clipboard) {
        System.out.println(
                "Comandos: [L]ínea activa | [E]ditar | [I]ntercambiar | [D]eshacer | [R]ehacer | [C]opiar | [P]egar | [B]orrar | [S]alir");

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
                edit(document, activeLine, undoStack, redoStack);
                break;
            case 'I':
            case 'i':
                exchangeLines(document);
                break;
            case 'B':
            case 'b':
                delete(document, activeLine, undoStack, redoStack);
                break;
            case 'D':
            case 'd':
                undo(document, activeLine, undoStack, redoStack);
                break;
            case 'R':
            case 'r':
                redo(document, activeLine, undoStack, redoStack);
                break;
            case 'C':
            case 'c':
                copy(document, activeLine, clipboard);
                break;
            case 'P':
            case 'p':
                paste(document, activeLine, clipboard, undoStack, redoStack);
                break;
        }
        return true;
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static void delete(String[] document, int[] activeLine, Stack<String> undoStack, Stack<String> redoStack) {
        System.out.println("CONFIRMACIÓN: Indique el número de línea activa [" + activeLine[0] + "] para confirmar borrado");
        if (askInt() == activeLine[0]) {
            redoStack.clear();
            undoStack.push(document[activeLine[0]]); 
            document[activeLine[0]] = "";
            System.out.println("Línea borrada.");
        }
    }

    static void exchangeLines(String[] document) {
        int originLine, destinationLine;
        String temporaryLine;

        do {
            System.out.print("Indique primera línea a intercambiar: ");
            originLine = askInt();
        } while (!isValidLine(originLine, document.length));

        do {
            System.out.print("Indique segunda línea a intercambiar: ");
            destinationLine = askInt();
        } while (!isValidLine(destinationLine, document.length));

        temporaryLine = document[destinationLine];
        document[destinationLine] = document[originLine];
        document[originLine] = temporaryLine;
    }

    static void edit(String[] document, int[] activeLine, Stack<String> undoStack, Stack<String> redoStack) {
        System.out.println("EDITANDO> " + document[activeLine[0]]);
        redoStack.clear();
        undoStack.push(document[activeLine[0]]); 
        document[activeLine[0]] = askString(); 
        System.out.println("Edición completada.");
    }

    static void undo(String[] document, int[] activeLine, Stack<String> undoStack, Stack<String> redoStack) {
        if (undoStack.isEmpty()) {
            System.out.println("No hay cambios para deshacer.");
            return;
        }
        System.out.println("DESHACIENDO> Línea activa: " + activeLine[0]);
        redoStack.push(document[activeLine[0]]); 
        document[activeLine[0]] = undoStack.pop(); 
    }

    static void redo(String[] document, int[] activeLine, Stack<String> undoStack, Stack<String> redoStack) {
        if (redoStack.isEmpty()) {
            System.out.println("No hay cambios para rehacer.");
            return;
        }
        System.out.println("REHACIENDO> Línea activa: " + activeLine[0]);
        undoStack.push(document[activeLine[0]]); 
        document[activeLine[0]] = redoStack.pop(); 
    }

    static void copy(String[] document, int[] activeLine, String[] clipboard) {
        clipboard[0] = document[activeLine[0]];
        System.out.println("Contenido copiado: " + clipboard[0]);
    }

    static void paste(String[] document, int[] activeLine, String[] clipboard, Stack<String> undoStack, Stack<String> redoStack) {
        if (clipboard[0].isEmpty()) {
            System.out.println("El portapapeles está vacío.");
            return;
        }
        redoStack.clear();
        undoStack.push(document[activeLine[0]]); 
        document[activeLine[0]] = clipboard[0]; 
        System.out.println("Contenido pegado.");
    }

    static void setActiveLine(String[] document, int[] activeLine) {
        do {
            System.out.print("Indique la nueva línea activa: ");
            activeLine[0] = askInt();
        } while (!isValidLine(activeLine[0], document.length));
    }

    static int askInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    static String askString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    static boolean isValidLine(int line, int length) {
        return line >= 0 && line < length;
    }
}
