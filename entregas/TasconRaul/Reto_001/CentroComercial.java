package entregas.TasconRaul.Reto_001;

import java.util.Random;

public class CentroComercial {

    private Fila fila;
    private boolean abierto;
    private int tiempo;
    private int clientesAtendidos;

    public CentroComercial() {
        this.fila = new Fila();
        this.abierto = true;
        this.tiempo = 0;
        this.clientesAtendidos = 0;
    }

    public void simular(int duracion) {
        System.out.println("Inicio de la simulación del Centro Comercial...");
        
        while (abierto) {
            System.out.println("\nTiempo: " + tiempo + " minuto(s)");
            
            if (llegaCliente()) {
                Cliente nuevoCliente = new Cliente();
                fila.añadirCliente(nuevoCliente);
                System.out.println("Un nuevo cliente ha llegado con " + nuevoCliente.getObjetos() + " objetos.");
            }

            fila.atenderCliente();
            clientesAtendidos++;
            
            if (clienteSeAburre()) {
                fila.clienteSeVa();
            }
            
            fila.recibirObjetosExternos();
            
            if (seCuelaCliente()) {
                fila.colarClienteIllicitamente();
            }
            
            tiempo++;
            if (tiempo >= duracion) {
                abierto = false;
            }
        }
        
        System.out.println("\nCentro comercial cerrado.");
        System.out.println("Clientes atendidos en total: " + clientesAtendidos);
        System.out.println("Clientes que quedan en la fila: " + fila.getCantidadClientes());
    }

    private boolean llegaCliente() {
        return new Random().nextInt(100) < 60;
    }

    private boolean clienteSeAburre() {
        return new Random().nextInt(100) < 10;
    }

    private boolean seCuelaCliente() {
        return new Random().nextInt(100) < 20;
    }
}

