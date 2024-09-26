import java.util.Random;

public class Fila {
    private static final int TAMANO_FILA = 10;
    private String[] fila;
    private int contador;

    public Fila() {
        fila = new String[TAMANO_FILA];
        contador = 0; 
    }

    public void abrirFila() {
        for (int i = 0; i < TAMANO_FILA; i++) {
            fila[i] = null;
        }
        contador = 0;
        System.out.println("La fila ha sido abierta.");
    }