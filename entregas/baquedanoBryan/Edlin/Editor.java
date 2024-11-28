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

    
    
}
