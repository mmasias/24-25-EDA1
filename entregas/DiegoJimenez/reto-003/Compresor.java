public class Compresor {

    // Método que comprime la cadena
    public static String comprime(String cadena) {
        // Diccionario para almacenar las subcadenas (máximo 100 entradas, ajustable según necesidad)
        String[] diccionario = new String[100];
        int[] indices = new int[100];
        int indexDiccionario = 1; // El primer índice del diccionario es 1

        // Array para almacenar el resultado comprimido
        String[] resultado = new String[cadena.length()];
        int indexResultado = 0;

        // Variables para construir la cadena comprimida
        String ventana = "";
        
        // Recorre la cadena
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            String nuevaVentana = ventana + c;
            
            // Busca la ventana en el diccionario
            int indice = buscaEnDiccionario(diccionario, nuevaVentana, indexDiccionario);

            if (indice == -1) { // Si no se encuentra en el diccionario
                if (ventana.equals("")) {
                    resultado[indexResultado++] = "(0," + c + ")";
                } else {
                    int indiceVentana = buscaEnDiccionario(diccionario, ventana, indexDiccionario);
                    resultado[indexResultado++] = "(" + indiceVentana + "," + c + ")";
                }

                // Añade la nueva ventana al diccionario
                diccionario[indexDiccionario] = nuevaVentana;
                indices[indexDiccionario] = indexDiccionario;
                indexDiccionario++;
                
                ventana = ""; // Reinicia la ventana
            } else {
                ventana = nuevaVentana; // Si la nueva ventana está en el diccionario, extiende la ventana
            }
        }

        // Si la ventana no está vacía al final, añade el último valor
        if (!ventana.equals("")) {
            int indiceVentana = buscaEnDiccionario(diccionario, ventana, indexDiccionario);
            resultado[indexResultado++] = "(" + indiceVentana + ",)";
        }

        // Muestra el diccionario generado
        System.out.println("Diccionario:");
        for (int i = 1; i < indexDiccionario; i++) {
            System.out.println(indices[i] + ": " + diccionario[i]);
        }

        // Construye la cadena final del resultado comprimido
        StringBuilder resultadoFinal = new StringBuilder("Resultado comprimido: ");
        for (int i = 0; i < indexResultado; i++) {
            resultadoFinal.append(resultado[i]);
        }

        return resultadoFinal.toString();
    }

    // Método para buscar en el diccionario
    private static int buscaEnDiccionario(String[] diccionario, String ventana, int tamañoDiccionario) {
        for (int i = 1; i < tamañoDiccionario; i++) {
            if (diccionario[i].equals(ventana)) {
                return i;
            }
        }
        return -1; // Si no encuentra la ventana en el diccionario
    }

    // Método principal para probar el compresor
    public static void main(String[] args) {
        String cadena = "abababc";
        String comprimido = comprime(cadena);
        System.out.println(comprimido);
    }
}
