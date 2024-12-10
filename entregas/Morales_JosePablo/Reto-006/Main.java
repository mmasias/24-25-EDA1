public class Main {
    public static void main(String[] args) {
        CopyPasteManager copyPasteManager = new CopyPasteManager();
        UndoRedoManager undoRedoManager = new UndoRedoManager();
        FileManager fileManager = new FileManager();
        ControlVersiones controlVersiones = new ControlVersiones();

        Directorio directorio = new Directorio();
        Archivo archivo = new Archivo();
        archivo.nombre = "documento.txt";
        archivo.contenido = "Este es el contenido del archivo.";
        directorio.agregarArchivo(archivo);

        Archivo copiaArchivo = copyPasteManager.copiar(archivo);
        copyPasteManager.pegar(copiaArchivo, directorio);

        try {
            fileManager.guardar(controlVersiones, "control_versiones.json");
            ControlVersiones leido = fileManager.leer("control_versiones.json");
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
