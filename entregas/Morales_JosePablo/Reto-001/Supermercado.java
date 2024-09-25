import java.util.Random;

public class Supermercado {

    private Fila fila1;
    private Fila fila2;
    private int contadorClientes;

    public Supermercado() {
        fila1 = new Fila(10);
        fila2 = new Fila(10);
        contadorClientes = 1;
    }
}

public void inicializarFilas(int maxClientes) {
    Random random = new Random();
    int clientesFila1 = random.nextInt(maxClientes) + 1;
    int clientesFila2 = random.nextInt(maxClientes) + 1;

    int contadorClientes;
    for (int i = 0; i < clientesFila1; i++) {
        Fila fila1;
        fila1.agregarCliente(new Cliente(contadorClientes++));
    }

    for (int i = 0; i < clientesFila2; i++) {
        Fila fila2;
        fila2.agregarCliente(new Cliente(contadorClientes++));
    }

    System.out.println("Filas inicializadas.");
    mostrarFilas();
}