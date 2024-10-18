public class Compresor {

    public static String comprime(String cadena) {
        String[] diccionario = new String[100];
        int[] indices = new int[100];
        int indexDiccionario = 1; 

        String[] resultado = new String[cadena.length()];
        int indexResultado = 0;

        String ventana = "";
        
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            String nuevaVentana = ventana + c;

            int indice = buscaEnDiccionario(diccionario, nuevaVentana, indexDiccionario);

            if (indice == -1) { 
                if (ventana.equals("")) {
                    resultado[indexResultado++] = "(0," + c + ")";
                } else {
                    int indiceVentana = buscaEnDiccionario(diccionario, ventana, indexDiccionario);
                    resultado[indexResultado++] = "(" + indiceVentana + "," + c + ")";
                }

                diccionario[indexDiccionario] = nuevaVentana;
                indices[indexDiccionario] = indexDiccionario;
                indexDiccionario++;
                
                ventana = ""; 
            } else {
                ventana = nuevaVentana; 
            }
        }

        if (!ventana.equals("")) {
            int indiceVentana = buscaEnDiccionario(diccionario, ventana, indexDiccionario);
            resultado[indexResultado++] = "(" + indiceVentana + ",)";
        }

        System.out.println("Cadena original: " + cadena);

        System.out.println("Diccionario:");
        for (int i = 1; i < indexDiccionario; i++) {
            System.out.println(indices[i] + ": " + diccionario[i]);
        }

        StringBuilder resultadoFinal = new StringBuilder("Resultado comprimido: ");
        for (int i = 0; i < indexResultado; i++) {
            resultadoFinal.append(resultado[i]);
        }

        return resultadoFinal.toString();
    }

    private static int buscaEnDiccionario(String[] diccionario, String ventana, int tamañoDiccionario) {
        for (int i = 1; i < tamañoDiccionario; i++) {
            if (diccionario[i].equals(ventana)) {
                return i;
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        String cadena = "abababcbdc";
        String comprimido = comprime(cadena);
        System.out.println(comprimido);
    }
}
