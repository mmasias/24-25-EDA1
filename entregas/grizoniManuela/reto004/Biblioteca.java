
package entregas.grizoniManuela.reto004;

public class Biblioteca {
    private Cancion[] canciones;  // Arreglo de canciones
    private int tamaño;           // Número de canciones actual

    public Biblioteca(int capacidad) {
        canciones = new Cancion[capacidad];  // Capacidad máxima del array
        tamaño = 0;
    }

    public void agregarCancion(Cancion cancion) {
        if (tamaño < canciones.length) {
            canciones[tamaño++] = cancion;
        } else {
            System.out.println("Biblioteca llena. No se pueden añadir más canciones.");
        }
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
}

