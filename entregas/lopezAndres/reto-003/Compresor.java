public class Compresor {

    public static class Resultado {
        String[] salidaComprimida;
        String[] diccionario;

        public Resultado(String[] salidaComprimida, String[] diccionario) {
            this.salidaComprimida = salidaComprimida;
            this.diccionario = diccionario;
        }

        @Override
        public String toString() {
            StringBuilder resultado = new StringBuilder();
            resultado.append("Resultado comprimido: ");
            for (String parte : salidaComprimida) {
                if (parte != null) {
                    resultado.append(parte);
                }
            }
            resultado.append("\nDiccionario: ");
            for (int i = 0; i < diccionario.length; i++) {
                if (diccionario[i] != null) {
                    resultado.append((i + 1) + ":" + diccionario[i] + ", ");
                }
            }
            return resultado.toString().replaceAll(", $", ""); 
        }
    }

    public static Resultado comprime(String cadena) {
        int maxTamano = cadena.length(); 
        String[] salida = new String[maxTamano]; 
        String[] diccionario = new String[maxTamano]; 

        int i = 0; 
        int salidaIndex = 0; 
        int diccionarioIndex = 0; 

        while (i < cadena.length()) {
            String coincidenciaMasLarga = "";
            int indiceCoincidencia = 0;

            
            for (int j = 0; j < diccionarioIndex; j++) {
                String entradaDiccionario = diccionario[j];
                if (cadena.startsWith(entradaDiccionario, i)) {
                    coincidenciaMasLarga = entradaDiccionario;
                    indiceCoincidencia = j + 1; 
                }
            }

            
            if (!coincidenciaMasLarga.isEmpty()) {
                int longitud = coincidenciaMasLarga.length();
                if (i + longitud < cadena.length()) {
                    char siguienteCaracter = cadena.charAt(i + longitud);
                    salida[salidaIndex++] = "(" + indiceCoincidencia + "," + siguienteCaracter + ")";
                    diccionario[diccionarioIndex++] = coincidenciaMasLarga + siguienteCaracter;
                    i += longitud + 1; 
                } else {
                    salida[salidaIndex++] = "(" + indiceCoincidencia + ",)";
                    i += longitud; 
                }
            } else {
                
                char siguienteCaracter = cadena.charAt(i);
                salida[salidaIndex++] = "(0," + siguienteCaracter + ")";
                diccionario[diccionarioIndex++] = String.valueOf(siguienteCaracter);
                i++; 
            }
        }

        
        String[] salidaFinal = new String[salidaIndex];
        String[] diccionarioFinal = new String[diccionarioIndex];
        System.arraycopy(salida, 0, salidaFinal, 0, salidaIndex);
        System.arraycopy(diccionario, 0, diccionarioFinal, 0, diccionarioIndex);

        return new Resultado(salidaFinal, diccionarioFinal);
    }

    public static void main(String[] args) {
        String cadena = "abababc";
        Resultado resultado = comprime(cadena);
        System.out.println(resultado);
    }
}
