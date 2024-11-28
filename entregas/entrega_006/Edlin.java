import java.util.Scanner;

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
                "[U] deshacer la última acción",
                "[R] rehacer la última acción",
                "[C] copiar la línea activa",
                "[P] pegar en otra línea",
                "[S] sale del programa",
                "",
                ""
        };

        Stack history = new Stack(10, document.length); 
        Stack redoStack = new Stack(10, document.length); 
        saveState(history, document);
        String copiedLine = null; 

        do {
            print(document, activeLine);
        } while (processActions(document, activeLine, history, redoStack, copiedLine));
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

    static boolean processActions(String[] document, int[] activeLine, Stack history, Stack redoStack, String copiedLine) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [P]egar | [U]ndeshacer | [R]ehacer | [S]alir");

        switch (askChar()) {
            case 'S':   case 's':
                return false;
            case 'L':   case 'l':
                saveState(history, document, redoStack);
                setActiveLine(document, activeLine);
                break;
            case 'E':   case 'e':
                saveState(history, document, redoStack);
                edit(document, activeLine);
                break;
            case 'I':   case 'i':
                saveState(history, document, redoStack);
                exchangeLines(document);
                break;
            case 'B':   case 'b':
                saveState(history, document, redoStack);
                delete(document, activeLine);
                break;
            case 'U':   case 'u':
                undo(history, redoStack, document);
                break;
            case 'R':   case 'r':
                redo(redoStack, history, document);
                break;
            case 'C':   case 'c':
                copiedLine = copy(document, activeLine);
                break;
            case 'P':   case 'p':
                saveState(history, document, redoStack);
                paste(document, copiedLine);
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

    static void saveState(Stack history, String[] document, Stack redoStack) {
        history.push(document);
        redoStack = new Stack(10, document.length); 
    }

    static String copy(String[] document, int[] activeLine) {
        System.out.println("Se copió la línea: " + activeLine[0]);
        return document[activeLine[0]];
    }

    static void paste(String[] document, String copiedLine) {
        if (copiedLine == null) {
            System.out.println("No hay ninguna línea copiada.");
            return;
        }
        System.out.print("Indique la línea donde pegar: ");
        int destinationLine = askInt();
        if (destinationLine >= 0 && destinationLine < document.length) {
            document[destinationLine] = copiedLine;
            System.out.println("Se pegó la línea copiada en la línea " + destinationLine);
        } else {
            System.out.println("Línea inválida.");
        }
    }
}
