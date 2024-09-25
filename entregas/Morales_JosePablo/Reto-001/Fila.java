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