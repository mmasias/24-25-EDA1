public class Editor {
    private String[] document;
    private Pila historialDeshacer;
    private Pila historialRehacer;
    private String portapapeles;
    private int lineaActiva;

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

    public int getLineaActiva() {
        return this.lineaActiva;
    }

    private boolean lineaValida(int linea) {
        return linea >= 0 && linea < document.length;
    }

    public void editar(int linea, String nuevoContenido) {
        if (!lineaValida(linea)) {
            System.out.println("Línea no válida.");
            return;
        }
        historialDeshacer.push(document.clone()); 
        document[linea] = nuevoContenido;
    }

    public void borrar(int linea) {
        if (!lineaValida(linea)) {
            System.out.println("Línea no válida.");
            return;
        }
        historialDeshacer.push(document.clone()); 
        document[linea] = "";
    }

    public void intercambiar(int linea1, int linea2) {
        if (!lineaValida(linea1) || !lineaValida(linea2)) {
            System.out.println("Una o ambas líneas no son válidas.");
            return;
        }
        historialDeshacer.push(document.clone()); 
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

    public void deshacer() {
        if (!historialDeshacer.isEmpty()) {
            String[] ultimaVersion = (String[]) historialDeshacer.pop();
            historialRehacer.push(document.clone()); 
            document = ultimaVersion;
            System.out.println("Deshacer realizado.");
        } else {
            System.out.println("No hay cambios para deshacer.");
        }
    }

    public void rehacer() {
        if (!historialRehacer.isEmpty()) {
            String[] siguienteVersion = (String[]) historialRehacer.pop();
            historialDeshacer.push(document.clone());
            document = siguienteVersion;
            System.out.println("Rehacer realizado.");
        } else {
            System.out.println("No hay cambios para rehacer.");
        }
    }

    public void copiar() {
        if (lineaValida(lineaActiva)) {
            portapapeles = document[lineaActiva];
            System.out.println("Línea copiada al portapapeles.");
        } else {
            System.out.println("Línea activa no válida.");
        }
    }

    public void pegar() {
        if (lineaValida(lineaActiva)) {
            if (portapapeles != null) {
                document[lineaActiva] = portapapeles;
                System.out.println("Contenido del portapapeles pegado en la línea " + lineaActiva);
            } else {
                System.out.println("El portapapeles está vacío.");
            }
        } else {
            System.out.println("Línea activa no válida.");
        }
    }
}
