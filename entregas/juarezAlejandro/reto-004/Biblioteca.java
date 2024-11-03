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
        System.out.println("1");
        canciones.agregarCancion(new Cancion("505", "Arctic Monkeys", 413));
        System.out.println("2");
        canciones.agregarCancion(new Cancion("Whyd You Only Call Me When Youre High?", "Arctic Monkeys", 241));
        System.out.println("3");
        canciones.agregarCancion(new Cancion("I Wanna Be Yours", "Arctic Monkeys", 303));
        System.out.println("4");
        canciones.agregarCancion(new Cancion("Stop the World I Wanna Get Off With You", "Arctic Monkeys", 311));
        System.out.println("5");
        canciones.agregarCancion(new Cancion("Fireside", "Arctic Monkeys", 301));
        System.out.println("6");
        canciones.agregarCancion(new Cancion("R U Mine?", "Arctic Monkeys", 321));
        System.out.println("7");
        canciones.agregarCancion(new Cancion("Do I Wanna Know?", "Arctic Monkeys", 432));
        System.out.println("8");
        canciones.agregarCancion(new Cancion("Snap Out Of It", "Arctic Monkeys", 313));
        System.out.println("9");
        canciones.agregarCancion(new Cancion("Knee Socks", "Arctic Monkeys", 417));
        System.out.println("10");
        canciones.agregarCancion(new Cancion("Arabella", "Arctic Monkeys", 327));
        System.out.println("11");
        canciones.agregarCancion(new Cancion("Sex, Drugs, Etc", "Beach Weather", 316));
        System.out.println("12");
        canciones.agregarCancion(new Cancion("Chit Chat", "Beach Weather", 320));
        System.out.println("13");
        canciones.agregarCancion(new Cancion("Unlovable", "Beach Weather", 330));
        System.out.println("14");
        canciones.agregarCancion(new Cancion("Swoon", "Beach Weather", 341));
        System.out.println("15");
        canciones.agregarCancion(new Cancion("The Beach", "The Neighbourhood", 415));
        System.out.println("16");
        canciones.agregarCancion(new Cancion("White Mustang", "Lana Del Rey", 244));
        System.out.println("17");
        canciones.agregarCancion(new Cancion("Video Games", "Lana Del Rey", 441));
        System.out.println("18");
        canciones.agregarCancion(new Cancion("Summertime Sadness", "Lana Del Rey", 425));
        System.out.println("19");
        canciones.agregarCancion(new Cancion("Diet Mountain Draw", "Lana Del Rey", 342));
        System.out.println("20");
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
