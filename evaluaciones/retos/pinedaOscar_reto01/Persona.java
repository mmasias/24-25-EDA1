package evaluaciones.retos.pinedaOscar_reto01;

public class Persona {
    private static int contadorId = 0;
    private int id;

    public Persona() {
        this.id = ++contadorId;
    }

    public int getId() {
        return id;
    }
}