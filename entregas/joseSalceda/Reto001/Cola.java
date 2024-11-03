import java.util.ArrayList;

public class Cola {
    private ArrayList<Persona> cola;
    private int capacidad;
    private boolean abierta;
    private String nombre;

    public Cola(String nombre, int capacidad) {
        this.nombre = nombre;
        this.cola = new ArrayList<>();
        this.capacidad = capacidad;
        this.abierta = true;
    }

    public boolean estaLlena() {
        return cola.size() >= capacidad;
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public void agregarPersona(Persona p) {
        if (abierta && !estaLlena()) {
            cola.add(p);
        } else {
            System.out.println("¡La " + nombre + " está llena o cerrada!");
        }
    }

    public void agregarPersonaEnPosicion(Persona p, int posicion) {
        if (abierta && !estaLlena() && posicion >= 0 && posicion <= cola.size()) {
            cola.add(posicion, p);
        } else {
            System.out.println("No se puede añadir a la persona en la posición " + posicion + " en la " + nombre);
        }
    }

    public Persona removerPersona() {
        if (!cola.isEmpty()) {
            return cola.remove(0);
        } else {
            System.out.println("¡La " + nombre + " está vacía!");
            return null;
        }
    }

    public void removerPersonaEnPosicion(int posicion) {
        if (!cola.isEmpty() && posicion >= 0 && posicion < cola.size()) {
            cola.remove(posicion);
        } else {
            System.out.println("No se puede remover a la persona en la posición " + posicion + " en la " + nombre);
        }
    }

    public void cerrarCola() {
        abierta = false;
    }

    public boolean estaAbierta() {
        return abierta;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Persona> obtenerUltimasPersonas(int n) {
        int tamano = cola.size();
        if (tamano >= n) {
            return new ArrayList<>(cola.subList(tamano - n, tamano));
        } else {
            return new ArrayList<>(cola);
        }
    }

    public void removerUltimasPersonas(int n) {
        for (int i = 0; i < n && !cola.isEmpty(); i++) {
            cola.remove(cola.size() - 1);
        }
    }

    public int getTamano() {
        return cola.size();
    }

    public void imprimirCola() {
        System.out.print(nombre + ": ");
        for (Persona p : cola) {
            System.out.print("[p" + p.getId() + "] ");
        }
        System.out.println();
    }
}
