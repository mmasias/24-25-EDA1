import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompresorLZW {
    private Map<String, Integer> diccionario;
    private List<Tupla> resultado;

    public CompresorLZW() {
        diccionario = new HashMap<>();
        resultado = new ArrayList<>();
    }

    public ResultadoCompresion comprime(String cadena) {
        // Inicializar diccionario con caracteres individuales
        for (int i = 0; i < cadena.length(); i++) {
            String charAsString = String.valueOf(cadena.charAt(i));
            if (!diccionario.containsKey(charAsString)) {
                diccionario.put(charAsString, diccionario.size() + 1);
            }
        }

        String ventana = "";
        int posicionActual = 0;

        while (posicionActual < cadena.length()) {
            // Obtener el siguiente carácter
            char siguienteCaracter = cadena.charAt(posicionActual);
            String ventanaExtendida = ventana + siguienteCaracter;

            if (diccionario.containsKey(ventanaExtendida)) {
                // Si la ventana extendida está en el diccionario, expandir la ventana
                ventana = ventanaExtendida;
            } else {
                // Si no está en el diccionario, emitir el índice de la ventana actual y agregar la nueva secuencia
                resultado.add(new Tupla(diccionario.get(ventana), siguienteCaracter));
                diccionario.put(ventanaExtendida, diccionario.size() + 1);
                ventana = String.valueOf(siguienteCaracter);
            }
            posicionActual++;
        }

        // Emitir la última ventana si no está vacía
        if (!ventana.isEmpty()) {
            resultado.add(new Tupla(diccionario.get(ventana), '\0')); // '\0' marca el final de la cadena
        }

        return new ResultadoCompresion(resultado, diccionario);
    }
}