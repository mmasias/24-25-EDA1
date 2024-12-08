import java.util.Scanner;

class TextEditor {
    private String[] document;
    private int activeLine;
    private String lastContent;
    private String redoContent;
    private String clipboard;

    public TextEditor(String[] initialContent) {
        this.document = initialContent;
        this.activeLine = 0;
        this.lastContent = "";
        this.redoContent = "";
        this.clipboard = "";
    }

    public void print() {
        clearScreen();
        printHorizontalLine();
        for (int i = 0; i < document.length; i++) {
            System.out.println(i + separator(i) + document[i]);
        }
        printHorizontalLine();
    }

    private String separator(int line) {
        return line == activeLine ? ":*| " : ": | ";
    }

    private void printHorizontalLine() {
        System.out.println("-".repeat(50));
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean processActions() {
        System.out.println(
                "Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [D]eshacer | [R]ehacer | [C]opiar | [P]egar | [B]orrar | [S]alir");

        switch (askChar()) {
            case 'S':
            case 's':
                return false;
            case 'L':
            case 'l':
                setActiveLine();
                break;
            case 'E':
            case 'e':
                edit();
                break;
            case 'I':
            case 'i':
                exchangeLines();
                break;
            case 'B':
            case 'b':
                delete();
                break;
            case 'D':
            case 'd':
                undo();
                break;
            case 'R':
            case 'r':
                redo();
                break;
            case 'C':
            case 'c':
                copy();
                break;
            case 'P':
            case 'p':
                paste();
                break;
        }
        return true;
    }

    private char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    private int askInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private String askString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private void setActiveLine() {
        System.out.print("Indique la nueva línea activa: ");
        int line = askInt();
        if (line >= 0 && line < document.length) {
            activeLine = line;
        } else {
            System.out.println("Línea fuera de rango.");
        }
    }

    private void edit() {
        System.out.println("EDITANDO> " + document[activeLine]);
        redoContent = "";
        lastContent = document[activeLine];
        document[activeLine] = askString();
    }

    private void delete() {
        System.out.println("Esta acción es irreversible: confirme la línea activa [" + activeLine + "]");
        if (askInt() == activeLine) {
            redoContent = "";
            lastContent = document[activeLine];
            document[activeLine] = "";
        }
    }

    private void exchangeLines() {
        System.out.print("Primera línea a intercambiar: ");
        int origin = askInt();
        System.out.print("Segunda línea a intercambiar: ");
        int destination = askInt();
        if (isValidLine(origin) && isValidLine(destination)) {
            String temp = document[origin];
            document[origin] = document[destination];
            document[destination] = temp;
        } else {
            System.out.println("Líneas fuera de rango.");
        }
    }

    private void undo() {
        redoContent = document[activeLine];
        document[activeLine] = lastContent;
    }

    private void redo() {
        if (redoContent.isEmpty()) {
            System.out.println("No hay acción para rehacer.");
            return;
        }
        lastContent = document[activeLine];
        document[activeLine] = redoContent;
    }

    private void copy() {
        clipboard = document[activeLine];
        System.out.println("Contenido copiado: " + clipboard);
    }

    private void paste() {
        if (clipboard.isEmpty()) {
            System.out.println("El portapapeles está vacío.");
            return;
        }
        redoContent = "";
        lastContent = document[activeLine];
        document[activeLine] = clipboard;
    }

    private boolean isValidLine(int line) {
        return line >= 0 && line < document.length;
    }
}