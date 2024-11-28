import java.util.Scanner;

class Edlin {
    static String[] previousState = null;
    static String[] nextState = null;
    static String clipboard = "";

    public static void main(String[] args) {
        int activeLine[] = {1};
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
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [P]egar | [Z]Deshacer | [Y]Rehacer | [S]alir");

        switch (askChar()) {
            case 'S': case 's':
                return false;
            case 'L': case 'l':
                setActiveLine(document, activeLine);
                break;
            case 'E': case 'e':
                previousState = saveState(document);
                edit(document, activeLine);
                nextState = null;
                break;
            case 'I': case 'i':
                previousState = saveState(document);
                exchangeLines(document);
                nextState = null;
                break;
            case 'B': case 'b':
                previousState = saveState(document);
                delete(document, activeLine);
                nextState = null;
                break;
            case 'C': case 'c':
                clipboard = copy(document, activeLine);
                pause();
                break;
            case 'P': case 'p':
                previousState = saveState(document);
                paste(document, activeLine);
                nextState = null;
                pause();
                break;
            case 'Z': case 'z':
                if (previousState != null) {
                    nextState = saveState(document);
                    restoreState(document, previousState);
                    System.out.println("Deshacer realizado.");
                } else {
                    System.out.println("No hay acciones para deshacer.");
                }
                pause();
                break;
            case 'Y': case 'y':
                if (nextState != null) {
                    previousState = saveState(document);
                    restoreState(document, nextState);
                    System.out.println("Rehacer realizado.");
                } else {
                    System.out.println("No hay acciones para rehacer.");
                }
                pause();
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

    static String copy(String[] document, int[] activeLine) {
        System.out.println("Copiando: " + document[activeLine[0]]);
        return document[activeLine[0]];
    }

    static void paste(String[] document, int[] activeLine) {
        if (clipboard.isEmpty()) {
            System.out.println("El portapapeles está vacío.");
        } else {
            document[activeLine[0]] = clipboard;
            System.out.println("Pegado: " + clipboard);
        }
    }

    static String[] saveState(String[] document) {
        return document.clone();
    }

    static void restoreState(String[] document, String[] state) {
        System.arraycopy(state, 0, document, 0, document.length);
    }

    static void pause() {
        System.out.println("Presiona ENTER para continuar...");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }
}