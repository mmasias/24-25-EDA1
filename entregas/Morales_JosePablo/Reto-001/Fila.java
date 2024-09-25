import java.util.Random;

public class Fila {

    private Cliente[] clientes;
    private int cantidadClientes;

    public Fila(int maxClientes) {
        clientes = new Cliente[maxClientes];
        cantidadClientes = 0;
    }

    public void agregarCliente(Cliente cliente) {
        if (cantidadClientes < clientes.length) {
            clientes[cantidadClientes++] = cliente;
        } else {
            System.out.println("La fila está llena.");
        }
    }

public void clienteAburrido () {
    if (cantidadClientes > 0) {
        Cliente atendido = clientes[0];
        System.arraycopy(clientes, 1, clientes, 0, cantidadClientes - 1);
        cantidadClientes--;
        System.out.println(atendido.mostrarCliente() + " ha sido atendido.");
    } else {
        System.out.println("La fila está vacía.");
    }
}
public void clienteAburrido() {
    if (cantidadClientes > 0) {
        Random random = new Random();
        int index = random.nextInt(cantidadClientes);
        Cliente aburrido = clientes[index];
        System.arraycopy(clientes, index + 1, clientes, index, cantidadClientes - index - 1);
        cantidadClientes--;
        System.out.println(aburrido.mostrarCliente() + " se ha aburrido y se fue.");
    } else {
        System.out.println("La fila está vacía.");
    }
}

public void mostrarFila() {
    if (cantidadClientes == 0) {
        System.out.println("La fila está vacía.");
    } else {
        System.out.print("Clientes en la fila: ");
        for (int i = 0; i < cantidadClientes; i++) {
            System.out.print(clientes[i].mostrarCliente() + " ");
        }
        System.out.println();
    }
}
}