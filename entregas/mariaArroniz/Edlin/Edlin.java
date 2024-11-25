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
                "[S] sale del programa",
                "",
                ""
        };
        String history[] = {null};
        int historySize = 0;

        do {
            print(document, activeLine);
        } while (processActions(document, activeLine, history, historySize));
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

    static boolean processActions(String[] document, int[] activeLine, String[] history, int historySize) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir | [Z] Control Z | [Y] Control Y | [C] Control C | [V] Control V");

        switch (askChar()) {
            case 'S':   case 's':
                return false;
            case 'L':   case 'l':
                setActiveLine(document, activeLine);
                break;
            case 'E':   case 'e':
                save(document, history, historySize);
                edit(document, activeLine);
                break;
            case 'I':   case 'i':
                save(document, history, historySize);
                exchangeLines(document);
                break;
            case 'B':   case 'b':
                save(document, history, historySize);
                delete(document, activeLine);
                break;
            case 'Z': case 'z':
                undo(document, history, historySize);
                break;
            case 'Y': case 'y':
                next(document, history, historySize);
                break;
            case 'C': case 'c':
                copy(document, activeLine);
                break;
            case 'V': case 'v':
                paste(document, activeLine);
                break;
        }
        return true;
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static void delete(String[] document, int[] activeLine) {
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo ["+activeLine[0]+"]");
        if (askInt()==activeLine[0]) {
            document[activeLine[0]]="";
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
        document[destinationLine]=document[originLine];
        document[originLine]=temporaryLine;
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

    static void save(String[] document, String[] history, int historySize){

    }

    static void undo(String [] document, String[] history, int historySize ){

    }

    static void next(String [] document, String[] history, int historySize){
        
    }

    static void copy(String[] document, int[] activeLine){
        
    }

    static void paste(String[] document, int[] activeLine){
        
    }
}