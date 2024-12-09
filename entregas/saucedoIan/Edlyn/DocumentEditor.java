import java.util.Scanner;

class DocumentEditor {
    private final Scanner input;
    private final String[] document;
    private final UndoRedoManager undoRedoManager;
    private int activeLine = 0;
    private String copiedLine = null;

    public DocumentEditor(int documentSize, int maxUndo, Scanner input) {
        this.input = input;
        this.document = new String[documentSize];
        this.undoRedoManager = new UndoRedoManager(maxUndo, documentSize);
        initializeDocument();
    }

    private void initializeDocument() {
        for (int i = 0; i < document.length; i++) {
            document[i] = "";
        }
        if (document.length > 0)
            document[0] = "Bienvenidos al editor EDLIN";
        if (document.length > 1)
            document[1] = "Utilice el menu inferior para editar el texto";
        if (document.length > 2)
            document[2] = "------";
        if (document.length > 3)
            document[3] = "[L] permite definir la linea activa";
        if (document.length > 4)
            document[4] = "[E] permite editar la linea activa";
        if (document.length > 5)
            document[5] = "[I] permite intercambiar dos lineas";
        if (document.length > 6)
            document[6] = "[B] borra el contenido de la linea activa";
        if (document.length > 7)
            document[7] = "[C] copiar la linea activa";
        if (document.length > 8)
            document[8] = "[P] pegar en la linea activa";
        if (document.length > 9)
            document[9] = "[S] sale del programa";
        if (document.length > 10)
            document[10] = "[Z] deshacer la última acción";
        if (document.length > 11)
            document[11] = "[Y] rehacer la última acción";
    }

    public void run() {
        do {
            print();
        } while (processActions());
    }

    private void print() {
        clearScreen();
        printHorizontalLine();
        showLines();
        printHorizontalLine();
    }

    private void showLines() {
        for (int line = 0; line < document.length; line++) {
            System.out.println(line + separator(line) + document[line]);
        }
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

    private boolean processActions() {
        System.out.println(
                "Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [P]egar | [S]alir | [Z] deshacer | [Y] rehacer");

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
            case 'C':
            case 'c':
                copy();
                break;
            case 'P':
            case 'p':
                paste();
                break;
            case 'Z':
            case 'z':
                undo();
                break;
            case 'Y':
            case 'y':
                redo();
                break;
        }
        return true;
    }

    private char askChar() {
        return input.next().charAt(0);
    }

    private void delete() {
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo ["
                + activeLine + "]");
        if (askInt() == activeLine) {
            undoRedoManager.saveState(document);
            document[activeLine] = "";
        }
    }

    private void exchangeLines() {
        int originLine = askLine("Indique primera línea a intercambiar: ");
        int destinationLine = askLine("Indique segunda línea a intercambiar: ");

        undoRedoManager.saveState(document);
        String temp = document[originLine];
        document[originLine] = document[destinationLine];
        document[destinationLine] = temp;
    }

    private void edit() {
        System.out.println("EDITANDO> " + document[activeLine]);
        undoRedoManager.saveState(document);
        document[activeLine] = askString();
    }

    private String askString() {
        input.nextLine();
        return input.nextLine();
    }

    private void setActiveLine() {
        activeLine = askLine("Indique la nueva línea activa: ");
    }

    private int askLine(String prompt) {
        int line;
        boolean validLine;
        do {
            System.out.print(prompt);
            line = askInt();
            validLine = line >= 0 && line < document.length;
        } while (!validLine);
        return line;
    }

    private int askInt() {
        return input.nextInt();
    }

    private void undo() {
        if (undoRedoManager.undo(document)) {
            System.out.println("Acción deshecha.");
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }

    private void redo() {
        if (undoRedoManager.redo(document)) {
            System.out.println("Acción rehecha.");
        } else {
            System.out.println("No hay acciones para rehacer.");
        }
    }

    private void copy() {
        copiedLine = document[activeLine];
        System.out.println("Línea copiada: " + copiedLine);
    }

    private void paste() {
        if (copiedLine != null) {
            undoRedoManager.saveState(document);
            document[activeLine] = copiedLine;
            System.out.println("Línea pegada: " + copiedLine);
        } else {
            System.out.println("No hay línea copiada para pegar.");
        }
    }
}
