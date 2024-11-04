package evaluaciones.retos.pinedaOscar_reto03;

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