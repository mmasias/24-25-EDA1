class Playlist {
    private String titulo;
    private Lista canciones;

    public Playlist(String titulo) {
        this.titulo = titulo;
        this.canciones = new Lista();
    }

    public String getTitulo() {
        return titulo;
    }

    public Cancion getCancionByIndex(int index) {
        Node iterator = canciones.getFirst();
        int count = 0;

        while (iterator != null) {
            if (count == index) {
                return (Cancion) iterator.getValue();
            }
            count++;
            iterator = iterator.getNext();
        }
        return null;
    }
    
    public Lista getCanciones() {
        return canciones;
    }

    public void anadirCancion(Cancion cancion) {
        canciones.insertEnd(cancion);
    }


    public void eliminarCancion(int indiceCancion) {
        if (indiceCancion < 0 || indiceCancion >= canciones.size()) {
            System.out.println("Índice de canción inválido.");
            return;
        }
        Lista nuevaLista = new Lista();
        Node iterator = canciones.getFirst();
        int count = 0;

        while (iterator != null) {
            if (count != indiceCancion) {
                nuevaLista.insertEnd(iterator.getValue());
            }
            count++;
            iterator = iterator.getNext();
        }
        
        canciones = nuevaLista;
        System.out.println("Canción en el índice " + indiceCancion + " eliminada de la playlist '" + titulo + "'.");
    }

    public String toString() {
        return "Playlist: " + titulo + "\n" + canciones.listAll();
    }
}