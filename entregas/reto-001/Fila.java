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
     private boolean existeEnFila(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (fila[i].equals(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    public void llegaGente(String nombre) {
        if (contador < TAMANO_FILA && !existeEnFila(nombre)) {
            fila[contador] = nombre;
            contador++;
            System.out.println(nombre + " ha llegado a la fila.");
        }
    } 
    public void atenderPrimero() {
        if (contador > 0) {
            String atendido = fila[0];
            System.out.println(atendido + " ha sido atendido.");
            for (int i = 1; i < contador; i++) {
                fila[i - 1] = fila[i];
            }
            fila[contador - 1] = null; 
            contador--;
        }
    }
    public void irseDeFila(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (fila[i].equals(nombre)) {
                System.out.println(nombre + " se ha ido de la fila.");
                for (int j = i + 1; j < contador; j++) {
                    fila[j - 1] = fila[j];
                }
                fila[contador - 1] = null; 
                contador--;
                break;
            }
        }
    }

    public void traerCosas(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (fila[i].equals(nombre)) {
                System.out.println(nombre + " ha recibido cosas traídas por alguien.");
                return;
            }
        }
    }