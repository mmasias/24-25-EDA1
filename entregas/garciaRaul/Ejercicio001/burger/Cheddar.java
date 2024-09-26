package entregas.garciaRaul.Ejercicio001.burger;
 class Cheddar extends Queso {
    final String REPRESENTACION = " " + "=".repeat(12);
    
    public Cheddar() {
        super("Cheddar");
    }

    @Override
    public void mostrar() {
        System.out.println(REPRESENTACION);
    }
}