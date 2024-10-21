import java.util.HashMap;
import java.util.Map;

public class Diccionario {
    private Map<String, Integer> diccionario;
    private int indiceActual;

    public Diccionario() {
        this.diccionario = new HashMap<>();
        this.indiceActual = 1;  
    }

   
    public void agregar(String subcadena) {
        if (!diccionario.containsKey(subcadena)) {
            diccionario.put(subcadena, indiceActual++);
        }
    }

 
    public int obtenerIndice(String subcadena) {
        return diccionario.getOrDefault(subcadena, 0);
    }

   
    public Map<String, Integer> obtenerDiccionario() {
        return diccionario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : diccionario.entrySet()) {
            sb.append(entry.getValue()).append(":").append(entry.getKey()).append(" ");
        }
        return sb.toString();
    }
}
