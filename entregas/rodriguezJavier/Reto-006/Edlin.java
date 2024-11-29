import java.util.Scanner;
import java.util.Stack;

class Edlin {
    public static void main(String[] args) {
        int activeLine[] = { 1 };
        String clipboard = ""; // Memoria temporal para almacenar el texto copiado
        Stack<String[]> history = new Stack<>(); // Pila para almacenar el historial de estados del documento

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
                "[S] sale del programa",
                "",
                ""
        };

        do {
            print(document, activeLine);
        } while (processActions(document, activeLine, clipboard, history));
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

    static boolean processActions(String[] document, int[] activeLine, String clipboard, Stack<String[]> history) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [P]egar | [D]eshacer | [S]alir");

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
                saveState(document, history);
                edit(document, activeLine);
                break;
            case 'I':
            case 'i':
                saveState(document, history);
                exchangeLines(document);
                break;
            case 'B':
            case 'b':
                saveState(document, history);
                delete(document, activeLine);
                break;
            case 'C':
            case 'c':
                clipboard = copy(document, activeLine);
                break;
            case 'P':
            case 'p':
                saveState(document, history);
                paste(document, clipboard);
                break;
            case 'D':
            case 'd':
                document = undo(history, document);
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

    // Función copiar
    static String copy(String[] document, int[] activeLine) {
        System.out.println("Copiando el contenido de la línea activa [" + activeLine[0] + "]: " + document[activeLine[0]]);
        return document[activeLine[0]];
    }

    // Función pegar
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

    // Función guardar estado
    static void saveState(String[] document, Stack<String[]> history) {
        history.push(document.clone()); // Guardar una copia del documento
    }

    // Función deshacer
    static String[] undo(Stack<String[]> history, String[] currentDocument) {
        if (history.isEmpty()) {
            System.out.println("No hay cambios para deshacer.");
            return currentDocument;
        }
        System.out.println("Deshaciendo el último cambio...");
        return history.pop(); // Recuperar el último estado guardado
    }
}
