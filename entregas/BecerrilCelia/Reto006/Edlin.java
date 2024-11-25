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
            default:
                System.out.println("Comando no reconocido.");
        }
        document.printDocument(); // Mostrar el contenido del documento después de cada comando
        return true;
    }

    public void printCommands() {
        System.out.println("Comandos disponibles:");
        System.out.println("[L] permite definir la linea activa");
        System.out.println("[E] permite editar la linea activa");
        System.out.println("[I] permite intercambiar dos lineas");
        System.out.println("[B] borra el contenido de la linea activa");
        System.out.println("[S] sale del programa");
    }

    public static void main(String[] args) {
        Edlin edlin = new Edlin();
        boolean continueEditing = true;

        edlin.printCommands();
        edlin.document.printDocument(); // Mostrar el contenido del documento al inicio

        while (continueEditing) {
            char command = UserInput.askChar();
            continueEditing = edlin.processCommand(command);
        }
    }
}