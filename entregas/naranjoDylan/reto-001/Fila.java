import java.util.Random;

public class Fila {
    private String[] cola;
    private int tamaño;
    private Random random;
    private String nombreFila;

    public Fila(int capacidad, String nombre) {
        cola = new String[capacidad];
        tamaño = 0;
        random = new Random();
        nombreFila = nombre;
    }

    public boolean llegaGente() {
        if (tamaño < cola.length) {
            cola[tamaño] = "Cliente " + (tamaño + 1);
            System.out.println(cola[tamaño] + " ha llegado a la " + nombreFila + ".");
            tamaño++;
            dibujarFila();
            return true;
        } else {
            System.out.println("La " + nombreFila + " está llena.");
            return false;
        }
    }

    public void expulsarCliente() {
        if (tamaño > 0) {
            System.out.println(cola[0] + " ha salido de la " + nombreFila + ".");
            desplazarAdelante();
            tamaño--;
            dibujarFila();
        } else {
            System.out.println("No hay nadie en la " + nombreFila + " para salir.");
        }
    }

    public void probabilidadDeAburrise() {
        if (tamaño > 0) {
            int posicion = random.nextInt(tamaño);
            System.out.println(cola[posicion] + " se ha aburrido y ha salido de la " + nombreFila + ".");
            desplazarFila(posicion);
            tamaño--;
            dibujarFila();
        } else {
            System.out.println("No hay nadie en la " + nombreFila + " para aburrirse.");
        }
    }

    public void traerCosas(int posicion, String pack) {
        if (posicion >= 0 && posicion < tamaño) {
            System.out.println(cola[posicion] + " ha recibido un " + pack + " en la " + nombreFila + ".");
        } else {
            System.out.println("Posición inválida.");
        }
    }

    public void colarseLicitamente() {
        if (tamaño < cola.length) {
            desplazarFilaHaciaAtras(0);
            cola[0] = "Cliente " + (tamaño + 1);
            System.out.println(cola[0] + " se ha colado lícitamente al principio de la " + nombreFila + ".");
            tamaño++;
            dibujarFila();
        } else {
            System.out.println("La " + nombreFila + " está llena.");
        }
    }

    public void colarseIlicitamente() {
        if (tamaño < cola.length) {
            int posicion = random.nextInt(tamaño + 1);
            desplazarFilaHaciaAtras(posicion);
            cola[posicion] = "Cliente " + (tamaño + 1);
            System.out.println(cola[posicion] + " se ha colado ilícitamente en la posición " + posicion + " de la "
                    + nombreFila + ".");
            tamaño++;
            dibujarFila();
        } else {
            System.out.println("La " + nombreFila + " está llena.");
        }
    }

    public void anunciarNuevaFila() {
        if (tamaño > 5) {
            System.out.println("Pasen para esta fila en orden de la " + nombreFila + "...");
        }
    }

    public boolean estaLlena() {
        return tamaño == cola.length;
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

    private void dibujarFila() {
        System.out.println("\nEstado actual de la " + nombreFila + ":");
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

    public static void simularFila(Fila fila1, Fila fila2) {
        for (int i = 0; i < 6; i++) {
            boolean pudoEntrar = fila1.llegaGente();
            if (!pudoEntrar) {
                System.out.println(
                        "Se ha abierto la " + fila2.nombreFila + " porque la " + fila1.nombreFila + " está llena.");
                fila2.llegaGente();
            }
        }

        fila1.expulsarCliente();
        fila1.colarseLicitamente();
        fila2.colarseIlicitamente();
        fila2.probabilidadDeAburrise();
        fila1.anunciarNuevaFila();
        fila2.anunciarNuevaFila();
    }

    public static void main(String[] args) {
        Fila fila1 = new Fila(5, "Fila 1");
        Fila fila2 = new Fila(5, "Fila 2");

        simularFila(fila1, fila2);
    }
}
