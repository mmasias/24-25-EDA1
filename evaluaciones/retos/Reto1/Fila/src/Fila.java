class Fila {
    private String[] fila;       // Matriz que representa la fila de personas.
    private int capacidadMaxima;  // Capacidad máxima de la fila.
    private int numPersonas;      // Contador de cuántas personas hay actualmente en la fila.

    public Fila(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.fila = new String[capacidadMaxima];  // Inicializa la matriz con la capacidad dada.
        this.numPersonas = 0;                     // Al inicio no hay personas en la fila.
    }

    // Abrir fila
    public void abrirFila() {
        for (int i = 0; i < capacidadMaxima; i++) {
            fila[i] = null;  // Inicializa todas las posiciones de la fila como vacías (null).
        }
        numPersonas = 0;     // Reinicia el número de personas a 0.
        System.out.println("Se ha abierto una nueva fila.");
    }

    // Llega gente a la fila
    public void llegarGente() {
        if (numPersonas < capacidadMaxima) {         // Verifica si hay espacio en la fila.
            fila[numPersonas] = "Persona";           // Añade una persona a la primera posición libre.
            numPersonas++;                           // Aumenta el contador de personas en la fila.
            System.out.println("Ha llegado una persona a la fila. Personas en fila: " + numPersonas);
        } else {
            System.out.println("La fila está llena. No puede entrar más gente.");
        }
    }

    // La primera persona pasa a ser atendida
    public void pasarASerAtendido() {
        if (numPersonas > 0) {               // Verifica si hay alguien en la fila.
            System.out.println("Una persona ha pasado a ser atendida.");
            // Desplaza a todos los que siguen en la fila una posición hacia adelante.
            for (int i = 1; i < numPersonas; i++) {
                fila[i - 1] = fila[i];
            }
            fila[numPersonas - 1] = null;    // La última posición ahora está vacía.
            numPersonas--;                   // Disminuye el número de personas en la fila.
            System.out.println("Personas en fila: " + numPersonas);
        } else {
            System.out.println("La fila está vacía, nadie para ser atendido.");
        }
    }

    // Gente se va de la fila
    public void irseDeLaFila() {
        if (numPersonas > 0) {                     // Verifica si hay alguien en la fila.
            System.out.println("Una persona se ha ido de la fila.");
            // Desplazamos a todos hacia adelante.
            for (int i = 1; i < numPersonas; i++) {
                fila[i - 1] = fila[i];
            }
            fila[numPersonas - 1] = null;         // La última posición ahora está vacía.
            numPersonas--;                        // Disminuye el número de personas en la fila.
            System.out.println("Personas en fila: " + numPersonas);
        } else {
            System.out.println("La fila está vacía, nadie se puede ir.");
        }
    }

    // Alguien se cuela lícitamente (detrás del primero)
    public void colarseLicitamente() {
        if (numPersonas < capacidadMaxima) {       // Verifica si hay espacio en la fila.
            for (int i = numPersonas; i > 1; i--) { // Desplaza a las personas desde la posición 1 en adelante.
                fila[i] = fila[i - 1];
            }
            fila[1] = "Persona";                  // Coloca una persona detrás del primero.
            numPersonas++;                         // Incrementa el número de personas.
            System.out.println("Una persona se ha colado lícitamente. Personas en fila: " + numPersonas);
        } else {
            System.out.println("La fila está llena. No puede colarse nadie más.");
        }
    }

    // Alguien se cuela ilícitamente (se coloca al final)
    public void colarseIlicitamente() {
        if (numPersonas < capacidadMaxima) {     // Verifica si hay espacio en la fila.
            fila[numPersonas] = "Persona";       // Coloca una persona al final de la fila.
            numPersonas++;                       // Incrementa el número de personas.
            System.out.println("Una persona se ha colado ilícitamente. Personas en fila: " + numPersonas);
        } else {
            System.out.println("La fila está llena. No puede colarse nadie más.");
        }
    }

    // Anunciar cuando hay mucha gente
    public void anunciarOrdenFila() {
        if (numPersonas == capacidadMaxima) {  // Si la fila está llena...
            System.out.println("Pasen por esta caja en orden de fila... Personas en fila: " + numPersonas);
        }
    }

    // Mostrar estado de la fila
    public void mostrarFila() {
        System.out.println("Personas en fila: " + numPersonas);
    }

    // Vaciar completamente la fila
    public void vaciarFila() {
        while (numPersonas > 0) {
            pasarASerAtendido();  // Atiende a todas las personas hasta que la fila quede vacía.
        }
        System.out.println("La fila está vacía. Ejercicio finalizado.");
    }
}