import java.util.Random;

public class Fila {
    private Persona[] fila;
    private int capacidad;
    private int contador;
    private Random random;

    public Fila(int capacidad) {
        this.capacidad = capacidad;
        this.fila = new Persona[capacidad];
        this.contador = 0;
        this.random = new Random();
    }

    
    public boolean añadirPersona(Persona persona) {
        if (contador < capacidad) {
            fila[contador] = persona;
            contador++;
            System.out.println(persona.getNombre() + " ha llegado a la fila.");
            return true;
        } else {
            System.out.println("La fila está llena, " + persona.getNombre() + " no puede entrar.");
            return false;
        }
    }

    
    public Persona atenderPersona() {
        if (contador == 0) {
            System.out.println("La fila está vacía, no hay a quién atender.");
            return null;
        }
        Persona atendida = fila[0];
        for (int i = 1; i < contador; i++) {
            fila[i - 1] = fila[i];
        }
        fila[contador - 1] = null;
        contador--;
        System.out.println("Se ha atendido a: " + atendida.getNombre());
        return atendida;
    }

    
    public void quitarPersonaAleatoriamente() {
        if (contador == 0) {
            System.out.println("La fila está vacía, nadie se puede ir.");
            return;
        }
        int index = random.nextInt(contador);
        String nombre = fila[index].getNombre();
        System.out.println(nombre + " se ha ido de la fila.");
        for (int i = index; i < contador - 1; i++) {
            fila[i] = fila[i + 1];
        }
        fila[contador - 1] = null;
        contador--;
    }

    
    public void colarLicitaAleatoria(Persona persona) {
        if (contador < capacidad) {
            int posicion = random.nextInt(contador + 1); 
            for (int i = contador; i > posicion; i--) {
                fila[i] = fila[i - 1];
            }
            fila[posicion] = persona;
            contador++;
            System.out.println(persona.getNombre() + " se ha colado lícitamente en la posición " + (posicion + 1));
        } else {
            System.out.println("No es posible colarse porque la fila está llena.");
        }
    }

    
    public void colarIlicita(Persona persona) {
        if (contador < capacidad) {
            for (int i = contador; i > 0; i--) {
                fila[i] = fila[i - 1];
            }
            fila[0] = persona;
            contador++;
            System.out.println(persona.getNombre() + " se ha colado ilícitamente.");
        } else {
            System.out.println(persona.getNombre() + " no puede colarse porque la fila está llena.");
        }
    }

    
    public void mostrarFila() {
        System.out.println("Fila actual:");
        for (int i = 0; i < contador; i++) {
            System.out.println((i + 1) + ". " + fila[i].getNombre());
        }
    }
}
