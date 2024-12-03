package evaluaciones.retos.pinedaOscar_reto01;
import java.util.ArrayList;

public class Fila {
    private ArrayList<Persona> fila;
    private int capacidad;
    private boolean abierta;
    private String nombre;

    public Fila(String nombre, int capacidad) {
        this.nombre = nombre;
        this.fila = new ArrayList<>();
        this.capacidad = capacidad;
        this.abierta = true;
    }

    public boolean estaLlena() {
        return fila.size() >= capacidad;
    }

    public boolean estaVacia() {
        return fila.isEmpty();
    }

    public void agregarPersona(Persona p) {
        if (abierta && !estaLlena()) {
            fila.add(p);
        } else {
            System.out.println("¡La " + nombre + " está llena o cerrada!");
        }
    }

    public void agregarPersonaEnPosicion(Persona p, int posicion) {
        if (abierta && !estaLlena() && posicion >= 0 && posicion <= fila.size()) {
            fila.add(posicion, p);
        } else {
            System.out.println("No se puede añadir a la persona en la posición " + posicion + " en la " + nombre);
        }
    }

    public Persona removerPersona() {
        if (!fila.isEmpty()) {
            return fila.remove(0);
        } else {
            System.out.println("¡La " + nombre + " está vacía!");
            return null;
        }
    }

    public void removerPersonaEnPosicion(int posicion) {
        if (!fila.isEmpty() && posicion >= 0 && posicion < fila.size()) {
            fila.remove(posicion);
        } else {
            System.out.println("No se puede remover a la persona en la posición " + posicion + " en la " + nombre);
        }
    }

    public void cerrarFila() {
        abierta = false;
    }

    public boolean estaAbierta() {
        return abierta;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Persona> obtenerUltimasPersonas(int n) {
        int tamano = fila.size();
        if (tamano >= n) {
            return new ArrayList<>(fila.subList(tamano - n, tamano));
        } else {
            return new ArrayList<>(fila);
        }
    }

    public void removerUltimasPersonas(int n) {
        for (int i = 0; i < n && !fila.isEmpty(); i++) {
            fila.remove(fila.size() - 1);
        }
    }

    public int getTamano() {
        return fila.size();
    }

    public void imprimirfila() {
        System.out.print(nombre + ": ");
        for (Persona p : fila) {
            System.out.print("[p" + p.getId() + "] ");
        }
        System.out.println();
    }
}