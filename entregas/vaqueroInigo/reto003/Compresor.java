package entregas.vaqueroInigo.reto003;

import java.util.ArrayList;
import java.util.List;

public class Compresor {
    
    public static class Resultado {
        String comprimido;
        String[] diccionario;
        
        public Resultado(String comprimido, String[] diccionario) {
            this.comprimido = comprimido;
            this.diccionario = diccionario;
        }
    }

    public static Resultado comprime(String cadena) {
        List<String> diccionario = new ArrayList<>();
        List<String> resultadoComprimido = new ArrayList<>();

        int posicionActual = 0;
        
        while (posicionActual < cadena.length()) {
            String ventanaBusqueda = "";
            String coincidenciaMasLarga = "";
            int indiceCoincidencia = -1;
            
            for (int j = posicionActual; j < cadena.length(); j++) {
                ventanaBusqueda += cadena.charAt(j);
                
                for (int i = 0; i < diccionario.size(); i++) {
                    if (diccionario.get(i).equals(ventanaBusqueda)) {
                        coincidenciaMasLarga = ventanaBusqueda;
                        indiceCoincidencia = i + 1; 
                    }
                }
                
                if (indiceCoincidencia == -1 && j > posicionActual) {
                    break;
                }
            }
            
            if (!coincidenciaMasLarga.isEmpty()) {
                posicionActual += coincidenciaMasLarga.length();
                if (posicionActual < cadena.length()) {
                    String nuevoCaracter = String.valueOf(cadena.charAt(posicionActual));
                    resultadoComprimido.add("(" + indiceCoincidencia + "," + nuevoCaracter + ")");
                    diccionario.add(coincidenciaMasLarga + nuevoCaracter);
                }
            } else {
                String caracterActual = String.valueOf(cadena.charAt(posicionActual));
                resultadoComprimido.add("(0," + caracterActual + ")");
                diccionario.add(caracterActual);
            }
            
            posicionActual++;
        }
        
        String[] diccionarioArray = diccionario.toArray(new String[0]);
        
        String comprimido = String.join("", resultadoComprimido);
        
        return new Resultado(comprimido, diccionarioArray);
    }

    public static void main(String[] args) {
        String cadena = "abababc";
        Resultado resultado = comprime(cadena);
        
        System.out.println("Resultado comprimido: " + resultado.comprimido);
        
        System.out.println("Diccionario utilizado:");
        for (int i = 0; i < resultado.diccionario.length; i++) {
            System.out.println((i + 1) + ": " + resultado.diccionario[i]);
        }
    }
}
