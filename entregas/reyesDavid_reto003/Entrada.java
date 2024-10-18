package entregas.reyesDavid_reto003;

public class Entrada {
    public int indice;
    public char siguienteCaracter;

    public Entrada(int indice, char siguienteCaracter) {
        this.indice = indice;
        this.siguienteCaracter = siguienteCaracter;
    }

    public String toString() {
        return "(" + indice + "," + siguienteCaracter + ")";
    }
}
