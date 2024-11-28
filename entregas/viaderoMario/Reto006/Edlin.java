package Reto006;

import java.util.Scanner;

class Edlin {
    public static void main(String[] args) {
        final int TAMAÑO = 50;
        int tamañoReal[] = { 0 };
        int activeLine[] = { 1 };
        String document[] = {
                "Bienvenidos al editor EDLIN",
                "Utilice el menu inferior para editar el texto",
                "------",
                "[L] permite definir la linea activa",
                "[E] permite editar la linea activa",
                "[I] permite intercambiar dos lineas",
                "[B] borra el contenido de la linea activa",
                "[C] copia el contenido de la linea activa",
                "[V] pega el contenido del portapapeles",
                "[Z] deshacer ultima accion",
                "[Z] rehacer ultima accion",
                "[S] sale del programa",
                "",
                ""
        };
        String portapapeles[] = { "" };
        String backup[][] = new String[TAMAÑO][document.length];

        do {
            print(document, activeLine);
        } while (processActions(document, activeLine, portapapeles, backup));
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

    static boolean processActions(String[] document, int[] activeLine, String[] portapapeles, String[][] backup) {
        System.out.println(
                "Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]copiar |[V]pegar|[Z]deshacer|[Y]reshacer |[S]alir");

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
                edit(document, activeLine);
                break;
            case 'I':
            case 'i':
                exchangeLines(document);
                break;
            case 'B':
            case 'b':
                delete(document, activeLine);
                break;
            case 'C':
            case 'c':
                copy(document, activeLine, portapapeles);
                break;
            case 'V':
            case 'v':
                paste(document, portapapeles, backup, activeLine);
                ;
                break;
            case 'Z':
            case 'z':
                undo(document, backup, activeLine);
                break;
            case 'Y':
            case 'y':
                remake(document, backup, activeLine);
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

    public static void copy(String[] document, int[] activeLine, String[] portapapeles) {
        boolean validLine = true;
        System.out.print("Copiando> ");
        int origen = 0;
        do {
            System.out.print("Indique linea a copiar");
            origen = askInt();
            validLine = origen >= 0 && origen < document.length;
        } while (!validLine);
        portapapeles[0] = document[origen];

    }

    public static void paste(String[] document, String[] portapapeles, String[][] backup, int[] tamañoReal) {
        boolean validLine = true;
        backup[tamañoReal[0]] = document;
        tamañoReal[0] = tamañoReal[0] + 1;
        System.out.println("Pegando> " + portapapeles[0]);
        int destino = 0;
        do {
            System.out.print("Indique line de destino");
            destino = askInt();
            validLine = destino >= 0 && destino < document.length;
        } while (!validLine);
        document[destino] = portapapeles[0];
    }

    public static void remake(String[] document, String[][] backup, int[] tamañoReal) {
        if (tamañoReal[0] < backup.length) {
            document = backup[tamañoReal[0] + 1];
            tamañoReal[0] = tamañoReal[0] + 1;
        }

    }

    public static void undo(String[] document, String[][] backup, int[] tamañoReal) {
        if (tamañoReal[0] > 0) {
            document = backup[tamañoReal[0] - 1];
            tamañoReal[0] = tamañoReal[0] - 1;
        }

    }
}