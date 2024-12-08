public class Gato extends Elemento {

    public Gato(Habitacion habitacion) {
        this.posicionX = (int) (Math.random() * habitacion.ancho);
        this.posicionY = (int) (Math.random() * habitacion.largo);
    }

    public void ensuciar(Habitacion habitacion) {
        if (Math.random() > .75) {
            habitacion.ensuciar(posicionX, posicionY);
        }
    }

}