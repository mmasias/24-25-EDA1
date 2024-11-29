public class Comprimir {

    static class Par {
        int numero;
        char letra;

        Par(int p, char c) {
            this.numero = p;
            this.letra = c;
        }

        public String toString() {
            return "(" + numero + "," + letra + ")";
        }
    }

    public static Par[] comprimir(String cadena) {
        String[] diccionario = new String[1];
        int[] valores = new int[1];
        Par[] salida = new Par[1];
        int valor = 1;
        int contadorSalida = 0;
        int contadorDiccionario = 0;

        String w = "";

        System.out.println("Diccionario inicial: ");

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            String wc = w + c;

            int indice = buscarEnDiccionario(diccionario, contadorDiccionario, wc);

            if (indice == -1) {
                int p = w.isEmpty() ? 0 : buscarEnDiccionario(diccionario, contadorDiccionario, w);
                salida = expandirArraySalida(salida, contadorSalida);
                salida[contadorSalida++] = new Par(p, c);

                diccionario = expandirArrayDiccionario(diccionario, contadorDiccionario);
                valores = expandirArrayValores(valores, contadorDiccionario);
                diccionario[contadorDiccionario] = wc;
                valores[contadorDiccionario] = valor;
                System.out.println("Agregado al diccionario: " + wc + " -> " + valor);
                valor++;
                contadorDiccionario++;

                w = "";
            } else {
                w = wc;
            }
        }

        Par[] salidaFinal = new Par[contadorSalida];
        for (int i = 0; i < contadorSalida; i++) {
            salidaFinal[i] = salida[i];
        }

        return salidaFinal;
    }

    public static int buscarEnDiccionario(String[] diccionario, int contador, String secuencia) {
        for (int i = 0; i < contador; i++) {
            if (diccionario[i].equals(secuencia)) {
                return i + 1;
            }
        }
        return -1;
    }

    public static String[] expandirArrayDiccionario(String[] diccionario, int contador) {
        if (contador >= diccionario.length) {
            String[] nuevoDiccionario = new String[diccionario.length * 2];
            for (int i = 0; i < diccionario.length; i++) {
                nuevoDiccionario[i] = diccionario[i];
            }
            return nuevoDiccionario;
        }
        return diccionario;
    }

    public static int[] expandirArrayValores(int[] valores, int contador) {
        if (contador >= valores.length) {
            int[] nuevoValores = new int[valores.length * 2];
            for (int i = 0; i < valores.length; i++) {
                nuevoValores[i] = valores[i];
            }
            return nuevoValores;
        }
        return valores;
    }

    public static Par[] expandirArraySalida(Par[] salida, int contador) {
        if (contador >= salida.length) {
            Par[] nuevoSalida = new Par[salida.length * 2];
            for (int i = 0; i < salida.length; i++) {
                nuevoSalida[i] = salida[i];
            }
            return nuevoSalida;
        }
        return salida;
    }

    public static void main(String[] args) {
        String cadena = "abababcbdc"; 
        Par[] resultado = comprimir(cadena);

        System.out.println("\nCadena original: " + cadena);
        System.out.println("Compresión: ");
        for (Par p : resultado) {
            System.out.print(p + " ");
        }
    }
}
