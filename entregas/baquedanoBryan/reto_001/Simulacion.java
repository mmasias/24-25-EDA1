package entregas.baquedanoBryan.reto_001;

public class Simulacion {

    public static void main(String[] args) {
        Fila fila = new Fila();
        llenarFila(fila);
        realizarSimulaciones(fila);
    }

    private static void llenarFila(Fila fila) {
        for (int i = 1; i <= fila.getCapacidad(); i++) {
            int numItems = (int) (Math.random() * 11);
            Cliente nuevoCliente = new Cliente(numItems);
            fila.agregarCliente(nuevoCliente);
        }
        System.out.println("Fila inicial:");
        fila.mostrarFila();
        imprimeLinea();
    }

    private static void realizarSimulaciones(Fila fila) {
        System.out.println("\nAtendiendo al primer cliente:");
        fila.atenderCliente();
        mostrarEstadoFila(fila);

        System.out.println("\nSimulando que un cliente se aburre");
        fila.clienteAburrido();
        mostrarEstadoFila(fila);

        System.out.println("\nSimulando que a un cliente le traen ítems");
        fila.entregarItems();
        mostrarEstadoFila(fila);

        System.out.println("\nSimulando que alguien se cuela lícitamente");
        fila.cuelaLicita();
        mostrarEstadoFila(fila);

        System.out.println("\nSimulando que alguien se cuela ilícitamente");
        fila.cuelaIlícita();
        mostrarEstadoFila(fila);

        System.out.println("\nAnuncio del centro comercial:");
        fila.anunciarCambioDeFila();
    }

    private static void mostrarEstadoFila(Fila fila) {
        System.out.println("\nFila después de la acción:");
        fila.mostrarFila();
        imprimeLinea();
    }

    private static void imprimeLinea() {
        System.out.println("-".repeat(60));
    }
}
