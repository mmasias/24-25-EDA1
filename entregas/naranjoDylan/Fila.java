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
        } else {
            System.out.println("La fila está llena.");
        }
    }

    public void expulsarCliente() {
        if (tamaño > 0) {
            System.out.println(cola[0] + " ha salidos de la fila.");
            desplazarFila();
            tamaño--;
        } else {
            System.out.println("No hay nadie en la fila para salir.");
        }
    }

    public void probabilidadDeAburrise() {
        if (tamaño > 0) {
            int posicion = random.nextInt(tamaño);
            String pack = "Pack " + (random.nextInt(10)) + 1);
            traerCosas(posicion, pack);
        }
    }

    public void traerCosas(int posicion, String pack) {
        if (posicion >= 0 && posicion < tamaño) {
            System.out.println(cola[posicion] + " ha recibido un " + pack + ".");
        } else {
            System.out.println("Posición inválida");
        }
    }

    public void colarseLicitamente() {
        if (tamaño < cola.length) {
            desplazarFilaHaciaAtras(0);
            cola[0] = "Cliente " + (tamaño + 1);
            System.out.println(cola[0] + " se ha colado lícitamente al principio de la fila.");
            tamaño++;
        } else {
            System.out.println("La fila está llena");
        }
    }

    public void colarseIlicitamente() {
        if (tamaño < cola.length) {
            int posicion = random.nextInt(tamaño + 1);
            desplazarFilaHaciaAtras(posicion);
            cola[posicion] = "Cliente " + (tamaño + 1);
            System.out.println(cola[posicion] + " se ha colado ilícitamente en la posición " + posicion + ".");
            tamaño++;
        } else {
            System.out.println("La fila está llena.");
        }
    }

    public void anunciarNuevaFila() {
        if (tamaño > 5) {
            System.out.println("Pasen por esta caja en oren de fila...");
        }
    }

}