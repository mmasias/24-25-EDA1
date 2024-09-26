package entregas.fondoAlejandro.reto001;

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
}