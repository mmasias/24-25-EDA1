import java.util.Stack;

public class CopyPasteManager {
    private Stack<String> clipboardHistory = new Stack<>();
    private String clipboard;

    public void copiarDesdeEditor(String contenido) {
        clipboard = contenido;
        clipboardHistory.push(contenido);
    }

    public void pegarEnArchivo(Archivo archivo) {
        if (clipboard != null) {
            archivo.contenido = clipboard;
            archivo.fechaModificacion = new Date();
        }
    }

    public void pegarEnEditor(String[] document, int[] activeLine) {
        if (clipboard != null) {
            document[activeLine[0]] = clipboard;
        }
    }
}
