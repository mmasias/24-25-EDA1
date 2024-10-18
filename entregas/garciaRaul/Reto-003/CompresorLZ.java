import java.util.*;

public class CompresorLZ {

    private Diccionario diccionario;

    public Compresor() {
        diccionario = new Diccionario();
    }

    // Método que comprime la cadena
    public String[] comprime(String cadena) {
        List<String> comprimido = new ArrayList<>();
        String ventana = "";

        for (int i = 0; i < cadena.length(); i++) {
             ventana += cadena.charAt(i);

            if (!diccionario.contiene(ventana)) {
                // Agregar la secuencia al diccionario
                diccionario.agregar(ventana);

                if (ventana.length() == 1) {
                    comprimido.add("(0," + ventana + ")");
                } else {
                    String subcadena = ventana.substring(0, ventana.length() - 1);
                    comprimido.add("(" + diccionario.obtenerIndice(subcadena) + "," + ventana.charAt(ventana.length() - 1) + ")");
                }

                ventana = ""; // Reiniciar la ventana
            }
        }

        // Convertir el resultado comprimido a una cadena
        String resultadoComprimido = String.join("", comprimido);

        // Devolver el resultado comprimido y el diccionario
        return new String[] {resultadoComprimido, diccionario.toString()};
    }
}



