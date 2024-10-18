public class Compresor {

    public static class Resultado {
        String[] salidaComprimida;
        int[] clavesDiccionario;
        String[] valoresDiccionario;

        public Resultado(String[] salidaComprimida, int[] clavesDiccionario, String[] valoresDiccionario) {
            this.salidaComprimida = salidaComprimida;
            this.clavesDiccionario = clavesDiccionario;
            this.valoresDiccionario = valoresDiccionario;
        }

        @Override
        public String toString() {
            StringBuilder resultado = new StringBuilder();
            resultado.append("Resultado comprimido: ");
            for (String parte : salidaComprimida) {
                resultado.append(parte);
            }
            resultado.append("\nDiccionario: ");
            for (int i = 0; i < clavesDiccionario.length; i++) {
                if (valoresDiccionario[i] != null) {
                    resultado.append(clavesDiccionario[i] + ":" + valoresDiccionario[i] + ", ");
                }
            }
            return resultado.toString().replaceAll(", $", ""); 
        }
    }

    public static Resultado comprime(String cadena) {
        String[] salida = new String[cadena.length()];
        int[] clavesDiccionario = new int[cadena.length()];
        String[] valoresDiccionario = new String[cadena.length()];
        int indiceDiccionario = 1; 
        int salidaIndice = 0;

        int i = 0; 
        while (i < cadena.length()) {
            String coincidenciaMasLarga = "";
            int indiceCoincidencia = 0;

    
            for (int j = 0; j < indiceDiccionario - 1; j++) {
                String entradaDiccionario = valoresDiccionario[j];
                if (entradaDiccionario != null && cadena.startsWith(entradaDiccionario, i)) {
                    coincidenciaMasLarga = entradaDiccionario;
                    indiceCoincidencia = clavesDiccionario[j];
                }
            }

       
            if (!coincidenciaMasLarga.isEmpty()) {
                int longitud = coincidenciaMasLarga.length();
                if (i + longitud < cadena.length()) {
                    char siguienteCaracter = cadena.charAt(i + longitud);
                    salida[salidaIndice++] = "(" + indiceCoincidencia + "," + siguienteCaracter + ")";
                    valoresDiccionario[indiceDiccionario - 1] = coincidenciaMasLarga + siguienteCaracter;
                    clavesDiccionario[indiceDiccionario - 1] = indiceDiccionario;
                    indiceDiccionario++;
                    i += longitud + 1; 
                } else {
                    salida[salidaIndice++] = "(" + indiceCoincidencia + ",)";
                    i += longitud; 
                }
            } else {
               
                char siguienteCaracter = cadena.charAt(i);
                salida[salidaIndice++] = "(0," + siguienteCaracter + ")";
                valoresDiccionario[indiceDiccionario - 1] = String.valueOf(siguienteCaracter);
                clavesDiccionario[indiceDiccionario - 1] = indiceDiccionario;
                indiceDiccionario++;
                i++; 
            }
        }

     
        String[] salidaFinal = new String[salidaIndice];
        System.arraycopy(salida, 0, salidaFinal, 0, salidaIndice);
        int[] clavesFinal = new int[indiceDiccionario - 1];
        String[] valoresFinal = new String[indiceDiccionario - 1];
        System.arraycopy(clavesDiccionario, 0, clavesFinal, 0, indiceDiccionario - 1);
        System.arraycopy(valoresDiccionario, 0, valoresFinal, 0, indiceDiccionario - 1);

        return new Resultado(salidaFinal, clavesFinal, valoresFinal);
    }

    public static void main(String[] args) {
        String cadena = "abababc";
        Resultado resultado = comprime(cadena);
        System.out.println(resultado);
    }
}