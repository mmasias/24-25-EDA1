package entregas.naranjoDylan.reto003prueba;

import java.util.ArrayList;
import java.util.HashMap;

public class Diccionario {

    private HashMap<String, Integer> diccionario;
    private ArrayList<String> lista;

    public Diccionario() {
        diccionario = new HashMap<>();
        lista = new ArrayList<>();
    }

    public int verificarYRegistrar(String subCadena) {
        if (!diccionario.containsKey(subCadena)) {
            diccionario.put(subCadena, diccionario.size() + 1);
            lista.add(subCadena);
        }
        return diccionario.get(subCadena);
    }

    public HashMap<String, Integer> getDiccionario() {
        return diccionario;
    }

    public ArrayList<String> getLista() {
        return lista;
    }
}
