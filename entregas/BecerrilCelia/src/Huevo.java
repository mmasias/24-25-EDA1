package src;
class Huevo extends Extra {
    final String REPRESENTACION = " ~-~-(  )~-~-";

    public Huevo() {
        super("Huevo frito");
    }

    @Override
    public void mostrar() {
        System.out.println(REPRESENTACION);
    }
}