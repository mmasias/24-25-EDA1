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

public void atenderFila1() {
    Object fila1;
    ((Object) fila1).atenderCliente();
}

public void atenderFila2() {
    Object fila2;
    ((Object) fila2).atenderCliente();
}

public void aburrirseFila1() {
    Fila fila1;
    fila1.clienteAburrido();
}

public void aburrirseFila2() {
    Fila fila2;
    fila2.clienteAburrido();
}

public void colarseLicitamenteFila1() {
    Fila fila1;
    int contadorClientes;
    fila1.agregarCliente(new Cliente(contadorClientes++));
    System.out.println("Un cliente se ha colado lícitamente en la fila 1.");
}

public void colarseIlicitamenteFila2() {
    Fila fila2;
    int contadorClientes;
    fila2.agregarCliente(new Cliente(contadorClientes++));
    System.out.println("Un cliente se ha colado ilícitamente en la fila 2.");
}