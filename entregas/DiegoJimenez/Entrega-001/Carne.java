abstract class Carne {
    protected String tipo;
    protected String puntoCoccion;

    public Carne(String tipo, String puntoCoccion) {
        this.tipo = tipo;
        this.puntoCoccion = puntoCoccion;
    }

    public void mostrar() {
        System.out.println("Carne: " + tipo + ", Cocción: " + puntoCoccion);
    }

    public int verHashCode() {
        return this.hashCode();
    }

    public String describir() {
        return "Carne: " + tipo + ", Cocción: " + puntoCoccion;
    }
}
