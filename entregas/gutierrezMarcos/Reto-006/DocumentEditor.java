import java.util.Scanner;

public class DocumentEditor {
    private Document document;
    private Scanner input;

    public DocumentEditor() {
        this.document = new Document(new String[]{
                "Bienvenidos al editor EDLIN",
                "Utilice el menu inferior para editar el texto",
                "------",
                "[L] permite definir la linea activa",
                "[E] permite editar la linea activa",
                "[I] permite intercambiar dos lineas",
                "[B] borra el contenido de la linea activa",
                "[S] sale del programa",
                "",
                ""
        });
        this.input = new Scanner(System.in);
    }

    public void run() {
        do {
            document.print();
        } while (processActions());
    }

    private boolean processActions() {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
        char action = askChar();

        switch (Character.toLowerCase(action)) {
            case 's':
                return false;
            case 'l':
                document.setActiveLine(askInt("Indique la nueva línea activa: "));
                break;
            case 'e':
                document.editLine(askString("EDITANDO> " + document.getActiveLineContent()));
                break;
            case 'i':
                int originLine = askInt("Indique primera línea a intercambiar: ");
                int destinationLine = askInt("Indique segunda línea a intercambiar: ");
                document.exchangeLines(originLine, destinationLine);
                break;
            case 'b':
                int confirmLine = askInt("Esta acción es irreversible: indique el número de línea activa para confirmarlo [" + document.getActiveLineIndex() + "]: ");
                if (confirmLine == document.getActiveLineIndex()) {
                    document.deleteLine();
                }
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