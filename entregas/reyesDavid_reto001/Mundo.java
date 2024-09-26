package entregas.reyesDavid_reto001;

class Mundo {
    public static void main(String[] args) {
        Fila fila = new Fila();

        for (int i = 1; i <= 10; i++) {
            Cliente nuevoCliente = new Cliente("Cliente" + i, i);
            fila.agregarCliente(nuevoCliente);
        }

        fila.mostrarFila();
    }
}