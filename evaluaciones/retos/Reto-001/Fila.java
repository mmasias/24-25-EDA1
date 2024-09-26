class Fila {
    private String[] fila;
    private int capacidadMaxima;
    private int numPersonas;

    public Fila(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.fila = new String[capacidadMaxima];
        this.numPersonas = 0;
    }
}
