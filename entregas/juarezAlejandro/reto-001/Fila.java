class Fila {

    private Cliente[] fila;
    private int capacidad;
    private int numClientes;
    private int siguienteId;

    public Fila() {
        this.capacidad = 10;
        this.fila = new Cliente[capacidad];
        this.numClientes = 0;
        this.siguienteId = 1;
    }

    public void agregarCliente(Cliente cliente) {
        if (numClientes < capacidad) {
            fila[numClientes] = cliente;
            numClientes++;
        } else {
            System.out.println("Fila llena");
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

    public void entregarItems() {
        if (numClientes > 0) {
            int clienteDados = (int) (Math.random() * numClientes);
            Cliente cliente = fila[clienteDados];

            int itemsEntregados = (int) (Math.random() * 11);
            cliente.aumentarItems(itemsEntregados);
            System.out.println("A " + cliente.getNombre() + " (ID: " + cliente.getId() + ") le han traído "
                    + itemsEntregados + " ítems.");
        } else {
            System.out.println("No hay clientes en la fila para entregar ítems.");
        }
    }

    public void cuelaLicita(String nombreCliente) {
        int numItems = (int) (Math.random() * 11);
        Cliente nuevoCliente = new Cliente(nombreCliente, siguienteId++, numItems);
        for (int i = numClientes; i > 0; i--) {
            fila[i] = fila[i - 1];
        }
        fila[0] = nuevoCliente;
        numClientes++;
        System.out.println(nombreCliente + " se ha colado lícitamente.");
    }

    public void cuelaIlícita(String nombreCliente) {
        int numItems = (int) (Math.random() * 11);
        if (numClientes < capacidad) {
            Cliente nuevoCliente = new Cliente(nombreCliente, siguienteId++, numItems);
            fila[numClientes] = nuevoCliente;
            numClientes++;
            System.out.println(nombreCliente + " se ha colado ilícitamente.");
        } else {
            System.out.println("Fila llena. " + nombreCliente + " no puede colarse ilícitamente.");
        }
    }

    public void anunciarCambioDeFila() {
        System.out.println(
                "Al haber mucha gente en una fila, se habre otra fila, pasen por esta caja en orden de fila...");
        int limite = Math.min(5, numClientes);
        System.out.println("Clientes en la primera fila:");
        for (int i = 0; i < limite; i++) {
            System.out.println(fila[i]);
        }
        if (numClientes > limite) {
            System.out.println("Clientes en la segunda fila:");
            for (int i = limite; i < numClientes; i++) {
                System.out.println(fila[i]);
            }
        } else {
            System.out.println("No hay clientes suficientes para una segunda fila.");
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
