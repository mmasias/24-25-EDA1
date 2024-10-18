package entregas.naranjoDylan.reto003prueba;

import java.util.HashMap;

public class Compresor {

    private HashMap<String, Integer> diccionario;
    private int nextCode;

    public Compresor() {
        diccionario = new HashMap<>();
        nextCode = 1;
        for (int i = 0; i < 256; i++) {
            diccionario.put(String.valueOf((char) i), i);
        }
    }

    public String comprime(String cadena) {
        StringBuilder resultado = new StringBuilder();
        StringBuilder current = new StringBuilder();

        for (char c : cadena.toCharArray()) {
            current.append(c);
            if (!diccionario.containsKey(current.toString())) {
                String prev = current.substring(0, current.length() - 1);
                resultado.append("(").append(diccionario.get(prev)).append(",").append(c).append(")");
                diccionario.put(current.toString(), nextCode++);
                current = new StringBuilder(String.valueOf(c));
            }
        }

        if (current.length() > 0) {
            resultado.append("(").append(diccionario.get(current.toString())).append(",)");
        }

        return resultado.toString();
    }

    public HashMap<String, Integer> getDiccionario() {
        return diccionario;
    }
}
