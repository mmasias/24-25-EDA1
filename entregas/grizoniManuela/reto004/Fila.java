package entregas.grizoniManuela.reto004;

class Fila {
    private int[] fila;
    private int frente;
    private int finalFila;
    private int capacidad; 
    private int tamaño; 

    public Fila(){

    }

    public void encolar(){
        return;
    }

    public int desencolar(){
        return -1; 
    }

    public boolean estaVacia(){
        return tamaño == 0; 
    }
    public boolean estaLlena(){
        return tamaño == capacidad;
    }
}
