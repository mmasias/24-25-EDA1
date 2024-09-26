import java.util.Scanner;
import java.util.Random;

class Supermercado {
    private static final int MAX_PERSONAS = 10;
    private String[] colaPersonas = new String[MAX_PERSONAS];
    private int frente = 0;
    private int fin = 0;
    private int tamano = 0;
    private Random random = new Random();

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

    public void atenderPersona() {
        if (tamano == 0) {
            System.out.println("No hay personas en la cola.");
        } else {
            System.out.println("Se ha atendido a " + colaPersonas[frente]);
            frente = (frente + 1) % MAX_PERSONAS;
            tamano--;
        }
    }

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

    public void verificarAbandono() {
        int personasAbandono = random.nextInt(3);
        for (int i = 0; i < personasAbandono; i++) {
            if (tamano > 0) {
                int indexAbandono = frente + random.nextInt(tamano);
                indexAbandono = indexAbandono % MAX_PERSONAS;
                System.out.println(colaPersonas[indexAbandono] + " se ha ido por aburrimiento.");
                for (int j = indexAbandono; j != fin; j = (j + 1) % MAX_PERSONAS) {
                    colaPersonas[j] = colaPersonas[(j + 1) % MAX_PERSONAS];
                }
                fin = (fin - 1 + MAX_PERSONAS) % MAX_PERSONAS;
                tamano--;
            }
        }
    }

    public void colarseLicitamente(String persona) {
        if (tamano < MAX_PERSONAS) {
            int posColarse = random.nextInt(tamano + 1);
            System.out.println(persona + " se ha colado licitamente en la posición " + (posColarse + 1) + ".");
            for (int i = tamano; i > posColarse; i--) {
                colaPersonas[(frente + i) % MAX_PERSONAS] = colaPersonas[(frente + i - 1) % MAX_PERSONAS];
            }
            colaPersonas[(frente + posColarse) % MAX_PERSONAS] = persona;
            fin = (fin + 1) % MAX_PERSONAS;
            tamano++;
        } else {
            System.out.println("La cola está llena. No se puede colar " + persona + ".");
        }
    }

    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();
        Scanner scanner = new Scanner(System.in);

        String[] personas = {"Juan", "Ana", "Pedro", "Lucía", "Carlos"};
        for (String persona : personas) {
            supermercado.agregarPersona(persona);
        }

        supermercado.mostrarPersonas();

        for (int i = 0; i < 3; i++) {
            supermercado.verificarAbandono();
            supermercado.atenderPersona();
            supermercado.mostrarPersonas();
        }

        supermercado.agregarPersona("Marta");
        supermercado.agregarPersona("Luis");

        supermercado.mostrarPersonas();

        String nuevaPersona = "Elena";
        supermercado.colarseLicitamente(nuevaPersona);
        supermercado.mostrarPersonas();

        scanner.close();
    }
}
