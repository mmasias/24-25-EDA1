package entregas.naranjoDylan.reto003;

public class Compresor {

    private Diccionario diccionario;

    public Compresor(int capacidadMaxima) {
        diccionario = new Diccionario(capacidadMaxima);
    }

    public String comprime(String cadena) {
        StringBuilder resultado = new StringBuilder();
        String subCadena = "";

        for (int i = 0; i < cadena.length(); i++) {
            subCadena += cadena.charAt(i);
            int index = diccionario.verificarYRegistrar(subCadena);

            if (i + 1 < cadena.length()) {
                subCadena += cadena.charAt(i + 1);
                int nuevoIndex = diccionario.verificarYRegistrar(subCadena);
                if (nuevoIndex > index) {
                    i++;
                }
            }

            resultado.append("(").append(index - 1).append(",").append(subCadena.charAt(subCadena.length() - 1)).append(")");
            subCadena = "";
        }

        return resultado.toString();
    }

    public void imprimirDiccionario() {
        diccionario.imprimirDiccionario();
    }
}
