import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Compresorlz {

    public static Resultado comprime(String cadena) {
    Diccionario diccionario = new diccionario(); 
        List<Par> resultadoComprimido = new ArrayList<>();

        int posicion = 0;

        while (posicion < cadena.length()) {
            String coincidenciaMasLarga = "";
            int indiceCoincidencia = 0;

           
            for (int i = 1; i <= cadena.length() - posicion; i++) {
                String subcadena = cadena.substring(posicion, posicion + i);
                int indice = diccionario.obtenerIndice(subcadena);
                if (indice != 0) {
                    coincidenciaMasLarga = subcadena;
                    indiceCoincidencia = indice;
                } else {
                    break;
                }
            }

          
            if (!coincidenciaMasLarga.isEmpty()) {
                int longitudCoincidencia = coincidenciaMasLarga.length();
                if (posicion + longitudCoincidencia < cadena.length()) {
                    char siguienteCaracter = cadena.charAt(posicion + longitudCoincidencia);
                    resultadoComprimido.add(new Par(indiceCoincidencia, siguienteCaracter));

                   
                    diccionario.agregar(coincidenciaMasLarga + siguienteCaracter);
                }
                
                posicion += longitudCoincidencia + 1;
            } else {
              
                char caracterActual = cadena.charAt(posicion);
                resultadoComprimido.add(new Par(0, caracterActual));
                diccionario.agregar(String.valueOf(caracterActual));
                posicion++;
            }
        }

        return new Resultado(resultadoComprimido, diccionario.obtenerDiccionario());
    }


    public static class Par {
        int indice;
        char caracter;

        public Par(int indice, char caracter) {
            this.indice = indice;
            this.caracter = caracter;
        }

        @Override
        public String toString() {
            return "(" + indice + "," + caracter + ")";
        }
    }


    public static class Resultado {
        List<Par> comprimido;
        Map<String, Integer> diccionario;

        public Resultado(List<Par> comprimido, Map<String, Integer> diccionario) {
            this.comprimido = comprimido;
            this.diccionario = diccionario;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Resultado comprimido: ");
            for (Par par : comprimido) {
                sb.append(par.toString()).append(" ");
            }
            sb.append("\nDiccionario utilizado: ");
            for (Map.Entry<String, Integer> entry : diccionario.entrySet()) {
                sb.append(entry.getValue()).append(":").append(entry.getKey()).append(" ");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String cadena = "abababc";
        Resultado resultado = comprime(cadena);
        System.out.println(resultado);
    }
}
