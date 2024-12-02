package entregas.lopezMartin.ejercicio001.burger;
class Res extends Carne {
    public Res(String coccion) {
        super("Res", coccion);
    }

    @Override
    public void mostrar() {
        System.out.println(" " + ":".repeat(12));
    }
}