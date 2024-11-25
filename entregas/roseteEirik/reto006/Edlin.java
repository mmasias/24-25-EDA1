package entregas.roseteEirik.reto006;

import java.util.Scanner;

class Edlin {

    private static String copiedString;
    private static int ctrlSaved;
    
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
            "[V] pega la linea copiada",
            "[Y] rehace la ultima accion",
            "[Z] deshace la ultima accion",
            "[S] sale del programa",
            "",
            ""
        };

        String[][] history = new String[document.length][100];
        
        clearScreen();
        do {
            print(document, activeLine);
        } while (processActions(document, activeLine, history));
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
        final int SPACE = 3;
        int length = line / 10;
        final String ACTIVE_LINE = ":" + "*".repeat(SPACE - length) + "| ";
        final String OTHER_LINE = ":" + " ".repeat(SPACE - length) + "| ";

        return line == activeLine ? ACTIVE_LINE : OTHER_LINE;
    }

    static void printHorizontalLine() {
        System.out.println("-".repeat(50));
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static boolean processActions(String[] document, int[] activeLine, String[][] history) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [V] Pegar | [Y] Rehacer | [Z] Deshacer | [S]alir");

        switch (askChar()) {
            case 'S':   case 's':
                return false;
            case 'L':   case 'l':
                setActiveLine(document, activeLine);
                break;
            case 'E':   case 'e':
                edit(document, activeLine, history);
                break;
            case 'I':   case 'i':
                exchangeLines(document, history);
                break;
            case 'B':   case 'b':
                delete(document, activeLine, history);
                break;
            case 'C':   case 'c':
                ctrlC(document);
                break;
            case 'V':   case 'v':
                ctrlV(document, history);
                break;
            case 'Z':   case 'z':
                ctrlZ(history, document);
                break;
            case 'Y':   case 'y':
                ctrlY(history, document);
                break;
        }
        return true;
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static void delete(String[] document, int[] activeLine, String[][] history) {
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo ["+activeLine[0]+"]");
        if (askInt()==activeLine[0]) {
            document[activeLine[0]]="";
        }
        updateHistory(document, history);
    }

    static void exchangeLines(String[] document, String[][] history) {
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
        document[destinationLine]=document[originLine];
        document[originLine]=temporaryLine;
        updateHistory(document, history);
    }

    static void ctrlC(String[] document){
        int copiedLine;
        boolean validLine = true;
        
        do {
            System.out.print("Indique la línea a copiar: ");
            copiedLine = askInt();
            validLine = copiedLine >= 0 && copiedLine < document.length;
        } while (!validLine);

        copiedString = document[copiedLine];
    }

    static void ctrlV(String[] document, String[][] history){
        int pasteLine;
        boolean validLine = true;
        
        do {
            System.out.print("Indique la línea a copiar: ");
            pasteLine = askInt();
            validLine = pasteLine >= 0 && pasteLine < document.length;
        } while (!validLine);

        document[pasteLine] = copiedString;
        updateHistory(document, history);
    }

    static void ctrlY(String[][] history, String[] document){
        if (history == null) {
            System.out.println("No hay acciones para rehacer");
        } else {
            ctrlSaved++;
            for (int i = 0; i < document.length; i++) {
                document[i] = history[i][ctrlSaved];
            }
        }
    }

    static void ctrlZ(String[][] history, String[] document){
        if (history == null) {
            System.out.println("No hay acciones para deshacer");
        } else {
            ctrlSaved--;
            for (int i = 0; i < document.length; i++) {
                document[i] = history[i][ctrlSaved];
            }
        }
    }

    private static String[][] updateHistory(String[] document, String[][] history) {
        for (int i = 0; i < document.length; i++) {
            history[i][ctrlSaved] = document[i];
        }
        ctrlSaved++;
        return history;
    }

    static void edit(String[] document, int[] activeLine, String[][] history) {
        System.out.println("EDITANDO> " + document[activeLine[0]]);
        document[activeLine[0]] = askString();
        updateHistory(document, history);
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
}