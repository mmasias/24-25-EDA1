package Reto003;

import java.util.Scanner;

public class comprimir {

    public static String comprimirCadena(String cadena) {
        String[] diccionario = new String[100]; //inicializa diccionario con tamaño 100
        int indice = 0; //indice que controla la posicion en el diccionario
        StringBuilder resultado = new StringBuilder(); //construir cadena comprimida
        String buffer = ""; //almacena la secuencia de caracteress que se estan procesando en ese momento 
        int i = 0; //indice que recorre la cadena de entrada

        while (i < cadena.length()) {
            buffer += cadena.charAt(i); //se recorre la cadena original y se va construyendo el buffer

            int posicionDiccionario = buscarEnDiccionario(diccionario, indice, buffer); //verificar si el contenido del buffer ya esta en el diccionario

            if (posicionDiccionario == -1) { //si no se enecuentra en el diccionario
                if (buffer.length() == 1) { //si solo es un caracter

                    diccionario[indice] = buffer; //añadir caracter al diccionario 
                    resultado.append("(0,").append(buffer).append(")"); //añadir resultado como un nuevo caracter 
                } else {

                    String prefijo = buffer.substring(0, buffer.length() - 1); // Obtiene la parte del buffer sin el último carácter
                    posicionDiccionario = buscarEnDiccionario(diccionario, indice, prefijo); // Busca el prefijo en el diccionario
                    resultado.append("(").append(posicionDiccionario + 1).append(",") 
                            .append(buffer.charAt(buffer.length() - 1)).append(")"); // Añade el prefijo y el carácter final al resultado

                    diccionario[indice] = buffer; // Añade el buffer completo al diccionario
                }
                indice++; //incrementa el indice del diccionario
                buffer = ""; //limpia el buffer
            }
            i++;
        }

        if (!buffer.isEmpty()) { //si el buffer no esta vacio
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

        //Esta parte garantiza que si al final del bucle queda alguna secuencia en el buffer,
        //esta se procese correctamente. Se comprime como el resto de las secuencias y 
        //se añade al resultado.
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

            //El bucle recorre la cadena comprimida, extrayendo los índices
            // del diccionario y los caracteres almacenados.
            if (index == 0) {
                resultado.append(character); // Si el índice es 0, solo añade el carácter
                diccionario[indice] = String.valueOf(character); //añade el caracter al diccionario
            } else {
                String entry = diccionario[index - 1] + character; // Si no, añade la entrada del diccionario más el carácter
                resultado.append(entry);
                
                diccionario[indice] = entry; // Añade la nueva secuencia al diccionario
            }

            i = comprimida.indexOf(')', commaIndex) + 1; // Mueve el índice al siguiente
            indice++;  // Incrementa el índice del diccionario
        }

        return resultado.toString();
    }


    //Este método busca una secuencia en el diccionario y devuelve su posición si la encuentra.
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
