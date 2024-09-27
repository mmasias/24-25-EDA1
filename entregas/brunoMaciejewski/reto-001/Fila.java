import java.util.Random;

public class Fila {
    private Cliente[] fila;

    public Fila() {
        fila = new Cliente[0];
    }

    public Fila(String anuncio, Fila filaAntigua) {
        System.out.println(anuncio);
        int mitad = filaAntigua.fila.length / 2;
        fila=new Cliente[mitad+1];
        Cliente[] filaTemporal=new Cliente[filaAntigua.fila.length-mitad-1];
        for (int i = 0; i < filaAntigua.fila.length; i++) {
            if (i<mitad){
                filaTemporal[i]=filaAntigua.fila[i];
            }
            else {
                fila[i-mitad]=filaAntigua.fila[i];
            }
        }
        filaAntigua.fila=filaTemporal;
    }

    public void añadirCliente() {
        Cliente nuevoCliente = new Cliente();
        Cliente[] filaTemporal = new Cliente[fila.length + 1];
        for (int i = 0; i < fila.length; i++) {
            filaTemporal[i] = fila[i];
        }
        filaTemporal[fila.length] = nuevoCliente;
        fila = filaTemporal;
        System.out.println("Ha llegado un cliente");
    }

    public void añadirCliente(Cliente nuevoCliente) {
        Cliente[] filaTemporal = new Cliente[fila.length + 1];
        for (int i = 0; i < fila.length; i++) {
            filaTemporal[i] = fila[i];
        }
        filaTemporal[fila.length] = nuevoCliente;
        fila = filaTemporal;
        System.out.println("Ha llegado un cliente");
    }

    public Cliente atenderPrimero() {
        Cliente cliente = fila[0];

        Cliente[] filaTemporal = new Cliente[fila.length - 1];
        for (int i = 0; i < fila.length - 1; i++) {
            filaTemporal[i] = fila[i + 1];
        }
        fila = filaTemporal;
        System.out.println("Cliente atendido");
        return cliente;
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
        System.out.println("Un cliente se ha ido");
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
        System.out.println("Un cliente se ha colado");
    }

    public void imprimir() {
        String mensaje = "";
        for (Cliente cliente : fila) {
            mensaje += cliente.toString();
            mensaje += "||";
        }
        System.out.println(this);
        System.out.println(mensaje);
    }

}
