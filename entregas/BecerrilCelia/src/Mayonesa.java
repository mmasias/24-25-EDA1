package src;
public class Mayonesa extends Salsa {
    final String REPRESENTACION = " " + "~=~".repeat(4);
    
    public Mayonesa(String cantidad) {
        super("Mayonesa", cantidad);
    }

    @Override
    public void mostrar() {
        System.out.println(REPRESENTACION);
    }
}