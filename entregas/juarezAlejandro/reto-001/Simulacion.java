class Simulacion {
    public static void main(String[] args) {
        Fila fila = new Fila();

        for (int i = 1; i <= 10; i++) {
            int numItems = (int) (Math.random() * 11);
            Cliente nuevoCliente = new Cliente("Cliente" + i, i, numItems);
            fila.agregarCliente(nuevoCliente);
        }

        System.out.println("Fila inicial");
        fila.mostrarFila();

        System.out.println("\nAtendiendo al primer cliente");
        fila.atenderCliente();

        System.out.println("\nFila después de atender al primer cliente:");
        fila.mostrarFila();

        System.out.println("\nSimulando que un cliente se aburre...");
        fila.clienteAburrido();

        System.out.println("\nFila después de que un cliente se aburre:");
        fila.mostrarFila();

        System.out.println("\nSimulando que a un cliente le traen ítems...");
        fila.entregarItems();

        System.out.println("\nFila después de entregar ítems:");
        fila.mostrarFila();

        System.out.println("\nSimulando que alguien se cuela lícitamente...");
        fila.cuelaLicita("Cliente Lícito");

        System.out.println("\nFila después de cuela lícita:");
        fila.mostrarFila();

        System.out.println("\nSimulando que alguien se cuela ilícitamente...");
        fila.cuelaIlícita("Cliente Ilícito");

        System.out.println("\nFila después de cuela ilícita:");
        fila.mostrarFila();
    }
}