
import java.io.Serializable;

class Editor implements Serializable {

    private static final long serialVersionUID = 1L;

    private String[] documento;
    private int lineaActiva;
    private String portapapeles;
    private String[][] pilaDeshacer;
    private String[][] pilaRehacer;
    private int indiceDeshacer;
    private int indiceRehacer;

    public Editor(int numLineas) {
        documento = new String[numLineas];
        for (int i = 0; i < numLineas; i++) {
            documento[i] = "";
        }
        lineaActiva = 0;
        portapapeles = "";
        pilaDeshacer = new String[100][];
        pilaRehacer = new String[100][];
        indiceDeshacer = -1;
        indiceRehacer = -1;
    }

    public void imprimir() {
        limpiarPantalla();
        imprimirLineaHorizontal();
        for (int linea = 0; linea < documento.length; linea++) {
            System.out.println(linea + separador(linea, lineaActiva) + documento[linea]);
        }
        imprimirLineaHorizontal();
    }

    public void establecerLineaActiva(int nuevaLinea) {
        if (nuevaLinea >= 0 && nuevaLinea < documento.length) {
            lineaActiva = nuevaLinea;
        } else {
            System.out.println("Número de línea no válido.");
        }
    }

    public int getLineaActiva() {
        return lineaActiva;
    }

    public void guardarEstadoDeshacer() {
        if (indiceDeshacer < pilaDeshacer.length - 1) {
            pilaDeshacer[++indiceDeshacer] = documento.clone();
            indiceRehacer = -1;
        }
    }

    public void editar(String nuevoTexto) {
        guardarEstadoDeshacer();
        documento[lineaActiva] = nuevoTexto;
    }

    public void borrar() {
        guardarEstadoDeshacer();
        documento[lineaActiva] = "";
    }

    public void copiar() {
        portapapeles = documento[lineaActiva];
    }

    public void pegar() {
        if (!portapapeles.isEmpty()) {
            guardarEstadoDeshacer();
            documento[lineaActiva] = portapapeles;
            System.out.println("Pegado en línea " + lineaActiva);
        } else {
            System.out.println("El portapapeles está vacío.");
        }
    }

    public void intercambiarLineas(int lineaDestino) {
        if (lineaDestino >= 0 && lineaDestino < documento.length) {
            guardarEstadoDeshacer();
            String temporalLinea = documento[lineaDestino];
            documento[lineaDestino] = documento[lineaActiva];
            documento[lineaActiva] = temporalLinea;
        } else {
            System.out.println("Número de línea no válido.");
        }
    }

    public void deshacer() {
        if (indiceDeshacer >= 0) {
            pilaRehacer[++indiceRehacer] = documento.clone();
            documento = pilaDeshacer[indiceDeshacer--];
            System.out.println("Deshecho.");
        } else {
            System.out.println("No hay más acciones para deshacer.");
        }
    }

    public void rehacer() {
        if (indiceRehacer >= 0) {
            pilaDeshacer[++indiceDeshacer] = documento.clone();
            documento = pilaRehacer[indiceRehacer--];
            System.out.println("Rehecho.");
        } else {
            System.out.println("No hay más acciones para rehacer.");
        }
    }

    private String separador(int linea, int lineaActiva) {
        return linea == lineaActiva ? ":*| " : ": | ";
    }

    private void imprimirLineaHorizontal() {
        System.out.println("-".repeat(50));
    }

    private void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
