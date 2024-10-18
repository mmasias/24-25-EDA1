class Cheddar extends Queso {
    final String REPRESENTACION = "============";
    
    public Cheddar() {
        super("Cheddar");
    }

    @Override
    public void mostrar() {
        System.out.println(REPRESENTACION);
    }
}

