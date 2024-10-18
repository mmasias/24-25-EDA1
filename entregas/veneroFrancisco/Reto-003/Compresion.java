import java.util.ArrayList;
import java.util.List;

public class Compresion {
    public static String[] comprime(String cadena) {
        List<String> diccionario = new ArrayList<>(); 
        List<String> resultado = new ArrayList<>();
        int posicionActual = 0;

        while (posicionActual < cadena.length()) {
            String coincidencia = "";
            int longitud = 0;

            
            for (int i = 1; i <= cadena.length() - posicionActual; i++) {
                String ventana = cadena.substring(posicionActual, posicionActual + i);
                if (diccionario.contains(ventana)) {
                    coincidencia = ventana;
                    longitud = ventana.length();
                } else {
                    break;
                }
            }

            if (longitud > 0) {
                
                int indice = diccionario.indexOf(coincidencia);
                char siguienteCaracter = cadena.charAt(posicionActual + longitud);
                resultado.add("(" + (indice + 1) + "," + siguienteCaracter + ")");
                posicionActual += longitud + 1;
                diccionario.add(coincidencia + siguienteCaracter);
            } else {
                
                char actual = cadena.charAt(posicionActual);
                diccionario.add(String.valueOf(actual));
                resultado.add("(0," + actual + ")");
                posicionActual++;
            }
        }

        return new String[] { String.join("", resultado), diccionario.toString() };
    }

    public static void main(String[] args) {
        String cadena = "abababc";
        String[] resultado = comprime(cadena);
        System.out.println("Resultado comprimido: " + resultado[0]);
        System.out.println("Diccionario: " + resultado[1]);
    }
}
