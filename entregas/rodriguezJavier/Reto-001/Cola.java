import java.util.Scanner;

class Supermercado {
    private static final int MAX_PERSONAS = 10;  // Capacidad máxima de la cola
    private String[] colaPersonas = new String[MAX_PERSONAS];  // Arreglo para la cola
    private int frente = 0;  // Puntero que indica el frente de la cola
    private int fin = 0;     // Puntero que indica el final de la cola
    private int tamano = 0;  // Cantidad actual de personas en la cola

    // Método para agregar una persona a la cola
    public void agregarPersona(String persona) {
        if (tamano == MAX_PERSONAS) {
            System.out.println("La cola está llena. No se pueden unir más personas.");
        } else {
            colaPersonas[fin] = persona;
            fin = (fin + 1) % MAX_PERSONAS;
            tamano++;
            System.out.println(persona + " se ha unido a la cola.");
        }
    }

    // Método para atender a la persona al frente de la cola
    public void atenderPersona() {
        if (tamano == 0) {
            System.out.println("No hay personas en la cola.");
        } else {
            System.out.println("Se ha atendido a " + colaPersonas[frente]);
            frente = (frente + 1) % MAX_PERSONAS;
            tamano--;
        }
    }

    // Método para mostrar todas las personas en la cola
    public void mostrarPersonas() {
        if (tamano == 0) {
            System.out.println("No hay personas en la cola.");
        } else {
            System.out.print("Personas en la cola: ");
            for (int i = 0; i < tamano; i++) {
                int index = (frente + i) % MAX_PERSONAS;
                System.out.print(colaPersonas[index] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();
        Scanner scanner = new Scanner(System.in);

        // Simulación: Ingresar 5 personas
        String[] personas = {"Juan", "Ana", "Pedro", "Lucía", "Carlos"};
        for (String persona : personas) {
            supermercado.agregarPersona(persona);
        }

        // Mostrar todas las personas en la cola
        supermercado.mostrarPersonas();

        // Simulación: Atender a 3 personas
        for (int i = 0; i < 3; i++) {
            supermercado.atenderPersona();
        }

        // Mostrar todas las personas en la cola después de atender
        supermercado.mostrarPersonas();

        // Simulación: Agregar 2 personas más
        supermercado.agregarPersona("Marta");
        supermercado.agregarPersona("Luis");

        // Mostrar el estado final de la cola
        supermercado.mostrarPersonas();

        scanner.close();
    }
}
