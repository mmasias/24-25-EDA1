package entregas.atecaAlejandro.reto003;

import java.util.ArrayList;
import java.util.Scanner;

public class Compresion {

    public static class Resultado {
        String comprimido;
        ArrayList<String> diccionario;

        public Resultado(String comprimido, ArrayList<String> diccionario) {
            this.comprimido = comprimido;
            this.diccionario = diccionario;
        }

        public void imprimirResultado() {
            System.out.println("El resultado comprimido es: ");
            System.out.println(comprimido);
            System.out.println("El diccionario es:");
            for (int i = 0; i < diccionario.size(); i++) {
                System.out.println((i + 1) + ":" + diccionario.get(i));
            }
        }
    }

    public static Resultado comprime(String cadena) {
        ArrayList<String> diccionario = new ArrayList<>();
        ArrayList<String> salida = new ArrayList<>();
        String actual = "";
        
        int i = 0;
        while (i < cadena.length()) {
            int indiceCoincidencia = 0;
            String coincidenciaMasLarga = "";
            for (int j = i; j < cadena.length(); j++) {
                actual = cadena.substring(i, j + 1);
                int indice = diccionario.indexOf(actual);
                if (indice == -1) {
                    break;
                } else {
                    coincidenciaMasLarga = actual;
                    indiceCoincidencia = indice + 1;
                }
            }

            if (!coincidenciaMasLarga.isEmpty()) {
                char siguienteCaracter = cadena.charAt(i + coincidenciaMasLarga.length());
                salida.add("(" + indiceCoincidencia + "," + siguienteCaracter + ")");
                diccionario.add(coincidenciaMasLarga + siguienteCaracter);
                i += coincidenciaMasLarga.length() + 1;
            } else {
                char nuevoCaracter = cadena.charAt(i);
                salida.add("(0," + nuevoCaracter + ")");
                diccionario.add(String.valueOf(nuevoCaracter));
                i++;
            }
        }

        String resultadoComprimido = String.join("", salida);

        return new Resultado(resultadoComprimido, diccionario);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la cadena a comprimir:");
        String cadena = scanner.nextLine();
        
        Resultado resultado = comprime(cadena);
        resultado.imprimirResultado();
        
        scanner.close();
    }
}
