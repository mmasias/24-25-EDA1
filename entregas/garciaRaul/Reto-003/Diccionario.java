public class Diccionario {

    private String[] secuencias;
    private int[] indices;
    private int indiceActual;
    private int capacidad;

    public Diccionario() {
        capacidad = 100;  // Tamaño inicial del diccionario (puede ajustarse)
        secuencias = new String[capacidad];
        indices = new int[capacidad];
        indiceActual = 1;  // Empezamos en 1 como en el ejemplo original
    }

    // Verificar si el diccionario contiene una secuencia
    public boolean contiene(String secuencia) {
        for (int i = 0; i < indiceActual - 1; i++) {
            if (secuencias[i].equals(secuencia)) {
                return true;
            }
        }
        return false;
    }

    // Obtener el índice de una secuencia en el diccionario
    public int obtenerIndice(String secuencia) {
        for (int i = 0; i < indiceActual - 1; i++) {
            if (secuencias[i].equals(secuencia)) {
                return indices[i];
            }
        }
        return 0;  // Retornamos 0 si no está la secuencia
    }

    // Agregar una nueva secuencia al diccionario
    public void agregar(String secuencia) {
        if (indiceActual - 1 >= capacidad) {
            // Si alcanzamos el límite, necesitamos redimensionar los arrays
            redimensionar();
        }
        secuencias[indiceActual - 1] = secuencia;
        indices[indiceActual - 1] = indiceActual;
        indiceActual++;
    }

    // Redimensionar los arrays si el tamaño actual es insuficiente
    private void redimensionar() {
        capacidad *= 2;  // Duplicamos la capacidad
        String[] nuevasSecuencias = new String[capacidad];
        int[] nuevosIndices = new int[capacidad];
        
        // Copiamos los valores antiguos a los nuevos arrays
        for (int i = 0; i < secuencias.length; i++) {
            nuevasSecuencias[i] = secuencias[i];
            nuevosIndices[i] = indices[i];
        }
        
        // Reemplazamos los arrays antiguos por los nuevos
        secuencias = nuevasSecuencias;
        indices = nuevosIndices;
    }

    // Convertir el diccionario en una cadena para mostrarlo
    @Override
    public String toString() {
        StringBuilder diccionarioStr = new StringBuilder();
        for (int i = 0; i < indiceActual - 1; i++) {
            diccionarioStr.append(indices[i]).append(": ").append(secuencias[i]).append("\n");
        }
        return diccionarioStr.toString();
    }
}




