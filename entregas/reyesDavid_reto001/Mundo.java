package entregas.reyesDavid_reto001;

class Mundo {
    public static void main(String[] args) {
        Fila fila = new Fila();

        for (int i = 1; i <= 10; i++) {
            Cliente nuevoCliente = new Cliente("Cliente" + i, i);
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
    }
}