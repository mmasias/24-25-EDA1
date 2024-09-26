import java.util.Arrays;

class Fila {
    private Persona[] fila;
    private int capacidad;
    private int cantidadActual;

    public Fila(int capacidad) {
        this.capacidad = capacidad;
        this.fila = new Persona[capacidad];
        this.cantidadActual = 0;
    }

    // Abrir fila (inicializada vacía)
    public void abrirFila() {
        Arrays.fill(fila, null);
        cantidadActual = 0;
        System.out.println("Fila abierta.");
    }

    // Agregar persona a la fila
    public void agregarPersona(Persona p) {
        if (cantidadActual < capacidad) {
            fila[cantidadActual++] = p;
            System.out.println(p + " se ha añadido a la fila.");
        } else {
            System.out.println("La fila está llena.");
        }
    }

    // Atender a la persona en la primera posición
    public void atenderPersona() {
        if (cantidadActual > 0) {
            Persona atendida = fila[0];
            for (int i = 0; i < cantidadActual - 1; i++) {
                fila[i] = fila[i + 1];
            }
            fila[--cantidadActual] = null;
            System.out.println(atendida + " ha sido atendida.");
        } else {
            System.out.println("No hay nadie en la fila.");
        }
    }

    // Persona se va de la fila (por índice)
    public void irseDeFila(int indice) {
        if (indice < cantidadActual && indice >= 0) {
            Persona queSeVa = fila[indice];
            for (int i = indice; i < cantidadActual - 1; i++) {
                fila[i] = fila[i + 1];
            }
            fila[--cantidadActual] = null;
            System.out.println(queSeVa + " se ha ido de la fila.");
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    // Traer cosas a una persona en la fila
    public void traerCosasA(int indice) {
        if (indice < cantidadActual && indice >= 0) {
            System.out.println(fila[indice] + " ha recibido cosas de alguien más.");
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    // Alguien se cuela lícitamente
    public void colarLicita(Persona p) {
        if (cantidadActual < capacidad) {
            for (int i = cantidadActual; i > 0; i--) {
                fila[i] = fila[i - 1];
            }
            fila[0] = p;
            cantidadActual++;
            System.out.println(p + " se ha colado lícitamente en la fila.");
        } else {
            System.out.println("La fila está llena.");
        }
    }

    // Alguien se cuela ilícitamente
    public void colarIlicita(Persona p, int indice) {
        if (indice < cantidadActual && indice >= 0 && cantidadActual < capacidad) {
            for (int i = cantidadActual; i > indice; i--) {
                fila[i] = fila[i - 1];
            }
            fila[indice] = p;
            cantidadActual++;
            System.out.println(p + " se ha colado ilícitamente en la posición " + indice);
        } else {
            System.out.println("No es posible colar a la persona.");
        }
    }

    // Anunciar cuando hay mucha gente
    public void anunciar() {
        if (cantidadActual > capacidad / 2) {
            System.out.println("Pasen por esta caja en orden de fila...");
        } else {
            System.out.println("La fila no está tan llena aún.");
        }
    }

    // Mostrar la fila actual
    public void mostrarFila() {
        System.out.println("Fila actual:");
        for (int i = 0; i < cantidadActual; i++) {
            System.out.println((i + 1) + ". " + fila[i]);
        }
    }
}
