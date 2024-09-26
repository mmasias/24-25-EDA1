public class Aspiradora extends Elemento {

    public Aspiradora(Habitacion habitacion) {
        this.posicionX = (int) (Math.random() * habitacion.ancho);
        this.posicionY = (int) (Math.random() * habitacion.largo);
    }

    public void limpiar(Habitacion habitacion) {
        habitacion.limpiar(posicionX, posicionY);
    }

}