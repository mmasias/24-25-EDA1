import java.util.Scanner;
public class Edlin {
    
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
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
        switch (askChar()) {
            case 'S':   case 's':
                return false;
            case 'L':   case 'l':
                setActiveLine(document, activeLine);
                break;
            case 'E':   case 'e':
                edit(document, activeLine);
                break;
            case 'I':   case 'i':
                exchangeLines(document);
                break;
            case 'B':   case 'b':
                delete(document, activeLine);
                break;
        }
        return true;
    }

    static Scanner input = new Scanner(System.in);

    static char askChar() {
        return input.next().charAt(0);
    }
    
    static int askInt() {
        return input.nextInt();
    }

    static String askString() {
        return input.nextLine();
    }
    
    static void delete(String[] document, int[] activeLine) {
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo ["+activeLine[0]+"]");
        if (askInt()==activeLine[0]) {
            document[activeLine[0]]="";
        }
    }

    static int askValidLine(String prompt, int maxLines) {
        int line;
        do {
            System.out.print(prompt);
            line = askInt();
        } while (line < 0 || line >= maxLines);
        return line;
    }

    static void exchangeLines(String[] document) {
        int originLine = askValidLine("Indique primera línea a intercambiar:", document.length); 
        int destinationLine = askValidLine("Indique segunda línea a intercambiar:", document.length);
        
        String temporaryLine = document[destinationLine];
        document[destinationLine]=document[originLine];
        document[originLine]=temporaryLine;
    }

    static void setActiveLine(String[] document, int[] activeLine) {
       activeLine[0] = askValidLine("Indique la nueva línea activa: ", document.length);    
    }

    static void edit(String[] document, int[] activeLine) {
        System.out.println("EDITANDO> " + document[activeLine[0]]);
        document[activeLine[0]] = askString();
    }
    
}