import java.util.*;

public class Comprimidor {

    public static class Resultado {
        private List<Par<Integer, Character>> resultadoComprimido;
        private Map<Integer, String> diccionario;

        public Resultado(List<Par<Integer, Character>> resultadoComprimido, Map<Integer, String> diccionario) {
            this.resultadoComprimido = resultadoComprimido;
            this.diccionario = diccionario;
        }

        public List<Par<Integer, Character>> getResultadoComprimido() {
            return resultadoComprimido;
        }

        public Map<Integer, String> getDiccionario() {
            return diccionario;
        }

        @Override
        public String toString() {
            return "Resultado comprimido: " + resultadoComprimido + "\nDiccionario: " + diccionario;
        }
    }

    public static class Par<K, V> {
        public K primero;
        public V segundo;

        public Par(K primero, V segundo) {
            this.primero = primero;
            this.segundo = segundo;
        }

        @Override
        public String toString() {
            return "(" + primero + "," + segundo + ")";
        }
    }

    public Resultado comprime(String cadena) {
        Map<String, Integer> diccionario = new HashMap<>();
        Map<Integer, String> diccionarioInverso = new LinkedHashMap<>();
        List<Par<Integer, Character>> salida = new ArrayList<>();

        int indiceDiccionario = 1;
        int posicion = 0;
        int longitud = cadena.length();

        while (posicion < longitud) {
            String coincidenciaActual = "";
            int indiceCoincidencia = 0;
            int longitudCoincidencia = 0;

            for (int l = 1; posicion + l <= longitud; l++) {
                String subcadena = cadena.substring(posicion, posicion + l);
                if (diccionario.containsKey(subcadena)) {
                    coincidenciaActual = subcadena;
                    indiceCoincidencia = diccionario.get(subcadena);
                    longitudCoincidencia = l;
                } else {
                    break;
                }
            }

            if (longitudCoincidencia == 0) {
                char caracterActual = cadena.charAt(posicion);
                salida.add(new Par<>(0, caracterActual));
                diccionario.put(String.valueOf(caracterActual), indiceDiccionario);
                diccionarioInverso.put(indiceDiccionario, String.valueOf(caracterActual));
                indiceDiccionario++;
                posicion += 1;
            } else {
                if (posicion + longitudCoincidencia < longitud) {
                    char siguienteCaracter = cadena.charAt(posicion + longitudCoincidencia);
                    salida.add(new Par<>(indiceCoincidencia, siguienteCaracter));
                    String nuevaEntrada = coincidenciaActual + siguienteCaracter;
                    diccionario.put(nuevaEntrada, indiceDiccionario);
                    diccionarioInverso.put(indiceDiccionario, nuevaEntrada);
                    indiceDiccionario++;
                    posicion += longitudCoincidencia + 1;
                } else {
                    posicion += longitudCoincidencia;
                }
            }
        }

        return new Resultado(salida, diccionarioInverso);
    }

    public static void main(String[] args) {
        Comprimidor comprimidor = new Comprimidor();
        String cadena = "abababc";
        Resultado resultado = comprimidor.comprime(cadena);
        System.out.println(resultado);
    }
}
