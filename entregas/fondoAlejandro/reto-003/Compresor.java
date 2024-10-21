class Compresor {

    public static Resultado comprime(String cadena) {
        String[] salida = new String[100];
        String[] diccionario = new String[100];
        int indiceDiccionario = 1; 
        int i = 0; 
        int tamañoSalida = 0;

        while (i < cadena.length()) {
            String coincidenciaMasLarga = "";
            int indiceCoincidencia = 0;

            for (int j = 1; j < indiceDiccionario; j++) {
                if (diccionario[j] != null && cadena.startsWith(diccionario[j], i)) {
                    coincidenciaMasLarga = diccionario[j];
                    indiceCoincidencia = j;
                }
            }

            if (!coincidenciaMasLarga.isEmpty()) {
                int longitud = coincidenciaMasLarga.length();
                if (i + longitud < cadena.length()) {
                    char siguienteCaracter = cadena.charAt(i + longitud);
                    salida[tamañoSalida++] = "(" + indiceCoincidencia + "," + siguienteCaracter + ")";
                    diccionario[indiceDiccionario++] = coincidenciaMasLarga + siguienteCaracter;
                    i += longitud + 1; 
                } else {
                    salida[tamañoSalida++] = "(" + indiceCoincidencia + ",)";
                    i += longitud; 
                }
            } else {
                char siguienteCaracter = cadena.charAt(i);
                salida[tamañoSalida++] = "(0," + siguienteCaracter + ")";
                diccionario[indiceDiccionario++] = String.valueOf(siguienteCaracter);
                i++; 
            }
        }

        String[] salidaFinal = new String[tamañoSalida];
        System.arraycopy(salida, 0, salidaFinal, 0, tamañoSalida);

        String[] diccionarioFinal = new String[indiceDiccionario];
        System.arraycopy(diccionario, 0, diccionarioFinal, 0, indiceDiccionario);

        return new Resultado(salidaFinal, diccionarioFinal, indiceDiccionario);
    }

    public static void main(String[] args) {
        String cadena = "abababcbdc";
        Resultado resultado = comprime(cadena);
        System.out.println(resultado);
    }
}