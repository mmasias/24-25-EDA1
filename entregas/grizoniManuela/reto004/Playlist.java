package entregas.grizoniManuela.reto004;

public class Playlist {
    private String nombre;
    private Cancion[] canciones;
    private int capacidad;  // Capacidad máxima de la playlist
    private int tamaño;     // Número de canciones actuales en la playlist

    public Playlist(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.canciones = new Cancion[capacidad];  // Arreglo de tamaño fijo
        this.tamaño = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCancion(Cancion cancion) {
        if (tamaño < capacidad) {
            canciones[tamaño++] = cancion;
        } else {
            System.out.println("Playlist llena. No se pueden añadir más canciones.");
        }
    }

    public void eliminarCancion(String titulo) {
        for (int i = 0; i < tamaño; i++) {
            if (canciones[i].getTitulo().equals(titulo)) {
                // Desplazar canciones a la izquierda
                for (int j = i; j < tamaño - 1; j++) {
                    canciones[j] = canciones[j + 1];
                }
                canciones[--tamaño] = null;  // Reducir tamaño y eliminar la última referencia
                System.out.println("Canción eliminada.");
                return;
            }
        }
        System.out.println("Canción no encontrada.");
    }

    public void mostrarCanciones() {
        for (int i = 0; i < tamaño; i++) {
            System.out.println((i + 1) + ". " + canciones[i].toString());
        }
    }

    public Cancion getCancion(int indice) {
        if (indice >= 0 && indice < tamaño) {
            return canciones[indice];
        }
        return null;
    }

    public int getTamaño() {
        return tamaño;
    }
}
