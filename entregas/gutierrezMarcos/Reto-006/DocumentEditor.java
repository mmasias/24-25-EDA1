import java.util.Scanner;

public class DocumentEditor {
    private Document document;
    private History history;
    private Scanner input;
    private String clipboard;
    private FileManager fileManager;

    public DocumentEditor() {
        this.document = new Document(new String[]{
                "Bienvenidos al editor EDLIN",
                "Utilice el menú inferior para editar el texto",
                "------",
                "[L] permite definir la línea activa",
                "[E] permite editar la línea activa",
                "[I] permite intercambiar dos líneas",
                "[B] borra el contenido de la línea activa",
                "[C] copia el contenido de la línea activa",
                "[P] pega el contenido copiado en la línea activa",
                "[Z] deshacer la última acción",
                "[Y] rehacer la última acción deshecha",
                "[G] guarda el documento en archivo",
                "[R] carga el documento desde archivo",
                "[D] elimina una línea del archivo",
                "[S] sale del programa",
                "",
                ""
        });
        this.history = new History(document);
        this.input = new Scanner(System.in);
        this.clipboard = "";
        this.fileManager = new FileManager("documento.txt");
    }

    public void run() {
        do {
            document.print();
        } while (processActions());
    }

    private boolean processActions() {
        System.out.println("Comandos: [L]ínea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]Copiar | [P]Pegar | [Z]Deshacer | [Y]Rehacer | [G]uardar | [R]ecuperar | [D]elete línea | [S]alir");
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
            case 'g':
                guardarDocumentoEnArchivo();
                break;
            case 'r':
                cargarDocumentoDesdeArchivo();
                break;
            case 'd':
                eliminarLineaArchivo();
                break;
        }
        return true;
    }

    private void guardarDocumentoEnArchivo() {
        String contenido = String.join("\n", document.getLines());
        if (fileManager.createFile(contenido)) {
            System.out.println("Documento guardado exitosamente en 'documento.txt'.");
        } else {
            System.err.println("Error al guardar el documento.");
        }
    }

    private void cargarDocumentoDesdeArchivo() {
        String contenido = fileManager.readFile();
        if (contenido != null) {
            String[] lineas = contenido.split(System.lineSeparator());
            document.setLines(lineas);
            System.out.println("Documento cargado exitosamente desde 'documento.txt'.");
        } else {
            System.err.println("Error al cargar el documento.");
        }
    }

    private void eliminarLineaArchivo() {
        int linea = askInt("Indique el número de línea a eliminar del archivo: ");
        if (fileManager.deleteLine(linea)) {
            System.out.println("Línea eliminada exitosamente del archivo.");
        } else {
            System.err.println("Error al eliminar la línea del archivo.");
        }
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