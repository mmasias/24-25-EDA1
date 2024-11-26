package Reto004;
public class Album {

    
    private Nodo inicio;
    private Nodo fin;
    
    public Album(String titulo, String artista, int año) {
       
        this.inicio = null;
        this.fin = null;
    }

    public void agregarCancion(Cancion cancion) {
        Nodo nuevoNodo = new Nodo(cancion);
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
            inicio.siguiente = inicio;
            inicio.anterior = inicio;
        } else {
            fin.siguiente = nuevoNodo;
            nuevoNodo.anterior = fin;
            nuevoNodo.siguiente = inicio;
            inicio.anterior = nuevoNodo;
            fin = nuevoNodo;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== SPOTIFY ===\n\nBIBLIOTECA INICIAL\n\nCanciones disponibles:\n\n");
        if (inicio != null) {
            Nodo actual = inicio;
            int index = 1;
            do {
                sb.append(index).append(". ").append(actual.cancion.toString()).append("\n");
                actual = actual.siguiente;
                index++;
            } while (actual != inicio);
        }
        return sb.toString();
    }
    

}
