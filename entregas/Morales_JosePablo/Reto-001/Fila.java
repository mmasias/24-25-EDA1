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
    }