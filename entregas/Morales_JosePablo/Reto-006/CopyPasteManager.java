public class CopyPasteManager {
    public Archivo copiar(Archivo archivo) {
        Archivo copia = new Archivo();
        copia.nombre = archivo.nombre;
        copia.contenido = archivo.contenido;
        copia.fechaCreacion = archivo.fechaCreacion;
        copia.fechaModificacion = archivo.fechaModificacion;
        return copia;
    }

    public void pegar(Archivo archivo, Directorio directorio) {
        directorio.agregarArchivo(archivo);
    }
}
