import java.util.Random;

public class Fila {
    private int[][] tamano = new int[1][10];
    private Cliente clientes = new Cliente();
    private int inicio = 0;
    private int fim = 0;

    //Se crea la fila
    public Fila() {
        for (int i = 0; i < 10; i++) {
            tamano[0][i] = 0;
        }
    }

    //Introduccion de clientes en la matriz de la fila
    public void adicionar(Cliente cliente) {
        if (fim < 10) {
            tamano[0][fim] = cliente.getBultos();
            System.out.println("Cliente en la cola");
            fim++;
        } else {
            System.out.println("Fila llena");
        }
    }

    //Se atienden a los clientes, eliminando al primero de la fila
    public void remover() {
        if (inicio < fim) {
            tamano[0][inicio] = 0;
            System.out.println("Cliente atendido");
            inicio++;
        } else {
            System.out.println("Fila vacia");
        }
    }

    //Gente que esta en la fila se aburre y se va
    public void clienteSeva() {
        if (clientes.getTimer() != 10) {
            for (int i = 0; i < 10; i++) {
                clientes.setTimer(clientes.getTimer() + 1);
            }
        } else {
            remover();
            System.out.println("Cliente se va por aburrimiento");
        }
    }

    //Gente que esta en la fila sin bultos recibe bultos
    public void clientesinbultos() {
        adicionar(clientes);
        clientes.setBultos(0);
        System.out.println("Cliente espera a que le traigan bultos");
        for (clientes.timer = 0; clientes.timer < 10; clientes.timer++) {
            int timer = clientes.timer;
            int random = new Random().nextInt(10);
            if (random == 6){
                clientes.setBultos(1);
            }
        }
        if (clientes.getBultos() == 0) {
            System.out.println("Cliente se va por falta de bultos");
            remover();
        } else {
            System.out.println("Cliente recibe bultos");
            clientes.setBultos(new Random().nextInt(10));
        }
    }

    //Un cliente se cuela en la fila
    public void clientesecuela() {
        adicionar(clientes);
        System.out.println("Cliente se cuela en la fila");
    }

    //Se crea una nueva fila y se mueven los clientes en orden de fila
    public void moverclientes() {
        Fila fila = new Fila();
        System.out.println("Se abre una nueva fila y se mueven a los clientes");
        for (int i = 0; i < 10; i++) {
            fila.adicionar(clientes);
            fila.remover();
        }
    }

}
