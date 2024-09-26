public class Fila {
    private int capacidad;
    private String[] personas;
    private int contador;

    public Fila(int capacidad) {
        this.capacidad = capacidad;
        this.personas = new String[capacidad];
        this.contador = 0;
    }

    public void abrirFila() {
        System.out.println("La fila ha sido abierta.");
    }
}