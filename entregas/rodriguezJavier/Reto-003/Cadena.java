public class Cadena {

    static class Par {
        int p;
        char c;

        Par(int p, char c) {
            this.p = p;
            this.c = c;
        }

        @Override
        public String toString() {
            return "(" + p + "," + c + ")";
        }
    }

    public static Par[] comprimir(String cadena) {
        String[] diccionario = new String[100];
        int[] valores = new int[100];
        Par[] salida = new Par[100];
        int valor = 1;
        int contadorSalida = 0;
        int contadorDiccionario = 0;

        String w = "";

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            String wc = w + c;

            int indice = buscarEnDiccionario(diccionario, contadorDiccionario, wc);

            if (indice == -1) {
                int p = w.isEmpty() ? 0 : buscarEnDiccionario(diccionario, contadorDiccionario, w);
                salida[contadorSalida++] = new Par(p, c);

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

        System.out.println("\nDiccionario:");
        for (int i = 0; i < contadorDiccionario; i++) {
            System.out.println(diccionario[i] + " -> " + valores[i]);
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
