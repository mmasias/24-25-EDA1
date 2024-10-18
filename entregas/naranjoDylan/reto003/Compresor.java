package entregas.naranjoDylan.reto003;

public class Compresor {
    private Diccionario diccionario;
    
    public Compresor() {
        diccionario = new Diccionario();
    }

    public String comprime(String cadena) {
        StringBuilder resultado = new StringBuilder();
        String subCadena = "";
        
        for (int i = 0; i < cadena.length(); i++) {
            subCadena += cadena.charAt(i);
            int index = diccionario.verificarYRegistrar(subCadena);
            resultado.append("(").append(index).append(",").append(subCadena.charAt(subCadena.length() - 1)).append(")");
            subCadena = "";
        }
        
        return resultado.toString();
    }
    
    public Diccionario getDiccionario() {
        return diccionario;
    }
}

