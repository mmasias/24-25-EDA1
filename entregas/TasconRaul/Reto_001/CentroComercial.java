package entregas.TasconRaul.Reto_001;

import java.util.Random;

public class CentroComercial {

    private Fila fila;
    private boolean abierto;
    private int tiempo;

    public CentroComercial() {
        this.fila = new Fila();
        this.abierto = true;
        this.tiempo = 0;
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
        }
    }
}