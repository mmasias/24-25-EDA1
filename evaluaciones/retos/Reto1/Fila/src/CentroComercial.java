public class CentroComercial {

    public static void main(String[] args) {

        Fila fila = new Fila(5); // Crea una fila con capacidad para 5 personas.

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