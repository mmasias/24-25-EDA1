import java.util.LinkedList;
import java.util.Queue;

public class ColaSupermercado {
    // Cola para la fila de personas
    private Queue<String> fila;

    public ColaSupermercado() {
        fila = new LinkedList<>();
    }

    // Método para añadir gente a la fila
    public void llegaPersona(String nombre) {
        fila.add(nombre);
        System.out.println(nombre + " ha llegado a la fila.");
        mostrarFila();
        mensajeCentroComercial();
    }

    // Método para que la primera persona en la fila sea atendida
    public void atenderPersona() {
        if (!fila.isEmpty()) {
            String personaAtendida = fila.poll();
            System.out.println(personaAtendida + " está siendo atendido.");
        } else {
            System.out.println("No hay nadie en la fila para atender.");
        }
        mostrarFila();
    }

    // Método para que una persona se aburra y se vaya de la fila
    public void personaSeVa(String nombre) {
        if (fila.contains(nombre)) {
            fila.remove(nombre);
            System.out.println(nombre + " se ha ido de la fila.");
        } else {
            System.out.println(nombre + " no está en la fila.");
        }
        mostrarFila();
    }

    // Método para que alguien le traiga las cosas a otra persona en la fila
    public void traeCosas(String nombre) {
        if (fila.contains(nombre)) {
            System.out.println("A " + nombre + " le han traído las cosas mientras está en la fila.");
        } else {
            System.out.println(nombre + " no está en la fila.");
        }
        mostrarFila();
    }

    // Método para que alguien se cuele lícitamente (por ejemplo, con permiso)
    public void colarseLicitamente(String nombre) {
        if (!fila.isEmpty()) {
            ((LinkedList<String>) fila).addFirst(nombre);
            System.out.println(nombre + " se ha colado lícitamente al frente de la fila.");
        } else {
            llegaPersona(nombre); // Si la fila está vacía, la persona simplemente entra a la fila
        }
        mostrarFila();
    }

    // Método para que alguien se cuele ilícitamente (sin permiso)
    public void colarseIlicitamente(String nombre) {
        if (!fila.isEmpty()) {
            ((LinkedList<String>) fila).add(1, nombre);  // Se cuela en la segunda posición.
            System.out.println(nombre + " se ha colado ilícitamente en la fila.");
        } else {
            llegaPersona(nombre); // Si la fila está vacía, simplemente se añade.
}
        mostrarFila();
    }

    // Método que muestra el mensaje cuando hay mucha gente en la fila
    public void mensajeCentroComercial() {
        if (fila.size() > 5) {  // Suponemos que 'mucha gente' es más de 5 personas
            System.out.println("Desde el centro comercial se oye: 'Pasen por esta caja en orden de fila...'");
        }
    }

    // Método para mostrar la fila actual
    public void mostrarFila() {
        System.out.println("Personas en la fila: " + fila);
    }

    public static void main(String[] args) {
        ColaSupermercado cola = new ColaSupermercado();

        // Simulación de situaciones:
        // Gente llega a la fila
        cola.llegaPersona("Juan");
        cola.llegaPersona("Ana");
        cola.llegaPersona("Luis");
        cola.llegaPersona("Marta");
        cola.llegaPersona("Pedro");

        // Alguien se cuela ilícitamente
        cola.colarseIlicitamente("Carlos");

        // La primera persona es atendida
        cola.atenderPersona();

        // Alguien se va de la fila porque se aburrió
        cola.personaSeVa("Marta");

        // A alguien le traen cosas mientras espera
        cola.traeCosas("Pedro");

        // Alguien se cuela lícitamente
        cola.colarseLicitamente("Sara");

        // La primera persona es atendida de nuevo
        cola.atenderPersona();

        // Más personas llegan a la fila
        cola.llegaPersona("Elena");
        cola.llegaPersona("José");

        // Revisamos el mensaje cuando hay mucha gente
        cola.mensajeCentroComercial();

        // Continuar con el ciclo de eventos, si es necesario...
    }
}
