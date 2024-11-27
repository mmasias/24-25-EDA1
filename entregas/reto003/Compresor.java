import java.util.Scanner;

public class Compresor {
    public static class Resultado {
        String[] salidaComprimida;
        String[] diccionario;
        int sizeSalida;
        int sizeDiccionario;

        public Resultado(String[] salidaComprimida, String[] diccionario, int sizeSalida, int sizeDiccionario) {
            this.salidaComprimida = salidaComprimida;
            this.diccionario = diccionario;
            this.sizeSalida = sizeSalida;
            this.sizeDiccionario = sizeDiccionario;
        }

        @Override
        public String toString() {
            String resultado = "Resultado comprimido:\n";
            for (int i = 0; i < sizeSalida; i++) {
                resultado += salidaComprimida[i];
            }
            resultado += "\nDiccionario:\n";
            for (int i = 0; i < sizeDiccionario; i++) {
                resultado += (i + 1) + ":" + diccionario[i] + "\n";
            }
            return resultado; 
        }
    }

    public static Resultado comprime(String cadena) {
        // Definir un tamaño máximo para los arreglos
        final int MAX_SIZE = 100; 
        String[] salida = new String[MAX_SIZE];
        String[] diccionario = new String[MAX_SIZE];
        int sizeSalida = 0;
        int sizeDiccionario = 0;
        int i = 0; 

        while (i < cadena.length()) {
            String coincidenciaMasLarga = "";
            int indiceCoincidencia = -1;

            for (int j = 0; j < sizeDiccionario; j++) {
                String entradaDiccionario = diccionario[j];
                if (cadena.startsWith(entradaDiccionario, i)) {
                    coincidenciaMasLarga = entradaDiccionario;
                    indiceCoincidencia = j;
                }
            }

            if (!coincidenciaMasLarga.isEmpty()) {
                int longitud = coincidenciaMasLarga.length();
                if (i + longitud < cadena.length()) {
                    char siguienteCaracter = cadena.charAt(i + longitud);
                    salida[sizeSalida++] = "(" + (indiceCoincidencia + 1) + "," + siguienteCaracter + ")";
                    diccionario[sizeDiccionario++] = coincidenciaMasLarga + siguienteCaracter;
                    i += longitud + 1; 
                } else {
                    salida[sizeSalida++] = "(" + (indiceCoincidencia + 1) + ",)";
                    i += longitud; 
                }
            } else {
                char siguienteCaracter = cadena.charAt(i);
                salida[sizeSalida++] = "(0," + siguienteCaracter + ")";
                diccionario[sizeDiccionario++] = String.valueOf(siguienteCaracter);
                i++; 
            }
        }
        return new Resultado(salida, diccionario, sizeSalida, sizeDiccionario);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner
        System.out.print("Ingrese la cadena a comprimir: ");
        String cadena = scanner.nextLine(); // Leer la cadena ingresada por el usuario
        Resultado resultado = comprime(cadena);
        System.out.println(resultado);
        scanner.close(); // Cerrar el scanner
    }
}