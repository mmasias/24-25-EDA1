import java.util.LinkedList;
import java.util.Queue;

public class Cola {
    private Queue<Cliente> cola;

    public Cola() {
        this.cola = new LinkedList<>();
    }

    public void agregarPersona(Cliente cliente) {
        cola.add(cliente);
    }

    public Cliente siguientePersona() {
        return cola.poll();
    }

    public int personasEnCola() {
        return cola.size();
    }
}