import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Fila {

    private Queue<Cliente> fila;
    private int capacidadMaxima;

    public Fila(int capacidadMaxima) {
        this.fila = new LinkedList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    public void agregarCliente(Cliente cliente) {
        if (fila.size() < capacidadMaxima) {
            fila.add(cliente);
        } else {
            System.out.println("La fila está llena. No se pueden agregar más clientes.");
        }
    }

    public void atenderCliente() {
        if (!fila.isEmpty()) {
            Cliente atendido = fila.poll();
            System.out.println("Cliente atendido: " + atendido.mostrarCliente());
        } else {
            System.out.println("No hay clientes para atender.");
        }
    }

    public void clienteAburrido() {
        if (!fila.isEmpty()) {
            Cliente aburrido = fila.poll();
            System.out.println("Cliente aburrido se ha ido: " + aburrido.mostrarCliente());
        } else {
            System.out.println("No hay clientes en la fila.");
        }
    }

    public void colarseIllicitamente(Cliente cliente) {
        if (fila.size() < capacidadMaxima) {
            Random random = new Random();
            int posicion = random.nextInt(fila.size() + 1);
            LinkedList<Cliente> listaClientes = new LinkedList<>(fila);
            listaClientes.add(posicion, cliente);
            fila = new LinkedList<>(listaClientes);
        } else {
            System.out.println("La fila está llena. No se pueden agregar más clientes.");
        }
    }

    public void mostrarFila() {
        System.out.print("Clientes en la fila: ");
        for (Cliente cliente : fila) {
            System.out.print(cliente.mostrarCliente() + " ");
        }
        System.out.println();
    }

    public int getTotalClientes() {
        return fila.size();
    }
}