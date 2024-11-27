class Album {
    private String nombre;
    private ListaCanciones canciones;

    public Album(String nombre) {
        this.nombre = nombre;
        this.canciones = new ListaCanciones();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.agregarCancion(cancion);
    }

    public void mostrarCanciones() {
        System.out.println("Canciones en el álbum \"" + nombre + "\":");
        canciones.mostrar();
    }

    @Override
    public String toString() {
        return nombre;
    }
}