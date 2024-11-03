class Cancion {

    private String nombre;
    private int duracion;
    private Cancion next;

    public Cancion(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }

    public Cancion getNext() {
        return next;
    }

    public void setNext(Cancion next) {
        this.next = next;
    }

}
