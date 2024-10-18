import java.util.List;
import java.util.Map;

class ResultadoCompresion {
    private final List<Tupla> resultado;
    private final Map<String, Integer> diccionario;

    public ResultadoCompresion(List<Tupla> resultado, Map<String, Integer> diccionario) {
        this.resultado = resultado;
        this.diccionario = diccionario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resultado comprimido: ").append(resultado).append("\n");
        sb.append("Diccionario: ").append(diccionario);
        return sb.toString();
    }
}
