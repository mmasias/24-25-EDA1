package reto004;

public class Reproduccion {
    private Canciones cabeza;
    private Canciones actual;

    public Reproduccion() {
        this.cabeza = null;
        this.actual = null;
    }

    public void mostrarCancion() {
        Canciones actual = cabeza;
        while (actual != null) {
            System.out.println("cancion actual: " + actual.getCancion());
            actual = actual.getSiguiente();
        }
    }

    public void cancionSiguiente() {
        if (actual != null && actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
            mostrarCancion();
        } else {
            System.out.println("eror");
        }

    }

    public void cancionAnterior() {
        if (actual != null && actual.getAnterior() != null) {
            actual = actual.getAnterior();
            mostrarCancion();
        } else {
            System.out.println("eror");
        }

    }

    public void colaCanciones() {
        if (actual == null) {
            System.out.println("no hay canciones");
        } else {
            System.out.println(" cola de canciones");
            Canciones temp = actual.getSiguiente();
            if (temp == null) {
                System.out.println(" no hay mas canciones");
            } else {
                while (temp != null) {
                    System.out.println("-" + temp.getCancion());
                    temp = temp.getSiguiente();
                }
            }
        }
    }
}
