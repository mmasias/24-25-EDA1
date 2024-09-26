import java.util.Random;

public class ColaSupermercado {
    private static final int MAX_COLA = 12;
    private String[] cola;
    private int numClientes;
    public ColaSupermercado() {
        cola = new String[MAX_COLA];
        numClientes = 0; 
    }
    public void inicializarCola() {
        for (int i = 0; i < MAX_COLA; i++) {
            cola[i] = null;
        }
        numClientes = 0;
        System.out.println("La cola se ha iniciado.");
    }
private boolean hayCliente(String cliente) {
        for (int i = 0; i < numClientes; i++) {
            if (cola[i].equals(cliente)) {
                return true;
            }
        }
        return false;
    }
    public void añadirCliente(String cliente) {
        if (numClientes < MAX_COLA && !hayCliente(cliente)) {
            cola[numClientes] = cliente;
            numClientes++;
            System.out.println(cliente + " ha ingresado a la cola.");
        }
    }
    public void procesarSiguiente() {
        if (numClientes > 0) {
            String atendido = cola[0];
            System.out.println(atendido + " ha sido atendido.");
            for (int i = 1; i < numClientes; i++) {
                cola[i - 1] = cola[i];
            }
            cola[numClientes - 1] = null;
            numClientes--;
        }
    }
    public void abandonarCola(String cliente) {
        for (int i = 0; i < numClientes; i++) {
            if (cola[i].equals(cliente)) {
                System.out.println(cliente + " ha dejado la cola.");
                for (int j = i + 1; j < numClientes; j++) {
                    cola[j - 1] = cola[j];
                }
                cola[numClientes - 1] = null; 
                numClientes--;
                break;
            }
        }
    }
public void entregarProductos(String cliente) {
    for (int i = 0; i < numClientes; i++) {
        if (cola[i].equals(cliente)) {
            System.out.println(cliente + " ha recibido productos.");
            return;
        }
    }
}
public void adelantarCliente(String cliente) {
    if (numClientes < MAX_COLA && !hayCliente(cliente)) {
        for (int i = numClientes; i > 0; i--) {
            cola[i] = cola[i - 1];
        }
        cola[0] = cliente;
        numClientes++;
        System.out.println(cliente + " ha adelantado su lugar en la cola.");
    }
}
public void colarseEnCola(String cliente, int posicion) {
    if (numClientes < MAX_COLA && !hayCliente(cliente) && posicion > 0 && posicion <= numClientes) {
        for (int i = numClientes; i > posicion - 1; i--) {
            cola[i] = cola[i - 1];
        }
        cola[posicion - 1] = cliente;
        numClientes++;
        System.out.println(cliente + " se ha colado en la posición " + posicion + ".");
    }
}
public void advertirColaLlena() {
    if (numClientes > 4) {
        System.out.println("Pasen por esta caja en orden de fila...");
    }
}
public void mostrarCola() {
    System.out.print("En cola: ");
    for (int i = 0; i < numClientes; i++) {
        System.out.print(cola[i] + " ");
    }
    System.out.println();
}
 private String clienteAleatorio() {
        String[] nombres = {"Laura", "Claudia", "Javier", "Juan", "Lucas", "Paula", "Alvaro", "Sara", "Romeo", "Manuel", "Fran", "Pablo"};
        Random random = new Random();
        String cliente;
        do {
            cliente = nombres[random.nextInt(nombres.length)];
        } while (hayCliente(cliente));
        return cliente;
    }
    public void ejecutarSimulacion() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {

            String cliente = clienteAleatorio();
            int accion = random.nextInt(3);

            if (accion == 0) {
                añadirCliente(cliente);
            } else if (accion == 1 && numClientes > 0) {
                procesarSiguiente();
            } else if (accion == 2 && numClientes > 0) {
                abandonarCola(cliente);
            }
            if (numClientes > 0 && random.nextBoolean()) {
                entregarProductos(cola[random.nextInt(numClientes)]);
            }
            if (numClientes > 1 && random.nextBoolean()) {
                adelantarCliente(cliente);
            }
            if (numClientes > 1 && random.nextBoolean()) {
                int posicion = random.nextInt(numClientes) + 1;
                colarseEnCola(cliente, posicion);
            }

            advertirColaLlena();
            mostrarCola();
        }
    }






}
