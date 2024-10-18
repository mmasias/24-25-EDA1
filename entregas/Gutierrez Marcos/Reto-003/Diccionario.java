public class Diccionario {
    private List secuencias;

    public Diccionario() {
        secuencias = new List();
    }

    public boolean contiene(String string) {
        String[] elementos = secuencias.listAll();
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i].equals(string)) {
                return true;
            }
        }
        return false;
    }

    public void agregar(String valueOf) {
        secuencias.insertEnd(valueOf);
    }

    public int buscar(String secuencia) {
        String[] elementos = secuencias.listAll();
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i].equals(secuencia)) {
                return i;
            }
        }
        return -1;
    }
}