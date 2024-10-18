public class Comprimir {
    public static void main(String[] args) {
        String texto = "abababcbdc";
        comprimirTextoLZ77(texto);
    }

    public static void comprimirTextoLZ77(String texto) {
        // Convertir el texto en un array de caracteres
        char[] chars = texto.toCharArray();
        
        // Matrices para almacenar los índices de desplazamiento y caracteres
        int[] offsets = new int[texto.length()];
        char[] caracteres = new char[texto.length()];

        int posicion = 0;  // Posición actual en el texto
        while (posicion < chars.length) {
            int offset = 0;  // Para almacenar la distancia al patrón más reciente
            int longitudCoincidencia = 0;  // Longitud de la coincidencia más larga encontrada

            // Buscar coincidencias anteriores en el texto
            for (int i = 0; i < posicion; i++) {
                int j = 0;

                // Verificar si hay coincidencia sin sobrepasar los límites del array
                while (i + j < posicion && posicion + j < chars.length && chars[i + j] == chars[posicion + j]) {
                    j++;
                }

                // Actualizar el desplazamiento y longitud si es mayor
                if (j > longitudCoincidencia) {
                    offset = posicion - i;
                    longitudCoincidencia = j;
                }
            }

            // Si no hay coincidencia previa, el offset es 0
            if (longitudCoincidencia == 0) {
                offset = 0;
                caracteres[posicion] = chars[posicion];  // Guardar el carácter actual
            } else {
                // Guardar el carácter siguiente a la coincidencia más larga
                caracteres[posicion] = chars[posicion + longitudCoincidencia];
            }

            // Guardar el desplazamiento
            offsets[posicion] = offset;

            // Mostrar el resultado comprimido (desplazamiento, carácter)
            System.out.print("(" + offsets[posicion] + "," + caracteres[posicion] + ")");

            // Avanzar la posición al siguiente segmento
            posicion += longitudCoincidencia + 1;
        }
    }
}
