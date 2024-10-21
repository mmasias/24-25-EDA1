package entregas.TasconRaul.Reto_001;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fila {

    private List<Cliente> clientes;

    public Fila() {
        this.clientes = new ArrayList<>();
    }

    public void añadirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void atenderCliente() {
        if (!clientes.isEmpty()) {
            Cliente atendido = clientes.remove(0);
            System.out.println("Atendiendo cliente con " + atendido.getObjetos() + " objetos.");
        } else {
            System.out.println("No hay clientes para atender.");
        }
    }

    public void clienteSeVa() {
        if (!clientes.isEmpty()) {
            int indice = new Random().nextInt(clientes.size());
            Cliente aburrido = clientes.remove(indice);
            System.out.println("El cliente en la posición " + (indice + 1) + " se ha ido aburrido con " + aburrido.getObjetos() + " objetos.");
        }
    }

    public void recibirObjetosExternos() {
        if (!clientes.isEmpty()) {
            int indice = new Random().nextInt(clientes.size());
            Cliente cliente = clientes.get(indice);
            int nuevosObjetos = new Random().nextInt(3) + 1; 
            cliente.añadirObjetos(nuevosObjetos);
            System.out.println("El cliente en la posición " + (indice + 1) + " recibió " + nuevosObjetos + " objetos extra.");
        }
    }

    public void colarClienteIllicitamente() {
        Cliente colado = new Cliente();
        clientes.add(0, colado);
        System.out.println("Un cliente se ha colado ilícitamente con " + colado.getObjetos() + " objetos.");
    }

    public int getCantidadClientes() {
        return clientes.size();
    }
}
