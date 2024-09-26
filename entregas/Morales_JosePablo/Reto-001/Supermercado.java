import java.util.Random;

public class Supermercado {

    private Fila fila1;
    private Fila fila2;
    private int contadorClientes;
    private Random random;

    public Supermercado() {
        fila1 = new Fila(10);
        fila2 = new Fila(10);
        contadorClientes = 1;
        random = new Random();
    }

    public void inicializarFilas(int maxClientes) {
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

    public void colarseLicitamenteFila1() {
        fila1.agregarCliente(new Cliente(contadorClientes++));
        System.out.println("Un cliente se ha colado lícitamente en la fila 1.");
    }

    public void colarseIlicitamenteFila1() {
        fila1.agregarCliente(new Cliente(contadorClientes++));
        System.out.println("Un cliente se ha colado ilícitamente en la fila 1.");
    }

    public void colarseLicitamenteFila2() {
        fila2.agregarCliente(new Cliente(contadorClientes++));
        System.out.println("Un cliente se ha colado lícitamente en la fila 2.");
    }

    public void colarseIlicitamenteFila2() {
        fila2.agregarCliente(new Cliente(contadorClientes++));
        System.out.println("Un cliente se ha colado ilícitamente en la fila 2.");
    }

    public void simularAccionesAleatorias(int iteraciones) {
        for (int i = 0; i < iteraciones; i++) {
            int filaSeleccionada = random.nextInt(2) + 1;
            int tipoColado = random.nextInt(2); 

            if (filaSeleccionada == 1) {
                if (tipoColado == 0) {
                    colarseLicitamenteFila1();
                } else {
                    colarseIlicitamenteFila1();
                }
            } else {
                if (tipoColado == 0) {
                    colarseLicitamenteFila2();
                } else {
                    colarseIlicitamenteFila2();
                }
            }

            System.out.println("\nEstado actual de las filas:");
            mostrarFilas();
            System.out.println("--------------------------------------");
        }
    }

    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();
        supermercado.inicializarFilas(5);
        supermercado.mostrarFilas();
        supermercado.simularAccionesAleatorias(10);
    }
}