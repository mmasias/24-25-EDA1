package Reto006;

public class Document {
    private static final int MAX_LINES = 10;
    private String[] lines;

    public Document() {
        this.lines = new String[MAX_LINES];
        for (int i = 0; i < MAX_LINES; i++) {
            lines[i] = ""; // Inicializar todas las líneas como cadenas vacías
        }
    }

    public void setActiveLine(int activeLine) {
        if (activeLine >= 0 && activeLine < lines.length) {
            System.out.println("Línea activa: " + lines[activeLine]);
        } else {
            System.out.println("Número de línea inválido.");
        }
    }

    public void edit(int lineNumber) {
        if (lineNumber >= 0 && lineNumber < lines.length) {
            System.out.println("Editar línea [" + lineNumber + "]: " + lines[lineNumber]);
            System.out.print("Nueva línea: ");
            lines[lineNumber] = UserInput.askString();
        } else {
            System.out.println("Número de línea inválido.");
        }
    }

    public void delete(int activeLine) {
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo [" + activeLine + "]");
        if (UserInput.askInt() == activeLine) {
            lines[activeLine] = "";
            System.out.println("Línea " + activeLine + " eliminada.");
        } else {
            System.out.println("Número de línea incorrecto. No se eliminó la línea.");
        }
    }

    public void exchangeLines() {
        System.out.print("Ingrese el número de la primera línea a intercambiar: ");
        int line1 = UserInput.askInt();
        System.out.print("Ingrese el número de la segunda línea a intercambiar: ");
        int line2 = UserInput.askInt();

        if (line1 >= 0 && line1 < lines.length && line2 >= 0 && line2 < lines.length) {
            String temp = lines[line1];
            lines[line1] = lines[line2];
            lines[line2] = temp;
            System.out.println("Líneas " + line1 + " y " + line2 + " intercambiadas.");
        } else {
            System.out.println("Número de línea inválido.");
        }
    }

    public void printDocument() {
        System.out.println("Contenido del documento:");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(i + ": " + lines[i]);
        }
    }
}