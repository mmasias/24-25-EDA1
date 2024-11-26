package src;
class Integral extends Pan {
    final String REPRESENTACION = "|".repeat(14);
    
    public Integral() {
        super("Integral");
    }

    @Override
    public void mostrar() {
        System.out.println(REPRESENTACION);
    }
}