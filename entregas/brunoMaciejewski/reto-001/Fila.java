import java.util.Random;

public class Fila {
    private Cliente[] fila;

    public Fila() {
        fila = new Cliente[0];
    }

    public Fila(String anuncio, Fila filaAntigua) {
        System.out.println(anuncio);
        fila = new Cliente[0];
        int corte=filaAntigua.fila.length/2;
        for (int i = 0; i < fila.length; i++) {
            this.añadirCliente(filaAntigua.fila[i+corte]);
        }
        
    }

    public void añadirCliente() {
        Cliente nuevoCliente = new Cliente();
        Cliente[] filaTemporal = new Cliente[fila.length + 1];
        for (int i = 0; i < fila.length; i++) {
            filaTemporal[i] = fila[i];
        }
        filaTemporal[fila.length] = nuevoCliente;
        fila = filaTemporal;
    }

    public void añadirCliente(Cliente nuevoCliente) {
        Cliente[] filaTemporal = new Cliente[fila.length + 1];
        for (int i = 0; i < fila.length; i++) {
            filaTemporal[i] = fila[i];
        }
        filaTemporal[fila.length] = nuevoCliente;
        fila = filaTemporal;
    }

    public void atenderPrimero() {
        System.out.println("Total: " + fila[0].getItems() + " items");

        Cliente[] filaTemporal = new Cliente[fila.length - 1];
        for (int i = 0; i < fila.length - 1; i++) {
            filaTemporal[i] = fila[i + 1];
        }
        fila = filaTemporal;
    }

    public Cliente seleccionarCliente() {
        return fila[new Random().nextInt(fila.length - 1)];
    }

    public void clienteSeVa(Cliente cliente) {
        Cliente[] filaTemporal = new Cliente[fila.length - 1];
        int indice = 0;
        for (int i = 0; i < fila.length; i++) {
            if (fila[i] != cliente) {
                filaTemporal[indice] = fila[i];
                indice++;
            }
        }
        fila = filaTemporal;
    }

    public void colarCliente(Cliente cliente) {
        Cliente[] filaTemporal = new Cliente[fila.length + 1];
        int posicion = new Random().nextInt(fila.length - 1);
        int index = 0;
        for (int i = 0; i < filaTemporal.length; i++) {
            if (i == posicion) {
                filaTemporal[i] = cliente;
            } else {
                filaTemporal[i] = fila[index];
                index++;
            }
        }
        fila = filaTemporal;
    }

}
