package entregas.joseSalceda.Reto003;

import java.util.*;

public class Compresor {
    private Map<Integer, String> diccionario;
    private List<Tupla> resultado;

    public Compresor() {
        this.diccionario = new HashMap<>();
        this.resultado = new ArrayList<>();
    }

    public ResultadoCompresion comprime(String cadena) {
        StringBuilder ventanaBusqueda = new StringBuilder();
        int posicionActual = 0;

        while (posicionActual < cadena.length()) {
            int indiceCoincidencia = -1;
            int longitudCoincidencia = 0;

            for (int i = 0; i < ventanaBusqueda.length(); i++) {
                int j;
                for (j = 0; j < cadena.length() - posicionActual; j++) {
                    if (i + j >= ventanaBusqueda.length() || 
                        ventanaBusqueda.charAt(i + j) != cadena.charAt(posicionActual + j)) {
                        break;
                    }
                }
                if (j > longitudCoincidencia) {
                    longitudCoincidencia = j;
                    indiceCoincidencia = i;
                }
            }

            if (longitudCoincidencia > 0) {
                char siguienteCaracter = posicionActual + longitudCoincidencia < cadena.length() ?
                                         cadena.charAt(posicionActual + longitudCoincidencia) : '\0';
                resultado.add(new Tupla(indiceCoincidencia, siguienteCaracter));
                
                String nuevaEntrada = cadena.substring(posicionActual, 
                                      Math.min(posicionActual + longitudCoincidencia + 1, cadena.length()));
                diccionario.put(diccionario.size() + 1, nuevaEntrada);

                ventanaBusqueda.append(nuevaEntrada);
                posicionActual += longitudCoincidencia + (siguienteCaracter != '\0' ? 1 : 0);
            } else {
                resultado.add(new Tupla(0, cadena.charAt(posicionActual)));
                
                String nuevaEntrada = String.valueOf(cadena.charAt(posicionActual));
                diccionario.put(diccionario.size() + 1, nuevaEntrada);

                ventanaBusqueda.append(cadena.charAt(posicionActual));
                posicionActual++;
            }
        }

        return new ResultadoCompresion(resultado, diccionario);
    }

    private static class Tupla {
        int indice;
        char caracter;

        Tupla(int indice, char caracter) {
            this.indice = indice;
            this.caracter = caracter;
        }

        @Override
        public String toString() {
            return "(" + indice + "," + caracter + ")";
        }
    }

    public static class ResultadoCompresion {
        public final List<Tupla> resultado;
        public final Map<Integer, String> diccionario;

        ResultadoCompresion(List<Tupla> resultado, Map<Integer, String> diccionario) {
            this.resultado = resultado;
            this.diccionario = diccionario;
        }

        @Override
        public String toString() {
            return "Resultado comprimido: " + resultado + "\nDiccionario: " + diccionario;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cadena a comprimir: ");
        String entrada = scanner.nextLine();

        Compresor compresor = new Compresor();
        ResultadoCompresion resultado = compresor.comprime(entrada);
        System.out.println(resultado);

        scanner.close();
    }
}