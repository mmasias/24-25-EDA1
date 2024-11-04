class Playlist extends Album {
    private String nombre;
    private Listalink<Cancion> canciones;

    public Playlist(String nombre) {
        super(nombre, "", 0);
        this.nombre = nombre;
        canciones = new Listalink<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public void eliminarCancion(Cancion cancion) {
        canciones.remove();
    }

    public void mostrarCanciones() {
        System.out.println("Playlist: " + nombre);
        canciones.display();
    }
    public String getNombre() {
        return nombre;
    }
    public Listalink<Cancion> getCanciones() {
        return canciones;
    }

    @Override
    public String toString() {
        return nombre;
    }
}