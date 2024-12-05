package entregas.tasconRaul.Reto_006;
import java.util.Scanner;

public class Document {
    private String[] lines;
    private String clipboard = "";

    public Document(int size) {
        this.lines = new String[size];
    }

    public void initializeDefaultContent() {
        lines[0] = "Bienvenidos al editor EDLIN";
        lines[1] = "Utilice el menu inferior para editar el texto";
        lines[2] = "------";
        lines[3] = "[L] permite definir la linea activa";
        lines[4] = "[E] permite editar la linea activa";
        lines[5] = "[I] permite intercambiar dos lineas";
        lines[6] = "[B] borra el contenido de la linea activa";
        lines[7] = "[S] sale del programa";
        lines[8] = "";
        lines[9] = "";
    }

    public void print(int[] activeLine) {
        Utils.clearScreen(); // Método de Utils
        printHorizontalLine();
        for (int i = 0; i < lines.length; i++) {
            System.out.println(i + separator(i, activeLine[0]) + lines[i]);
        }
        printHorizontalLine();
    }

    private String separator(int line, int activeLine) {
        return line == activeLine ? ":*| " : ": | ";
    }

    private void printHorizontalLine() {
        System.out.println("-".repeat(50));
    }

    public void setActiveLine(int[] activeLine) {
        boolean valid;
        do {
            System.out.print("Indique la nueva línea activa: ");
            activeLine[0] = Utils.askInt(); // Método de Utils
            valid = activeLine[0] >= 0 && activeLine[0] < lines.length;
        } while (!valid);
    }

    public void edit(int[] activeLine) {
        System.out.println("EDITANDO> " + lines[activeLine[0]]);
        lines[activeLine[0]] = Utils.askString(); // Método de Utils
    }

    public void delete(int[] activeLine) {
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo [" + activeLine[0] + "]");
        if (Utils.askInt() == activeLine[0]) { // Método de Utils
            lines[activeLine[0]] = "";
        }
    }

    public void exchangeLines() {
        int originLine = Utils.askInt("Indique primera línea a intercambiar: "); // Método de Utils
        int destinationLine = Utils.askInt("Indique segunda línea a intercambiar: "); // Método de Utils

        String temp = lines[originLine];
        lines[originLine] = lines[destinationLine];
        lines[destinationLine] = temp;
    }

    public void copy(int[] activeLine) {
        clipboard = lines[activeLine[0]];
        System.out.println("Copiado: " + clipboard);
    }

    public void paste(int[] activeLine) {
        if (clipboard.isEmpty()) {
            System.out.println("El portapapeles está vacío.");
        } else {
            lines[activeLine[0]] = clipboard;
            System.out.println("Pegado: " + clipboard);
        }
    }

    public String[] getLines() {
        return lines.clone();
    }

    public void setLines(String[] newLines) {
        System.arraycopy(newLines, 0, lines, 0, lines.length);
    }
}
