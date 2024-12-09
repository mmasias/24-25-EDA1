
import java.io.*;

class SerializadorEditor {

    public static void serializar(Editor editor, String rutaArchivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            out.writeObject(editor);
            System.out.println("Editor guardado correctamente en " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el editor: " + e.getMessage());
        }
    }

    public static Editor deserializar(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("El archivo " + rutaArchivo + " no existe. Por favor, verifica el nombre.");
            return null;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            Editor editor = (Editor) in.readObject();
            System.out.println("Editor cargado correctamente desde " + rutaArchivo);
            return editor;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el editor: " + e.getMessage());
            return null;
        }
    }
}
