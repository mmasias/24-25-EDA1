package entregas.grizoniManuela.reto004;

public class Historial {
    private Cancion[] historial;
    private int capacidad;
    private int tamaño;
    private int indiceActual;

    public Historial(int capacidad) {
        this.capacidad = capacidad;
        this.historial = new Cancion[capacidad];
        this.tamaño = 0;
        this.indiceActual = 0;
    }

    public void agregarCancion(Cancion cancion) {
        historial[indiceActual] = cancion;
        indiceActual = (indiceActual + 1) % capacidad;
        if (tamaño < capacidad) {
            tamaño++;
        }
    }

    public void mostrarHistorial() {
        System.out.println("HISTORIAL DE REPRODUCCIÓN:");
        for (int i = 0; i < tamaño; i++) {
            int indice = (indiceActual + i) % capacidad;
            System.out.println((i + 1) + ". " + historial[indice].toString());
        }
    }

    public boolean estaVacio() {
        return tamaño == 0;
    }
}
