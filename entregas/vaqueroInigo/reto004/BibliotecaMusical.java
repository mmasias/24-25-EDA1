package entregas.vaqueroInigo.reto004;

public class BibliotecaMusical {
    private ListaDoble canciones = new ListaDoble();

    public void agregarCancion(Cancion cancion) {
        canciones.agregar(cancion);
        System.out.println("Canción añadida: " + cancion);
    }

    public void mostrar() {
        canciones.mostrar();
    }

    public Cancion buscarPorTitulo(String titulo) {
        for (int i = 0; i < canciones.size(); i++) {
            Cancion cancion = canciones.get(i);
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                return cancion;
            }
        }
        return null;
    }
}
