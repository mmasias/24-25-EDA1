package entregas.reyesDavid_reto001;

class Fila {

    private Cliente[] fila;
    private int capacidad;
    private int numClientes;

    public Fila() {
        this.capacidad = 10;
        this.fila = new Cliente[capacidad];
        this.numClientes = 0;
    }

    public boolean agregarCliente(Cliente cliente) {
        if (numClientes < capacidad) {
            fila[numClientes] = cliente;
            numClientes++;
            return true;
        } else {
            System.out.println("Fila llena");
            return false;
        }
    }

    public void mostrarFila() {
        if (numClientes == 0) {
            System.out.println("Fila vacia");
        } else {
            System.out.println("Cliente en fila");
            for (int i = 0; i < numClientes; i++) {
                System.out.println(fila[i]);
            }
        }
    }

    public int getNumClientes() {
        return numClientes;
    }

    public int getCapacidad() {
        return capacidad;
    }
}