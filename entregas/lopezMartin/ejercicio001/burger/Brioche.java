package entregas.lopezMartin.ejercicio001.burger;
class Brioche extends Pan {
    final String REPRESENTACION = "#".repeat(14);

    public Brioche() {
        super("Brioche");
    }

    @Override
    public void mostrar() {
        System.out.println(REPRESENTACION);
    }
}