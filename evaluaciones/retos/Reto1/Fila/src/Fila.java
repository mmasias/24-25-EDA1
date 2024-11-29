class Fila {
    private String[] fila;
    private int capacidadMaxima;
    private int numPersonas;

    public Fila(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.fila = new String[capacidadMaxima];
        this.numPersonas = 0;
    }


    public void abrirFila() {
        for (int i = 0; i < capacidadMaxima; i++) {
            fila[i] = null;
        }
        numPersonas = 0;
        System.out.println("Se ha abierto una nueva fila.");
    }

    public void llegarGente() {
        if (numPersonas < capacidadMaxima) {
            fila[numPersonas] = "Persona";
            numPersonas++;
            System.out.println("Ha llegado una persona a la fila. Personas en fila: " + numPersonas);
        } else {
            System.out.println("La fila está llena. No puede entrar más gente.");
        }
    }


    public void pasarASerAtendido() {
        if (numPersonas > 0) {
            System.out.println("Una persona ha pasado a ser atendida.");
            for (int i = 1; i < numPersonas; i++) {
                fila[i - 1] = fila[i];
            }
            fila[numPersonas - 1] = null;
            numPersonas--;
            System.out.println("Personas en fila: " + numPersonas);
        } else {
            System.out.println("La fila está vacía, nadie para ser atendido.");
        }
    }


    public void irseDeLaFila() {
        if (numPersonas > 0) {
            System.out.println("Una persona se ha ido de la fila.");
            // Desplazamos a todos hacia adelante.
            for (int i = 1; i < numPersonas; i++) {
                fila[i - 1] = fila[i];
            }
            fila[numPersonas - 1] = null;
            numPersonas--;
            System.out.println("Personas en fila: " + numPersonas);
        } else {
            System.out.println("La fila está vacía, nadie se puede ir.");
        }
    }


    public void colarseLicitamente() {
        if (numPersonas < capacidadMaxima) {
            for (int i = numPersonas; i > 1; i--) {
                fila[i] = fila[i - 1];
            }
            fila[1] = "Persona";
            numPersonas++;
            System.out.println("Una persona se ha colado lícitamente. Personas en fila: " + numPersonas);
        } else {
            System.out.println("La fila está llena. No puede colarse nadie más.");
        }
    }


    public void colarseIlicitamente() {
        if (numPersonas < capacidadMaxima) {
            fila[numPersonas] = "Persona";
            numPersonas++;
            System.out.println("Una persona se ha colado ilícitamente. Personas en fila: " + numPersonas);
        } else {
            System.out.println("La fila está llena. No puede colarse nadie más.");
        }
    }


    public void anunciarOrdenFila() {
        if (numPersonas == capacidadMaxima) {
            System.out.println("Pasen por esta caja en orden de fila... Personas en fila: " + numPersonas);
        }
    }


    public void mostrarFila() {
        System.out.println("Personas en fila: " + numPersonas);
    }


    public void vaciarFila() {
        while (numPersonas > 0) {
            pasarASerAtendido();
        }
        System.out.println("La fila está vacía. Ejercicio finalizado.");
    }
}