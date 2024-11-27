class Biblioteca {
    ListaCanciones canciones;
    ListaCanciones favoritas;
    ListaPlaylist playlist;
    ColaReproduccion colaReproduccion;

    public Biblioteca() {
        this.canciones = new ListaCanciones();
        this.favoritas = new ListaCanciones();
        this.playlist = new ListaPlaylist();
        this.colaReproduccion = new ColaReproduccion();
        cargarCanciones();
    }

    public void cargarCanciones() {
        canciones.agregarCancion(new Cancion("505", "Arctic Monkeys", 413));
        canciones.agregarCancion(new Cancion("Whyd You Only Call Me When Youre High?", "Arctic Monkeys", 241));
        canciones.agregarCancion(new Cancion("I Wanna Be Yours", "Arctic Monkeys", 303));
        canciones.agregarCancion(new Cancion("Stop the World I Wanna Get Off With You", "Arctic Monkeys", 311));
        canciones.agregarCancion(new Cancion("Fireside", "Arctic Monkeys", 301));
        canciones.agregarCancion(new Cancion("R U Mine?", "Arctic Monkeys", 321));
        canciones.agregarCancion(new Cancion("Do I Wanna Know?", "Arctic Monkeys", 432));
        canciones.agregarCancion(new Cancion("Snap Out Of It", "Arctic Monkeys", 313));
        canciones.agregarCancion(new Cancion("Knee Socks", "Arctic Monkeys", 417));
        canciones.agregarCancion(new Cancion("Arabella", "Arctic Monkeys", 327));
        canciones.agregarCancion(new Cancion("Sex, Drugs, Etc", "Beach Weather", 316));
        canciones.agregarCancion(new Cancion("Chit Chat", "Beach Weather", 320));
        canciones.agregarCancion(new Cancion("Unlovable", "Beach Weather", 330));
        canciones.agregarCancion(new Cancion("Swoon", "Beach Weather", 341));
        canciones.agregarCancion(new Cancion("The Beach", "The Neighbourhood", 415));
        canciones.agregarCancion(new Cancion("White Mustang", "Lana Del Rey", 244));
        canciones.agregarCancion(new Cancion("Video Games", "Lana Del Rey", 441));
        canciones.agregarCancion(new Cancion("Summertime Sadness", "Lana Del Rey", 425));
        canciones.agregarCancion(new Cancion("Diet Mountain Draw", "Lana Del Rey", 342));
        canciones.agregarCancion(new Cancion("West Coast", "Lana Del Rey", 416));
    }

    public void mostrarCanciones() {
        System.out.println("Canciones en la biblioteca:");
        canciones.mostrar();
    }

    public void agregarFavorito(Cancion cancion) {
        if (!favoritas.contiene(cancion)) {
            favoritas.agregarCancion(cancion);
            System.out.println("Añadido a favoritos: " + cancion);
        } else {
            System.out.println("La canción ya está en favoritos.");
        }
    }

    public void verFavoritos() {
        System.out.println("Canciones favoritas:");
        favoritas.mostrar();
    }

    public void eliminarFavorito(Cancion cancion) {
        if (favoritas.contiene(cancion)) {
            favoritas.eliminarCancion(cancion);
            System.out.println("Eliminado de favoritos: " + cancion);
        } else {
            System.out.println("La canción no está en favoritos.");
        }
    }

    public void crearPlaylist(String nombre) {
        playlist.agregarPlaylist(new Playlist(nombre));
        System.out.println("Playlist \"" + nombre + "\" creada con éxito.");
    }

    public void verPlaylists() {
        System.out.println("Playlists disponibles:");
        playlist.mostrar();
    }

    public void agregarCancionAPlaylist(Playlist playlist, Cancion cancion) {
        playlist.agregarCancion(cancion);
        System.out.println("Añadida a la playlist \"" + playlist.getNombre() + "\": " + cancion);
    }

    public void eliminarCancionDePlaylist(Playlist playlist, Cancion cancion) {
        playlist.eliminarCancion(cancion);
        System.out.println("Eliminada de la playlist \"" + playlist.getNombre() + "\": " + cancion);
    }

    public void verCancionesDePlaylist(Playlist playlist) {
        System.out.println("Canciones en la playlist \"" + playlist.getNombre() + "\":");
        playlist.mostrarCanciones();
    }

    public void agregarCancionACola(Cancion cancion) {
        colaReproduccion.encolar(cancion);
        System.out.println("Añadida a la cola de reproducción: " + cancion);
    }
}