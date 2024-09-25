public class Fila {
    private String[] cola;
    private int tamaño;
    private Random random;

    public Fila(int capacidad) {
        cola = new String[capacidad];
        tamaño = 0;
        random = new Random();
        
    }

    public void llegaGente() {
        if (tamaño < cola.length) {
            cola[tamaño] = "Cliente " + (tamaño + 1);
            System.out.println(cola[tamaño] + " ha llegado a la fila.");
            tamaño++;
        } else {
            System.out.println("La fila está llena.");
        }
    }

    public void Ramdon random {

    }

}