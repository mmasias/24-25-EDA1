abstract class Extra extends Ingrediente{

    public Extra(String nombre) {
        super(nombre);
    }

    @Override
    protected abstract void mostrar();
    protected abstract String describir();
}
