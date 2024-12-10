public class Main {
    public static void main(String[] args) {
        CopyPasteManager copyPasteManager = new CopyPasteManager();
        Directorio directorio = new Directorio();
        Archivo archivo = new Archivo();
        archivo.nombre = "documento.txt";
        archivo.contenido = "Este es el contenido del archivo.";
        directorio.agregarArchivo(archivo);

        String[] document = {
            "Primera línea del documento",
            "Segunda línea del documento",
            "Tercera línea del documento"
        };
        int[] activeLine = {1};
        copyPasteManager.copiarDesdeEditor(document[activeLine[0]]);
        copyPasteManager.pegarEnArchivo(archivo);

        System.out.println("Contenido del archivo después de pegar desde el editor:");
        System.out.println(archivo.contenido);
    }
}
