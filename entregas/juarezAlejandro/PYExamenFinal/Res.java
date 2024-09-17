
class Res extends Carne {

    final String DIBUJO = "::::::::::::";

    public Res(String coccion) {
        super("Res", coccion);
    }

    @Override
    public void mostrar() {
        System.out.println(DIBUJO);
    }

}
