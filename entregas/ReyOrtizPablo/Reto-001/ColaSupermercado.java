
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



}
