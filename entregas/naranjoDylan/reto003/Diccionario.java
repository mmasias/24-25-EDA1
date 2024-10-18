package entregas.naranjoDylan.reto003;

public class Diccionario {

    private String[] subCadenas;
    private int[] indices;
    private int tamanioActual;

    public Diccionario(int capacidadMaxima) {
        subCadenas = new String[capacidadMaxima];
        indices = new int[capacidadMaxima];
        tamanioActual = 0;
    }

    public int verificarYRegistrar(String subCadena) {
        for (int i = 0; i < tamanioActual; i++) {
            if (subCadenas[i].equals(subCadena)) {
                return indices[i];
            }
        }

        subCadenas[tamanioActual] = subCadena;
        indices[tamanioActual] = tamanioActual + 1;
        tamanioActual++;

        return indices[tamanioActual - 1];
    }

    public void imprimirDiccionario() {
        System.out.println("Diccionario:");
        for (int i = 0; i < tamanioActual; i++) {
            System.out.println((i + 1) + ": " + subCadenas[i]);
        }
    }
}
