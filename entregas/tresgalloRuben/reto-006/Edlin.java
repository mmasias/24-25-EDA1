import java.util.Scanner;

class Edlin {
    private static String copyBuffer = ""; 
    private static String[][] history = new String[10][]; 
    private static int historyIndex = -1; 

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
                "[C] copiar la línea activa",
                "[P] pegar en la línea activa",
                "[U] deshacer la última acción",
                "[R] rehacer la última acción",
                "[S] sale del programa",
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

    static boolean processActions(String[] document, int[] activeLine) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [P]egar | [U]ndoes | [R]ehacer | [S]alir");

        switch (askChar()) {
            case 'S':   case 's':
                return false;
            case 'L':   case 'l':
                setActiveLine(document, activeLine);
                break;
            case 'E':   case 'e':
                saveState(document); 
                edit(document, activeLine);
                break;
            case 'I':   case 'i':
                saveState(document); 
                exchangeLines(document);
                break;
            case 'B':   case 'b':
                saveState(document); 
                delete(document, activeLine);
                break;
            case 'C':   case 'c':
                copy(document, activeLine);
                break;
            case 'P':   case 'p':
                saveState(document); 
                paste(document, activeLine);
                break;
            case 'U':   case 'u':
                undo(document);
                break;
            case 'R':   case 'r':
                redo(document);
                break;
        }
        return true;
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static void saveState(String[] document) {
        if (historyIndex < history.length - 1) {
            historyIndex++;
            history[historyIndex] = document.clone(); 
        } else {
            System.arraycopy(history, 1, history, 0, history.length - 1);
            history[history.length - 1] = document.clone();
        }
    }

    static void undo(String[] document) {
        if (historyIndex > 0) {
            historyIndex--;
            System.arraycopy(history[historyIndex], 0, document, 0, document.length);
            System.out.println("Se deshizo la última acción.");
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }

    static void redo(String[] document) {
        if (historyIndex < history.length - 1 && history[historyIndex + 1] != null) {
            historyIndex++;
            System.arraycopy(history[historyIndex], 0, document, 0, document.length);
            System.out.println("Se rehizo la última acción.");
        } else {
            System.out.println("No hay acciones para rehacer.");
        }
    }

    static void delete(String[] document, int[] activeLine) {
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo ["+activeLine[0]+"]");
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

    static void copy(String[] document, int[] activeLine) {
        copyBuffer = document[activeLine[0]]; 
        System.out.println("Línea copiada: " + copyBuffer);
    }

    static void paste(String[] document, int[] activeLine) {
        if (copyBuffer.isEmpty()) {
            System.out.println("El buffer está vacío. Copie una línea antes de pegar.");
        } else {
            document[activeLine[0]] = copyBuffer; 
            System.out.println("Pegado: " + copyBuffer);
        }
    }
}
