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

    public void inicializarFilas(int maxClientes) {
        Random random = new Random();
        int clientesFila1 = random.nextInt(maxClientes) + 1;
        int clientesFila2 = random.nextInt(maxClientes) + 1;

        for (int i = 0; i < clientesFila1; i++) {
            fila1.agregarCliente(new Cliente(contadorClientes++));
        }

        for (int i = 0; i < clientesFila2; i++) {
            fila2.agregarCliente(new Cliente(contadorClientes++));
        }

        System.out.println("Filas inicializadas.");
        mostrarFilas();
    }

    public void mostrarFilas() {
        System.out.println("Fila 1:");
        fila1.mostrarFila();
        System.out.println("Fila 2:");
        fila2.mostrarFila();
    }

    public void atenderFila1() {
        fila1.clienteAburrido();
    }

    public void atenderFila2() {
        fila2.clienteAburrido();
    }

    public void aburrirseFila1() {
        fila1.clienteAburrido();
    }

    public void aburrirseFila2() {
        fila2.clienteAburrido();
    }

    public void colarseLicitamenteFila1() {
        fila1.agregarCliente(new Cliente(contadorClientes++));
        System.out.println("Un cliente se ha colado lícitamente en la fila 1.");
    }

    public void colarseIllicitamenteFila2() {
        fila2.agregarCliente(new Cliente(contadorClientes++));
        System.out.println("Un cliente se ha colado ilícitamente en la fila 2.");
    }

    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();
        supermercado.inicializarFilas(10);
        supermercado.mostrarFilas();
        
        supermercado.colarseIllicitamenteFila2();
        supermercado.mostrarFilas();
    }
}