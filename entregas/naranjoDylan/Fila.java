import java.util.Random;

public class Fila {
    private String[] cola;
    private int tamaño;
    private Random random;

    public Fila(int capacidad) {
        cola = new String[capacidad];
        tamaño = 0;
        random = new Random();
    }

    public void llegaGente() {
        if (tamaño < cola.length) {
            cola[tamaño] = "Cliente " + (tamaño + 1);
            System.out.println(cola[tamaño] + " ha llegado a la fila.");
            tamaño++;
            dibujarFila(); // Dibuja la fila después de que alguien llegue
        } else {
            System.out.println("La fila está llena.");
        }
    }

    public void expulsarCliente() {
        if (tamaño > 0) {
            System.out.println(cola[0] + " ha salido de la fila.");
            desplazarAdelante();
            tamaño--;
            dibujarFila(); // Dibuja la fila después de que alguien se vaya
        } else {
            System.out.println("No hay nadie en la fila para salir.");
        }
    }

    public void probabilidadDeAburrise() {
        if (tamaño > 0) {
            int posicion = random.nextInt(tamaño);
            System.out.println(cola[posicion] + " se ha aburrido y ha salido de la fila.");
            desplazarFila(posicion);
            tamaño--;
            dibujarFila(); // Dibuja la fila después de que alguien se aburra
        } else {
            System.out.println("No hay nadie en la fila para aburrirse.");
        }
    }

    public void traerCosas(int posicion, String pack) {
        if (posicion >= 0 && posicion < tamaño) {
            System.out.println(cola[posicion] + " ha recibido un " + pack + ".");
        } else {
            System.out.println("Posición inválida.");
        }
    }

    public void colarseLicitamente() {
        if (tamaño < cola.length) {
            desplazarFilaHaciaAtras(0);
            cola[0] = "Cliente " + (tamaño + 1);
            System.out.println(cola[0] + " se ha colado lícitamente al principio de la fila.");
            tamaño++;
            dibujarFila(); // Dibuja la fila después de que alguien se cuela lícitamente
        } else {
            System.out.println("La fila está llena.");
        }
    }

    public void colarseIlicitamente() {
        if (tamaño < cola.length) {
            int posicion = random.nextInt(tamaño + 1);
            desplazarFilaHaciaAtras(posicion);
            cola[posicion] = "Cliente " + (tamaño + 1);
            System.out.println(cola[posicion] + " se ha colado ilícitamente en la posición " + posicion + ".");
            tamaño++;
            dibujarFila(); // Dibuja la fila después de que alguien se cuela ilícitamente
        } else {
            System.out.println("La fila está llena.");
        }
    }

    public void anunciarNuevaFila() {
        if (tamaño > 5) {
            System.out.println("Pasen por esta caja en orden de fila...");
        }
    }

    private void desplazarAdelante() {
        for (int i = 0; i < tamaño - 1; i++) {
            cola[i] = cola[i + 1];
        }
        cola[tamaño - 1] = null;
    }

    private void desplazarFila(int posicion) {
        for (int i = posicion; i < tamaño - 1; i++) {
            cola[i] = cola[i + 1];
        }
        cola[tamaño - 1] = null;
    }

    private void desplazarFilaHaciaAtras(int posicion) {
        for (int i = tamaño; i > posicion; i--) {
            cola[i] = cola[i - 1];
        }
    }

    // Método para "dibujar" la fila en la consola
    private void dibujarFila() {
        System.out.println("\nEstado actual de la fila:");
        for (int i = 0; i < cola.length; i++) {
            if (i < tamaño) {
                System.out.print("| " + cola[i] + " ");
            } else {
                System.out.print("| ____ ");
            }
        }
        System.out.println("|");
        System.out.println();
    }

    public static void main(String[] args) {
        Fila fila = new Fila(10);

        fila.llegaGente();
        fila.llegaGente();
        fila.expulsarCliente();
        fila.probabilidadDeAburrise();
        fila.colarseLicitamente();
        fila.colarseIlicitamente();
        fila.anunciarNuevaFila();
    }
}
