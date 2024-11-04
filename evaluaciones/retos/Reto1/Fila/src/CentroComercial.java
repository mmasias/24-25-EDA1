public class CentroComercial {

    public static void main(String[] args) {

        Fila fila = new Fila(5);

        fila.abrirFila();

        fila.llegarGente();
        fila.llegarGente();

        fila.colarseIlicitamente();

        fila.pasarASerAtendido();

        fila.irseDeLaFila();

        fila.colarseLicitamente();

        fila.anunciarOrdenFila();

        fila.vaciarFila();
    }
}