import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Persona {
    String nombre;

    Persona(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

class Fila {
    private Queue<Persona> fila;
    private Random random;

    Fila() {
        this.fila = new LinkedList<>();
        this.random = new Random();
    }

    public void agregarPersona(Persona p) {
        fila.add(p);
        System.out.println(p + " se ha unido a la fila.");
    }

    public void atenderPersona() {
        if (!fila.isEmpty()) {
            Persona atendida = fila.poll();
            System.out.println(atendida + " ha sido atendido.");
        } else {
            System.out.println("No hay nadie en la fila.");
        }
    }

    public void personaSeAbandona() {
        if (!fila.isEmpty()) {
            Persona abandonada = fila.poll();
            System.out.println(abandonada + " se ha aburrido y se ha ido.");
        } else {
            System.out.println("No hay nadie en la fila para abandonar.");
        }
    }

    public void traerCosas(Persona p) {
        System.out.println(p + " ha recibido sus cosas de otra persona en la fila.");
    }

    public void colarseLicitamente(Persona p) {
        fila.add(p);
        System.out.println(p + " se ha colado lícitamente en la fila.");
    }

    public void colarseIlicitamente() {
        Persona p = new Persona("Persona " + random.nextInt(100));
        fila.add(p);
        System.out.println(p + " se ha colado ilícitamente en la fila.");
    }

    public void anuncio() {
        System.out.println("¡Pasen por esta caja en orden de fila!");
    }

    public void mostrarFila() {
        System.out.println("Estado actual de la fila: " + fila);
    }
}

public class CentroComercial {
    public static void main(String[] args) {
        Fila fila = new Fila();

        
        fila.agregarPersona(new Persona("Alice"));
        fila.agregarPersona(new Persona("Bob"));
        fila.mostrarFila();

        fila.atenderPersona();
        fila.mostrarFila();

        fila.personaSeAbandona();
        fila.mostrarFila();

        fila.traerCosas(new Persona("Charlie"));
        fila.colarseLicitamente(new Persona("Diana"));
        fila.mostrarFila();

        fila.colarseIlicitamente();
        fila.mostrarFila();

        fila.anuncio();
    }
}
