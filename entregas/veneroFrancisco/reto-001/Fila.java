public class Fila {
    private int capacidad;
    private String[] personas;
    private int contador;

    public Fila(int capacidad) {
        this.capacidad = capacidad;
        this.personas = new String[capacidad];
        this.contador = 0;
    }

    public void abrirFila() {
        System.out.println("La fila ha sido abierta.");
    }

    public void agregarPersona(String nombre) {
        if (contador < capacidad) {
            personas[contador] = nombre;
            contador++;
            System.out.println(nombre + " ha llegado a la fila.");
        } else {
            System.out.println("La fila está llena.");
        }
    }

    public void atenderPersona() {
        if (contador > 0) {
            String personaAtendida = personas[0];
            for (int i = 0; i < contador; i++) {
                personas[i - 1] = personas[i];
            }
            contador--;
            System.out.println(personaAtendida + " ha sido atendida.");
        } else {
            System.out.println("No hay personas en la fila.");
        }
    }
}

