import java.util.Scanner;

class Edlin {
    public static void main(String[] args) {
        FileManager file=new FileManager("entregas/edlin/document.eda");
        String content=file.readFile();
        if (content==null){
        file.createFile("""
        Bienvenidos al editor EDLIN
        Utilice el menu inferior para editar el texto
        -----
        [L] permite definir la linea activa
        [E] permite editar la linea activa
        [I] permite intercambiar dos lineas
        [B] borra el contenido de la linea activa
        [S] sale del programa
        [D] deshace el último cámbio
        [R] rehace el último cámbio
        """);
        }
        NodeStack undoBuffer = new NodeStack();
        NodeStack redoBuffer=new NodeStack();
        int activeLine[] = { 1 };
        String document[] = file.readFile().split("\n");
        do {
            print(document, activeLine);
        } while (processActions(document, activeLine, undoBuffer, redoBuffer,file));
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

    static boolean processActions(String[] document, int[] activeLine, NodeStack undoBuffer, NodeStack redoBuffer, FileManager file) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir | [D]eshacer | [R]ehacer");

        switch (askChar()) {
            case 'S':   case 's':
                file.createFile(String.join("\n",document));
                return false;
            case 'L':   case 'l':
                setActiveLine(document, activeLine);
                break;
            case 'E':   case 'e':
                edit(document, activeLine, undoBuffer);
                break;
            case 'I':   case 'i':
                exchangeLines(document);
                break;
            case 'B':   case 'b':
                delete(document, activeLine, undoBuffer);
                break;
            case 'D','d':
                undo(document,activeLine,undoBuffer, redoBuffer);
                break;
            case 'R','r':
                redo(document, activeLine, undoBuffer, redoBuffer);
                break;
        }
        return true;
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static void undo(String[] document, int[] activeLine, NodeStack undoBuffer, NodeStack redoBuffer){
        Node node=undoBuffer.pop();
        if (node==null)return;
        activeLine[0]=node.getRow();
        redoBuffer.push(document[activeLine[0]], activeLine[0]);
        document[activeLine[0]]=node.getValue();
    }
    static void redo(String[] document, int[] activeLine, NodeStack undoBuffer, NodeStack redoBuffer){
        Node node=redoBuffer.pop();
        if (node==null)return;
        activeLine[0]=node.getRow();
        undoBuffer.push(document[activeLine[0]], activeLine[0]);
        document[activeLine[0]]=node.getValue();
    }

    static void delete(String[] document, int[] activeLine, NodeStack undoBuffer) {
        System.out.println("Indique el número de línea activa para confirmarlo ["+activeLine[0]+"]");
        if (askInt()==activeLine[0]) {
            undoBuffer.push(document[activeLine[0]], activeLine[0]);
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

    static void edit(String[] document, int[] activeLine, NodeStack undoBuffer) {
        System.out.println("EDITANDO> " + document[activeLine[0]]);
        undoBuffer.push(document[activeLine[0]], activeLine[0]);
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
}
