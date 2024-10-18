package evaluaciones.retos.pinedaOscar_reto03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compresor {
    
    public ResultadoCompresion comprime(String cadena) {
       
        Map<String, Integer> diccionario = new HashMap<>();
        Map<Integer, String> diccionarioInverso = new HashMap<>();
        List<Entrada> comprimido = new ArrayList<>();

       
        int indiceDiccionario = 1;
        for (char c : cadena.toCharArray()) {
            String s = String.valueOf(c);
            if (!diccionario.containsKey(s)) {
                diccionario.put(s, indiceDiccionario);
                diccionarioInverso.put(indiceDiccionario, s);
                indiceDiccionario++;
            }
        }

        String w = ""; 
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            String wc = w + c;

            if (diccionario.containsKey(wc)) {
              
                w = wc;
            } else {
                
                comprimido.add(new Entrada(diccionario.get(w) == null ? 0 : diccionario.get(w), c));

                
                diccionario.put(wc, indiceDiccionario);
                diccionarioInverso.put(indiceDiccionario, wc);
                indiceDiccionario++;

               
                w = "";
            }
        }

       
        if (!w.equals("")) {
            comprimido.add(new Entrada(diccionario.get(w), '\0')); 
        }

        return new ResultadoCompresion(comprimido, diccionarioInverso);
    }

    public static void main(String[] args) {
     
        Compresor compresor = new Compresor();
        String cadena = "abababc";
        ResultadoCompresion resultado = compresor.comprime(cadena);
        System.out.println(resultado);
    }
}
