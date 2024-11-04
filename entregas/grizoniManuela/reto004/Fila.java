package entregas.grizoniManuela.reto004;

public class Fila {
    private Cancion[] fila;
    private int frente;
    private int finalFila;
    private int capacidad;
    private int tamaño;

    public Fila(int capacidad) {
        this.capacidad = capacidad;
        this.fila = new Cancion[capacidad];
        this.frente = 0;
        this.finalFila = -1;
        this.tamaño = 0;
    }

    public void encolar(Cancion cancion) {
        if (estaLlena()) {
            System.out.println("La cola de reproducción está llena.");
        } else {
            finalFila = (finalFila + 1) % capacidad;
            fila[finalFila] = cancion;
            tamaño++;
        }
    }

    public Cancion desencolar() {
        if (estaVacia()) {
            System.out.println("La cola de reproducción está vacía.");
            return null;
        } else {
            Cancion cancion = fila[frente];
            frente = (frente + 1) % capacidad;
            tamaño--;
            return cancion;
        }
    }

    public Cancion verFrente() {
        if (estaVacia()) {
            System.out.println("No hay canciones en la cola.");
            return null;
        } else {
            return fila[frente];
        }
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public boolean estaLlena() {
        return tamaño == capacidad;
    }

    public int tamaño() {
        return tamaño;
    }

    public void mostrarFila() {
        if (estaVacia()) {
            System.out.println("La cola de reproducción está vacía.");
        } else {
            System.out.println("COLA DE REPRODUCCIÓN:");
            for (int i = 0; i < tamaño; i++) {
                int indice = (frente + i) % capacidad;
                System.out.println((i + 1) + ". " + fila[indice].toString());
            }
        }
    }
}
