import java.util.Scanner;

class Edlin {
    public static void main(String[] args) {
        int activeLine[] = { 1 };
        String document[] = {
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

        // Variables para deshacer, rehacer y portapapeles
        String lastContent[] = { "" };
        String redoContent[] = { "" };
        String clipboard[] = { "" };

        do {
            print(document, activeLine);
        } while (processActions(document, activeLine, lastContent, redoContent, clipboard));
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

    static boolean processActions(String[] document, int[] activeLine, String[] lastContent, String[] redoContent,
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
                edit(document, activeLine, lastContent, redoContent);
                break;
            case 'I':
            case 'i':
                exchangeLines(document);
                break;
            case 'B':
            case 'b':
                delete(document, activeLine, lastContent, redoContent);
                break;
            case 'D':
            case 'd':
                undo(document, activeLine, lastContent, redoContent);
                break;
            case 'R':
            case 'r':
                redo(document, activeLine, lastContent, redoContent);
                break;
            case 'C':
            case 'c':
                copy(document, activeLine, clipboard);
                break;
            case 'P':
            case 'p':
                paste(document, activeLine, clipboard, lastContent, redoContent);
                break;
        }
        return true;
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static void delete(String[] document, int[] activeLine, String[] lastContent, String[] redoContent) {
        System.out.println("CONFIRMACIÓN: Indique el número de línea activa [" + activeLine[0] + "] para confirmar borrado");
        if (askInt() == activeLine[0]) {
            redoContent[0] = "";
            lastContent[0] = document[activeLine[0]]; // Guardar estado previo
            document[activeLine[0]] = ""; // Borrar contenido
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

    static void edit(String[] document, int[] activeLine, String[] lastContent, String[] redoContent) {
        System.out.println("EDITANDO> " + document[activeLine[0]]);
        redoContent[0] = "";
        lastContent[0] = document[activeLine[0]]; // Guardar estado previo
        document[activeLine[0]] = askString(); // Actualizar línea activa
        System.out.println("Edición completada.");
    }

    static void undo(String[] document, int[] activeLine, String[] lastContent, String[] redoContent) {
        if (lastContent[0].isEmpty()) {
            System.out.println("No hay cambios para deshacer.");
            return;
        }
        System.out.println("DESHACIENDO> Línea activa: " + activeLine[0]);
        redoContent[0] = document[activeLine[0]]; // Guardar estado actual para rehacer
        document[activeLine[0]] = lastContent[0]; // Restaurar contenido previo
        lastContent[0] = ""; // Limpiar estado de deshacer
    }

    static void redo(String[] document, int[] activeLine, String[] lastContent, String[] redoContent) {
        if (redoContent[0].isEmpty()) {
            System.out.println("No hay cambios para rehacer.");
            return;
        }
        System.out.println("REHACIENDO> Línea activa: " + activeLine[0]);
        lastContent[0] = document[activeLine[0]]; // Guardar estado actual
        document[activeLine[0]] = redoContent[0]; // Restaurar contenido rehacer
        redoContent[0] = ""; // Limpiar estado de rehacer
    }

    static void copy(String[] document, int[] activeLine, String[] clipboard) {
        clipboard[0] = document[activeLine[0]];
        System.out.println("Contenido copiado: " + clipboard[0]);
    }

    static void paste(String[] document, int[] activeLine, String[] clipboard, String[] lastContent,
            String[] redoContent) {
        if (clipboard[0].isEmpty()) {
            System.out.println("El portapapeles está vacío.");
            return;
        }
        redoContent[0] = "";
        lastContent[0] = document[activeLine[0]]; // Guardar estado previo
        document[activeLine[0]] = clipboard[0]; // Pegar contenido
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
