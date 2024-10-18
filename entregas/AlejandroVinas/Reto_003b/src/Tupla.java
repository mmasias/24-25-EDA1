
class Tupla {
    private final int indice;
    private final char caracter;

    public Tupla(int indice, char caracter) {
        this.indice = indice;
        this.caracter = caracter;
    }

    @Override
    public String toString() {
        return "(" + indice + "," + caracter + ")";
    }
}
