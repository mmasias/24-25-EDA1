package src;
class Pollo extends Carne {
    final String REPRESENTACION = " " + ";".repeat(12);
    
    public Pollo(String coccion) {
        super("Pollo", coccion);
    }

    @Override
    public void mostrar() {
        System.out.println(REPRESENTACION);
    }
}