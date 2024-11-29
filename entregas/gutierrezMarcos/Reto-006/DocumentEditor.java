import java.util.Scanner;

public class DocumentEditor {
    private Document document;
    private History history;
    private Scanner input;
    private String clipboard;

    public DocumentEditor() {
        this.document = new Document(new String[]{
                "Bienvenidos al editor EDLIN",
                "Utilice el menu inferior para editar el texto",
                "------",
                "[L] permite definir la linea activa",
                "[E] permite editar la linea activa",
                "[I] permite intercambiar dos lineas",
                "[B] borra el contenido de la linea activa",
                "[C] copia el contenido de la línea activa",
                "[P] pega el contenido copiado en la línea activa",
                "[Z] deshacer la última acción",
                "[Y] rehacer la última acción deshecha",
                "[S] sale del programa",
                "",
                ""
        });
        this.history = new History(document);
        this.input = new Scanner(System.in);
        this.clipboard = "";
    }

    public void run() {
        do {
            document.print();
        } while (processActions());
    }

    private boolean processActions() {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]Copiar | [P]Pegar | [Z]Deshacer | [Y]Rehacer | [S]alir");
        char action = askChar();

        switch (Character.toLowerCase(action)) {
            case 's':
                return false;
            case 'l':
                history.save(document);
                document.setActiveLine(askInt("Indique la nueva línea activa: "));
                break;
            case 'e':
                history.save(document);
                document.editLine(askString("EDITANDO> " + document.getActiveLineContent()));
                break;
            case 'i':
                history.save(document);
                int originLine = askInt("Indique primera línea a intercambiar: ");
                int destinationLine = askInt("Indique segunda línea a intercambiar: ");
                document.exchangeLines(originLine, destinationLine);
                break;
            case 'b':
                int confirmLine = askInt("Esta acción es irreversible: indique el número de línea activa para confirmarlo [" + document.getActiveLineIndex() + "]: ");
                if (confirmLine == document.getActiveLineIndex()) {
                    history.save(document);
                    document.deleteLine();
                }
                break;
            case 'c':
                clipboard = document.getActiveLineContent();
                System.out.println("Línea copiada: \"" + clipboard + "\"");
                break;
            case 'p':
                history.save(document);
                document.editLine(clipboard);
                System.out.println("Contenido pegado en la línea activa.");
                break;
            case 'z':
                history.undo(document);
                break;
            case 'y':
                history.redo(document);
                break;
        }
        return true;
    }

    private char askChar() {
        return input.next().charAt(0);
    }

    private int askInt(String prompt) {
        System.out.print(prompt);
        return input.nextInt();
    }

    private String askString(String prompt) {
        System.out.println(prompt);
        input.nextLine();
        return input.nextLine();
    }
}