package romeroAngel.reto004;

class Playlist extends List {

    private String nombre;
    private List canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new List(); 
    }

    public void añadirCancion(Cancion cancion) {
        if (cancion != null && !canciones.contains(cancion)) {
            canciones.insertEnd(cancion);
        }
    }

    public List verCanciones() {
    }

    public String getNombre() {
        return nombre;
    }

}
