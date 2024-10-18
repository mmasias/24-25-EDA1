package Reto003;

import java.util.Scanner;

public class comprimir {

    public static String comprimirCadena(String cadena) {
        String[] diccionario = new String[100];
        int indice = 0;
        StringBuilder resultado = new StringBuilder();
        String buffer = "";
        int i = 0;

        while (i < cadena.length()) {
            buffer += cadena.charAt(i);

            int posicionDiccionario = buscarEnDiccionario(diccionario, indice, buffer);

            if (posicionDiccionario == -1) {
                if (buffer.length() == 1) {

                    diccionario[indice] = buffer;
                    resultado.append("(0,").append(buffer).append(")");
                } else {

                    String prefijo = buffer.substring(0, buffer.length() - 1);
                    posicionDiccionario = buscarEnDiccionario(diccionario, indice, prefijo);
                    resultado.append("(").append(posicionDiccionario + 1).append(",")
                            .append(buffer.charAt(buffer.length() - 1)).append(")");

                    diccionario[indice] = buffer;
                }
                indice++;
                buffer = "";
            }
            i++;
        }

        if (!buffer.isEmpty()) {
            int posicionDiccionario = buscarEnDiccionario(diccionario, indice, buffer);
            if (buffer.length() == 1) {
                resultado.append("(0,").append(buffer).append(")");
            } else {
                String prefijo = buffer.substring(0, buffer.length() - 1);
                posicionDiccionario = buscarEnDiccionario(diccionario, indice, prefijo);
                resultado.append("(").append(posicionDiccionario + 1).append(",")
                        .append(buffer.charAt(buffer.length() - 1)).append(")");
            }
            diccionario[indice] = buffer;
        }

        return resultado.toString();
    }

    public static String descomprimir(String comprimida) {
        String[] diccionario = new String[100];
        int indice = 0;
        StringBuilder resultado = new StringBuilder();

        int i = 0;
        while (i < comprimida.length()) {

            int startIndex = i + 1;
            int commaIndex = comprimida.indexOf(',', startIndex);
            int index = Integer.parseInt(comprimida.substring(startIndex, commaIndex));

            char character = comprimida.charAt(commaIndex + 1);

            if (index == 0) {
                resultado.append(character);
                diccionario[indice] = String.valueOf(character);
            } else {
                String entry = diccionario[index - 1] + character;
                resultado.append(entry);
                diccionario[indice] = entry;
            }

            i = comprimida.indexOf(')', commaIndex) + 1;
            indice++;
        }

        return resultado.toString();
    }

    public static int buscarEnDiccionario(String[] diccionario, int limite, String secuencia) {
        for (int i = 0; i < limite; i++) {
            if (diccionario[i] != null && diccionario[i].equals(secuencia)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cadena a comprimir: ");
        String original = scanner.nextLine();

        System.out.println("Original: " + original);

        String comprimida = comprimirCadena(original);
        System.out.println("Comprimida: " + comprimida);

        String descomprimida = descomprimir(comprimida);
        System.out.println("Descomprimida: " + descomprimida);

        scanner.close();
    }
}
