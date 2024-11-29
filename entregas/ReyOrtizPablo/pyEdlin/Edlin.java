package entregas.ReyOrtizPablo.pyEdlin;

import java.util.*;

class Edlin {
    public static void main(String[] args) {
        int[] activeLine = {1};
        List<String> document = new ArrayList<>(Arrays.asList(
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
                "[S] sale del programa"
        ));

        Stack<List<String>> history = new Stack<>();
        Stack<List<String>> redoStack = new Stack<>();
        saveState(history, document);
        String copiedLine = null;

        do {
            print(document, activeLine);
        } while (processActions(document, activeLine, history, redoStack, copiedLine));
    }

    static void print(List<String> document, int[] activeLine) {
        clearScreen();
        printHorizontalLine();
        for (int line = 0; line < document.size(); line++) {
            System.out.println(line + separator(line, activeLine[0]) + document.get(line));
        }
        printHorizontalLine();
    }

    static String separator(int line, int activeLine) {
        return line == activeLine ? ":*| " : ": | ";
    }

    static void printHorizontalLine() {
        System.out.println("-");
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static boolean processActions(List<String> document, int[] activeLine, Stack<List<String>> history, Stack<List<String>> redoStack, String copiedLine) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [P]egar | [D]eshacer | [R]ehacer | [S]alir");

        switch (askChar()) {
            case 'S': case 's':
                return false;
            case 'L': case 'l':
                saveState(history, document);
                redoStack.clear();
                setActiveLine(document, activeLine);
                break;
            case 'E': case 'e':
                saveState(history, document);
                redoStack.clear();
                edit(document, activeLine);
                break;
            case 'I': case 'i':
                saveState(history, document);
                redoStack.clear();
                exchangeLines(document);
                break;
            case 'B': case 'b':
                saveState(history, document);
                redoStack.clear();
                delete(document, activeLine);
                break;
           
            case 'C': case 'c':
                copiedLine = copy(document, activeLine);
                break;
            
        }
        return true;
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static void delete(List<String> document, int[] activeLine) {
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo [" + activeLine[0] + "]");
        if (askInt() == activeLine[0]) {
            document.set(activeLine[0], "");
        }
    }

    static void exchangeLines(List<String> document) {
        int originLine, destinationLine;
        String temporaryLine;
        boolean validLine;

        do {
            System.out.print("Indique primera línea a intercambiar: ");
            originLine = askInt();
            validLine = originLine >= 0 && originLine < document.size();
        } while (!validLine);

        do {
            System.out.print("Indique segunda línea a intercambiar: ");
            destinationLine = askInt();
            validLine = destinationLine >= 0 && destinationLine < document.size();
        } while (!validLine);

        temporaryLine = document.get(destinationLine);
        document.set(destinationLine, document.get(originLine));
        document.set(originLine, temporaryLine);
    }

    static void edit(List<String> document, int[] activeLine) {
        System.out.println("EDITANDO> " + document.get(activeLine[0]));
        document.set(activeLine[0], askString());
    }

    static String askString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    static void setActiveLine(List<String> document, int[] activeLine) {
        boolean validLine;
        do {
            System.out.print("Indique la nueva línea activa: ");
            activeLine[0] = askInt();
            validLine = activeLine[0] >= 0 && activeLine[0] < document.size();
        } while (!validLine);
    }

    static int askInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    static void saveState(Stack<List<String>> history, List<String> document) {
        history.push(new ArrayList<>(document));
    }

    static String copy(List<String> document, int[] activeLine) {
        System.out.println("Se copió la línea: " + activeLine[0]);
        return document.get(activeLine[0]);
    }


}