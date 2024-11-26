package Reto006;

public class Edlin {
    private Document document;
    private int activeLine;

    public Edlin() {
        this.document = new Document();
        this.activeLine = 0;
    }

    public boolean processCommand(char command) {
        switch (command) {
            case 'S': case 's':
                return false;
            case 'L': case 'l':
                System.out.print("Ingrese el nuevo número de línea activa: ");
                activeLine = UserInput.askInt();
                document.setActiveLine(activeLine);
                break;
            case 'E': case 'e':
                document.edit(activeLine);
                break;
            case 'I': case 'i':
                document.exchangeLines();
                break;
            case 'B': case 'b':
                document.delete(activeLine);
                break;
            case 'C': case 'c':
                System.out.print("Ingrese el número de línea que desea copiar: ");
                int lineNumber = UserInput.askInt();
                if (lineNumber >= 0 && lineNumber < 10) {
                    UserInput.copyToClipboard(document.getLine(lineNumber));
                } else {
                    System.out.println("Número de línea inválido.");
                }
                break;
            case 'P': case 'p':
                System.out.print("Ingrese el número de línea donde desea pegar: ");
                int pasteLineNumber = UserInput.askInt();
                document.setLine(pasteLineNumber, UserInput.pasteFromClipboard());
                break;
            case 'Z': case 'z':
                document.undo();
                break;
            case 'Y': case 'y':
                document.redo();
                break;
            default:
                System.out.println("Comando no reconocido.");
        }
        document.printDocument(); 
        return true;
    }

    public void printCommands() {
        System.out.println("Comandos disponibles:");
        System.out.println("[L] permite definir la linea activa");
        System.out.println("[E] permite editar la linea activa");
        System.out.println("[I] permite intercambiar dos lineas");
        System.out.println("[B] borra el contenido de la linea activa");
        System.out.println("[S] sale del programa");
        System.out.println("[C] copia el contenido de una línea");
        System.out.println("[P] pega el contenido copiado en una línea");
        System.out.println("[Z] deshacer la última operación");
        System.out.println("[Y] rehacer la última operación deshecha");
    }

    public static void main(String[] args) {
        Edlin edlin = new Edlin();
        boolean continueEditing = true;

        edlin.printCommands();
        edlin.document.printDocument(); 

        while (continueEditing) {
            char command = UserInput.askChar();
            continueEditing = edlin.processCommand(command);
        }
    }
}