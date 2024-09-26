
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



}
