package entregas.reyesDavid_reto003;

import java.util.List;
import java.util.Map;

public class ResultadoCompresion {
    public List<Entrada> comprimido;
    public Map<Integer, String> diccionario;

    public ResultadoCompresion(List<Entrada> comprimido, Map<Integer, String> diccionario) {
        this.comprimido = comprimido;
        this.diccionario = diccionario;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resultado comprimido: ");
        for (Entrada entrada : comprimido) {
            sb.append(entrada.toString()).append(" ");
        }
        sb.append("\nDiccionario:\n");
        for (Map.Entry<Integer, String> entry : diccionario.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
