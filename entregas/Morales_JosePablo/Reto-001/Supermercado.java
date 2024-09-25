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