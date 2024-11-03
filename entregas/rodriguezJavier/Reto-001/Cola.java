import java.util.Scanner;
import java.util.Random;

class Persona {
    String nombre;
    int items;

    public Persona(String nombre, int items) {
        this.nombre = nombre;
        this.items = items;
    }
}

class Supermercado {
    private static final int MAX_PERSONAS = 10;
    private Persona[] colaPersonas = new Persona[MAX_PERSONAS];
    private int frente = 0;
    private int fin = 0;
    private int tamano = 0;
    private Random random = new Random();

    public void agregarPersona(String nombre) {
        if (tamano == MAX_PERSONAS) {
            System.out.println("La cola está llena. No se pueden unir más personas.");
        } else {
            int items = random.nextInt(5) + 1;
            Persona persona = new Persona(nombre, items);
            colaPersonas[fin] = persona;
            fin = (fin + 1) % MAX_PERSONAS;
            tamano++;
            System.out.println(persona.nombre + " se ha unido a la cola con " + items + " ítems.");
        }
    }

    public void atenderPersona() {
        if (tamano == 0) {
            System.out.println("No hay personas en la cola.");
        } else {
            System.out.println("Se ha atendido a " + colaPersonas[frente].nombre + " con " + colaPersonas[frente].items + " ítems.");
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
                System.out.print(colaPersonas[index].nombre + " (Items: " + colaPersonas[index].items + ") ");
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
                System.out.println(colaPersonas[indexAbandono].nombre + " se ha ido por aburrimiento.");
                for (int j = indexAbandono; j != fin; j = (j + 1) % MAX_PERSONAS) {
                    colaPersonas[j] = colaPersonas[(j + 1) % MAX_PERSONAS];
                }
                fin = (fin - 1 + MAX_PERSONAS) % MAX_PERSONAS;
                tamano--;
            }
        }
    }

    public void colarseIlicitamente(String nombre) {
        if (tamano < MAX_PERSONAS) {
            int items = random.nextInt(5) + 1;
            Persona persona = new Persona(nombre, items);
            int posColarse = random.nextInt(tamano + 1);
            System.out.println(persona.nombre + " se ha colado ilicitamente en la posición " + (posColarse + 1) + " con " + items + " ítems.");
            for (int i = tamano; i > posColarse; i--) {
                colaPersonas[(frente + i) % MAX_PERSONAS] = colaPersonas[(frente + i - 1) % MAX_PERSONAS];
            }
            colaPersonas[(frente + posColarse) % MAX_PERSONAS] = persona;
            fin = (fin + 1) % MAX_PERSONAS;
            tamano++;
        } else {
            System.out.println("La cola está llena. No se puede colar " + nombre + ".");
        }
    }

    public void colarseLicitamente(String nombre) {
        if (tamano < MAX_PERSONAS) {
            Persona persona = new Persona(nombre, 0);
            colaPersonas[fin] = persona;
            fin = (fin + 1) % MAX_PERSONAS;
            tamano++;
            System.out.println(persona.nombre + " se ha colado licitamente al final de la cola con 0 ítems.");
        } else {
            System.out.println("La cola está llena. No se puede colar " + nombre + ".");
        }
    }

    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();
        Scanner scanner = new Scanner(System.in);

        String[] personas = {"Juan", "Ana", "Pedro", "Lucía", "Carlos"};
        for (String nombre : personas) {
            supermercado.agregarPersona(nombre);
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

        String nuevaPersonaIlícita = "Elena";
        supermercado.colarseIlicitamente(nuevaPersonaIlícita);
        supermercado.mostrarPersonas();

        String nuevaPersonaLícita = "Pedro II";
        supermercado.colarseLicitamente(nuevaPersonaLícita);
        supermercado.mostrarPersonas();

        scanner.close();
    }
}
