public class Baldosa {

    private int baldosa;

    public Baldosa() {
        this.baldosa = inicializaEstado();
    }

    private int inicializaEstado() {
        double probabilidadMugre = Math.random();
        if (probabilidadMugre <= 0.01) {
            return 3;
        } else if (probabilidadMugre < 0.04) {
            return 2;
        } else if (probabilidadMugre < 0.07) {
            return 1;
        } else {
            return 0;
        }
    }

    public int ver() {
        return this.baldosa;
    }

    public void ensucia() {
        if (this.baldosa < 4) {
            this.baldosa++;
        }
        ;
    }

    public void limpia() {
        if (this.baldosa > 0) {
            this.baldosa--;
        }
        ;
    }

}