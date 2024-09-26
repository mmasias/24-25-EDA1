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

    public void atenderCliente() {
        if (numClientes > 0) {
            System.out.println(fila[0] + "está siendo atendido");

            for (int i = 1; i < numClientes; i++) {
                fila[i - 1] = fila[i];
            }

            fila[numClientes - 1] = null;
            numClientes--;
        } else {
            System.out.println("No hay clientes en la fila");
        }
    }

    public void clienteAburrido() {
        if (numClientes > 1) {
            int aburrido = (int) (Math.random() * (numClientes - 1)) + 1;
            System.out.println(fila[aburrido] + " se ha aburrido y se fue.");
            for (int i = aburrido + 1; i < numClientes; i++) {
                fila[i - 1] = fila[i];
            }
            fila[numClientes - 1] = null;
            numClientes--;
        } else if (numClientes == 1) {
            System.out.println("Solo queda un cliente en la fila, no se puede aburrir.");
        } else {
            System.out.println("No hay clientes en la fila.");
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
