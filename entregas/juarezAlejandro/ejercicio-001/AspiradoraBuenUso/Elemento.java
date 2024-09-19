abstract class Elemento {

    public int posicionX, posicionY;

    public void mover(Habitacion habitacion) {
        double aleatorio = Math.random();
        if (aleatorio < .25 && this.posicionX + 1 < habitacion.ancho) {
            this.posicionX++;
        } else if (aleatorio < .5 && this.posicionX > 0) {
            this.posicionX--;
        } else if (aleatorio < .75 && this.posicionY + 1 < habitacion.largo) {
            this.posicionY++;
        } else if (aleatorio < 1 && this.posicionY > 0) {
            this.posicionY--;
        }
    }

}