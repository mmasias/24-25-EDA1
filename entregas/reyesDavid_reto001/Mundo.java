package entregas.reyesDavid_reto001;

class Mundo {
    public static void main(String[] args) {
        Fila fila = new Fila();

        for (int i = 1; i <= 10; i++) {
            int numItems = (int) (Math.random() * 11);
            Cliente nuevoCliente = new Cliente("Cliente" + i, i, numItems);
            fila.agregarCliente(nuevoCliente);
        }


        System.out.println("\nFila después de que un cliente se aburre:");
        fila.mostrarFila();
        System.out.println("\nSimulando que a un cliente le traen ítems...");
        fila.entregarItems();
        System.out.println("\nFila después de entregar ítems:");
        fila.mostrarFila();
    }
}