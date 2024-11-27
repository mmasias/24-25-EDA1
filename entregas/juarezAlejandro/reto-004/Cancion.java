class Cancion {
    private String nombre;
    private String artista;
    private int duracion;

    public Cancion(String nombre, String artista, int duracion) {
        this.nombre = nombre;
        this.artista = artista;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return nombre + " - " + artista + " [" + duracion + "s]";
    }
}