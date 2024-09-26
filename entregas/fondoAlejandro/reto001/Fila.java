package entregas.fondoAlejandro.reto001;
import java.util.Random;

public class Fila {
    private String[] fila;
    private int tamaño;
    private int longitudFila;

    public Fila(int longitudFila){
        this.longitudFila = longitudFila;
        this.fila = new String[longitudFila];
        this.tamaño = 0;  
    }

    public void abrirFila(){
        for (int i = 0; i < longitudFila; i++) {
            fila[i] = "[ ]"; 
        }
        System.out.println("Se abre una fila para atender a los clientes del centro comercial");
    }

    public void llegaCliente(){
        if (tamaño < longitudFila) {
            fila[tamaño] = "[O]"; 
            tamaño++;
            System.out.println("Un cliente ha llegado a la fila.");
            mostrarFila();
        } else {
            System.out.println("La fila esta llena." + "\n");
        }
    }

    public void atenderCliente(){
        if (tamaño > 0) {
            System.out.println("El primer cliente de la fila ha sido atendido y se marcha.");
            clienteSeMarcha();
            mostrarFila();
        } else {
            System.out.println("No hay nadie en la fila."+"\n");
        }
    }

    public void clienteSeMarcha(){
        for (int i = 1; i < tamaño; i++) {
            fila[i-1] = fila[i];
        }
        fila[tamaño - 1] = "[ ]"; 
        tamaño--;
        mostrarFila();
    }

    public void clienteSeAburre(int posicion){
        if (posicion < tamaño && posicion >= 0){
            System.out.println("La persona que estaba en la posicion " + (posicion + 1) + " se ha aburrido y se ha marchado.");
            clienteSeMarcha();
        }
    }

    public void clienteRecibeProductos(int posicion){
        if (posicion < tamaño && posicion >= 0){
            System.out.println("A la persona en la posicion " + (posicion + 1) + " le han traído productos");
            mostrarFila();
        }
    }

    public void colarseLicito(int posicion){
        if (posicion < tamaño && posicion >= 0){
            if (tamaño < longitudFila) {
                fila[tamaño] = "[O]"; 
                tamaño++;
                System.out.println("Una persona se ha colado licitamente en la fila.");
                mostrarFila();
            } else {
                System.out.println("La fila esta llena.");
            }
        }
    }

    public void colarseIlicito(){
        Random random = new Random();
        int posicionAleatoria = random.nextInt();
        if (posicionAleatoria < tamaño && posicionAleatoria >= 0){
            if (tamaño < longitudFila) {
                fila[tamaño] = "[O]"; 
                tamaño++;
                System.out.println("Una persona se ha colado ilicitamente en la fila.");
                mostrarFila();
            } else {
                System.out.println("La fila esta llena.");
            }
        }
    }

    public void mostrarFila(){
        System.out.print("Fila 1: " );
        for (int i = 0; i < fila.length; i++) {
            System.out.print(fila[i]);
        }
        System.out.println();
    }
}