import java.util.LinkedList;
import java.util.Queue;

// Clase que representa a una persona en la fila
class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

// Clase que representa la fila del centro comercial
class Fila {
    private Queue<Persona> fila;

    public Fila() {
        this.fila = new LinkedList<>();
    }

    // Método para abrir una fila (iniciar la cola)
    public void abrirFila() {
        System.out.println("Se abre una nueva fila.");
        fila.clear();
    }

    // Método para agregar una persona a la fila
    public void agregarPersona(Persona persona) {
        fila.add(persona);
        System.out.println(persona.getNombre() + " se ha unido a la fila.");
    }

    // Método para atender a la persona en la primera posición de la fila
    public void atenderPersona() {
        if (!fila.isEmpty()) {
            Persona atendido = fila.poll();
            System.out.println(atendido.getNombre() + " ha sido atendido.");
        } else {
            System.out.println("No hay personas en la fila para atender.");
        }
    }

    // Método para remover a una persona de la fila si se aburre y se va
    public void irseFila(Persona persona) {
        if (fila.remove(persona)) {
            System.out.println(persona.getNombre() + " se ha aburrido y se fue.");
        } else {
            System.out.println(persona.getNombre() + " no está en la fila.");
        }
    }

    // Método para permitir que una persona se cuele lícitamente en una posición específica
    public void colarPersonaLicito(Persona persona, int posicion) {
        if (posicion >= 0 && posicion <= fila.size()) {
            LinkedList<Persona> lista = new LinkedList<>(fila);
            lista.add(posicion, persona);
            fila = new LinkedList<>(lista);
            System.out.println(persona.getNombre() + " se ha colado lícitamente en la posición " + posicion + ".");
        } else {
            System.out.println("Posición no válida.");
        }
    }

    // Método para permitir que una persona se cuele ilícitamente en la fila (en segunda posición)
    public void colarPersonaIlicito(Persona persona) {
        if (!fila.isEmpty()) {
            LinkedList<Persona> lista = new LinkedList<>(fila);
            lista.add(1, persona); // Insertar en la segunda posición de la fila.
            fila = new LinkedList<>(lista);
            System.out.println(persona.getNombre() + " se ha colado ilícitamente.");
        }
    }

    // Imprimir el estado actual de la fila
    public void imprimirFila() {
        System.out.println("Fila actual: " + fila);
    }
}

// Clase principal que representa el centro comercial y el comportamiento de la fila
public class CentroComercial {
    public static void main(String[] args) {
        Fila fila = new Fila();
        fila.abrirFila();

        // Crear algunas personas para la simulación
        Persona p1 = new Persona("Juan");
        Persona p2 = new Persona("Ana");
        Persona p3 = new Persona("Carlos");
        Persona p4 = new Persona("Pedro");
        Persona p5 = new Persona("Lucía");

        // Agregar personas a la fila
        fila.agregarPersona(p1);
        fila.agregarPersona(p2);
        fila.agregarPersona(p3);

        // Imprimir la fila actual
        fila.imprimirFila();

        // Atender a la primera persona de la fila
        fila.atenderPersona();

        // Imprimir la fila actual
        fila.imprimirFila();

        // Una persona se aburre y se va de la fila
        fila.irseFila(p2);

        // Imprimir la fila actual
        fila.imprimirFila();

        // Alguien se cuela lícitamente en la segunda posición
        fila.colarPersonaLicito(p4, 1);

        // Imprimir la fila actual
        fila.imprimirFila();

        // Alguien se cuela ilícitamente en la fila
        fila.colarPersonaIlicito(p5);

        // Imprimir la fila actual
        fila.imprimirFila();
    }
}
