package reto004;

class Cancion {
    private String nombre;
    private int duracion;
    Cancion siguiente;

    public Cancion(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }
}
