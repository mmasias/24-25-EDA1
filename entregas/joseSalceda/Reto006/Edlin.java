import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Edlin {
    static class DocumentState {
        ArrayList<String> content;
        int activeLine;

        DocumentState(ArrayList<String> content, int activeLine) {
            this.content = new ArrayList<>(content);
            this.activeLine = activeLine;
        }
    }

    static String clipboard = "";
    static Stack<DocumentState> undoStack = new Stack<>();
    static Stack<DocumentState> redoStack = new Stack<>();

    public static void main(String[] args) {
        ArrayList<String> document = new ArrayList<>();
        document.add("Bienvenidos al editor EDLIN");
        document.add("Utilice el menu inferior para editar el texto");
        document.add("------");
        document.add("[L] permite definir la linea activa");
        document.add("[E] permite editar la linea activa");
        document.add("[I] permite intercambiar dos lineas");
        document.add("[B] borra el contenido de la linea activa");
        document.add("[C] copia la línea activa");
        document.add("[P] pega el contenido copiado");
        document.add("[Z] deshace la última acción");
        document.add("[Y] rehace la última acción deshecha");
        document.add("[S] sale del programa");
        document.add("");
        document.add("");

        int[] activeLine = {1};
        saveState(document, activeLine[0]);

        do {
            print(document, activeLine[0]);
        } while (processActions(document, activeLine));
    }

    static void saveState(ArrayList<String> document, int activeLine) {
        undoStack.push(new DocumentState(document, activeLine));
        redoStack.clear();
    }

    static void undo(ArrayList<String> document, int[] activeLine) {
        if (!undoStack.isEmpty()) {
            DocumentState currentState = new DocumentState(document, activeLine[0]);
            redoStack.push(currentState);
            
            DocumentState previousState = undoStack.pop();
            document.clear();
            document.addAll(previousState.content);
            activeLine[0] = previousState.activeLine;
        }
    }

    static void redo(ArrayList<String> document, int[] activeLine) {
        if (!redoStack.isEmpty()) {
            DocumentState currentState = new DocumentState(document, activeLine[0]);
            undoStack.push(currentState);
            
            DocumentState nextState = redoStack.pop();
            document.clear();
            document.addAll(nextState.content);
            activeLine[0] = nextState.activeLine;
        }
    }

    static void print(ArrayList<String> document, int activeLine) {
        clearScreen();
        printHorizontalLine();
        for (int line = 0; line < document.size(); line++) {
            System.out.println(line + separator(line, activeLine) + document.get(line));
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

    static boolean processActions(ArrayList<String> document, int[] activeLine) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar");
        System.out.println("         [C]opiar | [P]egar | [Z]deshacer | [Y]rehacer | [S]alir");

        switch (askChar()) {
            case 'S': case 's':
                return false;
            case 'L': case 'l':
                setActiveLine(document, activeLine);
                break;
            case 'E': case 'e':
                edit(document, activeLine);
                break;
            case 'I': case 'i':
                exchangeLines(document);
                break;
            case 'B': case 'b':
                delete(document, activeLine);
                break;
            case 'C': case 'c':
                copyLine(document, activeLine[0]);
                break;
            case 'P': case 'p':
                pasteLine(document, activeLine[0]);
                break;
            case 'Z': case 'z':
                undo(document, activeLine);
                break;
            case 'Y': case 'y':
                redo(document, activeLine);
                break;
        }
        return true;
    }

    static void copyLine(ArrayList<String> document, int activeLine) {
        clipboard = document.get(activeLine);
        System.out.println("Línea copiada: " + clipboard);
    }

    static void pasteLine(ArrayList<String> document, int activeLine) {
        if (!clipboard.isEmpty()) {
            saveState(document, activeLine);
            document.set(activeLine, clipboard);
        }
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static void delete(ArrayList<String> document, int[] activeLine) {
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo [" + activeLine[0] + "]");
        if (askInt() == activeLine[0]) {
            saveState(document, activeLine[0]);
            document.set(activeLine[0], "");
        }
    }

    static void exchangeLines(ArrayList<String> document) {
        int originLine, destinationLine;
        String temporaryLine;
        boolean validLine = true;

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

        saveState(document, originLine);
        temporaryLine = document.get(destinationLine);
        document.set(destinationLine, document.get(originLine));
        document.set(originLine, temporaryLine);
    }

    static void edit(ArrayList<String> document, int[] activeLine) {
        System.out.println("EDITANDO> " + document.get(activeLine[0]));
        String newContent = askString();
        if (!newContent.equals(document.get(activeLine[0]))) {
            saveState(document, activeLine[0]);
            document.set(activeLine[0], newContent);
        }
    }

    static String askString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    static void setActiveLine(ArrayList<String> document, int[] activeLine) {
        boolean validLine = true;
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
}