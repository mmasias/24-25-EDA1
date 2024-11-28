public class Editor {
    private String[] document;
    private Pila historialDeshacer;
    private Pila historialRehacer;
    private String portapapeles;
    private int lineaActiva;

    private boolean lineaValida(int linea) {
        return linea >= 0 && linea < document.length;
    }

    public Editor(int tamanioDocumento) {
        this.document = new String[tamanioDocumento];
        for (int i = 0; i < tamanioDocumento; i++) {
            document[i] = "";
        }
        this.historialDeshacer = new Pila();
        this.historialRehacer = new Pila();
        this.portapapeles = "";
        this.lineaActiva = 0;
    }

    public void editar(int linea, String nuevoContenido) {
        if (!lineaValida(linea)) {
            System.out.println("Línea no válida.");
            return;
        }
        historialDeshacer.push(document);
        historialRehacer = new Pila();
        document[linea] = nuevoContenido;
    }

    public void borrar(int linea) {
        if (!lineaValida(linea)) {
            System.out.println("Línea no válida.");
            return;
        }
        historialDeshacer.push(document);
        historialRehacer = new Pila();
        document[linea] = "";
    }

    public void intercambiar(int linea1, int linea2) {
        if (!lineaValida(linea1) || !lineaValida(linea2)) {
            System.out.println("Una o ambas líneas no son válidas.");
            return;
        }
        historialDeshacer.push(document);
        historialRehacer = new Pila();
        String temp = document[linea1];
        document[linea1] = document[linea2];
        document[linea2] = temp;
    }


    public void setLineaActiva(int nuevaLineaActiva) {
        if (!lineaValida(nuevaLineaActiva)) {
            System.out.println("Línea no válida.");
            return;
        }
        this.lineaActiva = nuevaLineaActiva;
    }

    public void mostrarDocumento() {
        for (int i = 0; i < document.length; i++) {
            System.out.println((i == lineaActiva ? "* " : "  ") + i + ": " + document[i]);
        }
    }    
}
