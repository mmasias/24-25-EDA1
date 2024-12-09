import java.util.Scanner;

class DocumentEditor {
    private final Scanner input;
    private final String[] document;
    private final UndoRedoManager undoRedoManager;
    private final FileManager fileManager;
    private int activeLine = 0;
    private String copiedLine = null;

    public DocumentEditor(int documentSize, int maxUndo, Scanner input, String filePath) {
        this.input = input;
        this.document = new String[documentSize];
        this.undoRedoManager = new UndoRedoManager(maxUndo, documentSize);
        this.fileManager = new FileManager(filePath);
        initializeDocument();
    }

    private void initializeDocument() {
        String fileContent = fileManager.readFile();
        if (fileContent != null) {
            String[] lines = fileContent.split(System.lineSeparator());
            for (int i = 0; i < document.length && i < lines.length; i++) {
                document[i] = lines[i];
            }
        } else {
            for (int i = 0; i < document.length; i++) {
                document[i] = "";
            }
        }
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
                "Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [P]egar | [S]alir | [Z] deshacer | [Y] rehacer | [F]ile operations");

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
            case 'F':
            case 'f':
                fileOperations();
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

    private void fileOperations() {
        System.out.println("Comandos de archivo: [C]rear | [R]ead | [U]pdate | [D]elete | [L]ine delete");
        switch (askChar()) {
            case 'C':
            case 'c':
                createFile();
                break;
            case 'R':
            case 'r':
                readFile();
                break;
            case 'U':
            case 'u':
                updateFile();
                break;
            case 'D':
            case 'd':
                deleteFile();
                break;
            case 'L':
            case 'l':
                deleteLine();
                break;
        }
    }

    private void createFile() {
        System.out.print("Ingrese el contenido del archivo: ");
        String content = askString();
        if (fileManager.createFile(content)) {
            System.out.println("Archivo creado exitosamente.");
        } else {
            System.out.println("Error al crear el archivo.");
        }
    }

    private void readFile() {
        String content = fileManager.readFile();
        if (content != null) {
            System.out.println("Contenido del archivo:");
            System.out.println(content);
        } else {
            System.out.println("Error al leer el archivo.");
        }
    }

    private void updateFile() {
        int lineNumber = askLine("Ingrese el número de línea a actualizar: ");
        System.out.print("Ingrese el nuevo contenido de la línea: ");
        String newLine = askString();
        if (fileManager.updateLine(lineNumber, newLine)) {
            System.out.println("Línea actualizada exitosamente.");
        } else {
            System.out.println("Error al actualizar la línea.");
        }
    }

    private void deleteFile() {
        if (fileManager.deleteFile()) {
            System.out.println("Archivo eliminado exitosamente.");
        } else {
            System.out.println("Error al eliminar el archivo.");
        }
    }

    private void deleteLine() {
        int lineNumber = askLine("Ingrese el número de línea a eliminar: ");
        if (fileManager.deleteLine(lineNumber)) {
            System.out.println("Línea eliminada exitosamente.");
        } else {
            System.out.println("Error al eliminar la línea.");
        }
    }
}