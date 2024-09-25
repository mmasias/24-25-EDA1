public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();
        supermercado.inicializarFilas(10);

        supermercado.atenderFila1();
        supermercado.aburrirseFila2();

        supermercado.colarseLicitamenteFila1();
        supermercado.colarseIllicitamenteFila2();

        supermercado.mostrarFilas();
    }
}