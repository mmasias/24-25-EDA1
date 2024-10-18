package Reto003;

public class comprimir {

    public static String comprimirCadena(String cadena) {
        
        String[] diccionario = new String[100]; 
        int indice = 0;  
        String resultado = "";
        String buffer = "";
        int i = 0;

        while (i < cadena.length()) {
            buffer += cadena.charAt(i);

            int posicionDiccionario = buscarEnDiccionario(diccionario, indice, buffer);

            
            if (posicionDiccionario == -1) {
                
                if (buffer.length() == 1) {
                   
                    diccionario[indice] = buffer;
                    resultado += "(0," + buffer + ")";
                } else {
                   
                    String prefijo = buffer.substring(0, buffer.length() - 1);
                    posicionDiccionario = buscarEnDiccionario(diccionario, indice, prefijo);
                    resultado += "(" + (posicionDiccionario + 1) + "," + buffer.charAt(buffer.length() - 1) + ")";
                    
                    
                    diccionario[indice] = buffer;
                }
                indice++;
                buffer = ""; 
            }
            i++;
        }

        return resultado;
    }

    public static String descomprimir(String comprimida) {
        
        String[] diccionario = new String[100]; 
        int indice = 0;  
        String resultado = "";
        String[] tokens = comprimida.split("\\)");

        for (String token : tokens) {
            if (token.isEmpty())
                continue;
            token = token.replace("(", "");
            String[] parts = token.split(",");
            int index = Integer.parseInt(parts[0]);
            char character = parts[1].charAt(0);

            if (index == 0) {
               
                resultado += character;
                diccionario[indice] = String.valueOf(character); 
            } else {
                
                String entry = diccionario[index - 1] + character;
                resultado += entry;
                diccionario[indice] = entry; 
            }
            indice++;
        }

        return resultado;
    }

   
    public static int buscarEnDiccionario(String[] diccionario, int limite, String secuencia) {
        for (int i = 0; i < limite; i++) {
            if (diccionario[i] != null && diccionario[i].equals(secuencia)) {
                return i;  
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        
        String original = "abababc";
        System.out.println("Original: " + original);

       
        String comprimida = comprimirCadena(original);
        System.out.println("Comprimida: " + comprimida);


        String descomprimida = descomprimir(comprimida);
        System.out.println("Descomprimida: " + descomprimida);
    }
}
