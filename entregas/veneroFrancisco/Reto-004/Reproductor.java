class Reproductor {
    private ColaReproduccion cola;
    private Historial historial;
    private boolean modoAleatorio;
    private boolean modoRepetir;
    private Cancion cancionActual;
    private Playlist[] playlists;
    private int numPlaylists;
    private Cancion[] cancionesFavoritas;
    private int numFavoritas;
    private Cancion cancionAnterior;

    public Reproductor() {
        this.cola = new ColaReproduccion();
        this.historial = new Historial();
        this.modoAleatorio = false;
        this.modoRepetir = false;
        this.playlists = new Playlist[10];
        this.numPlaylists = 0;
        this.cancionesFavoritas = new Cancion[20];
        this.numFavoritas = 0;
        this.cancionAnterior = null;
    }

    public void verCancionActual() {
        if (cancionActual == null) {
            System.out.println("No hay canción en reproducción.");
        } else {
            System.out.println("Canción actual: " + cancionActual);
        }
    }

    public void reproducir() {
        if (cola.estaVacia()) {
            System.out.println("No hay canciones en la cola.");
            return;
        }
        cancionAnterior = cancionActual;
        cancionActual = cola.siguienteCancion();
        historial.agregarCancion(cancionActual);
        System.out.println("▶ Reproduciendo: " + cancionActual);
    }

    public void siguiente() {
        if (modoRepetir) {
            cola.agregarCancion(cancionActual);
        }
        reproducir();
    }

    public void anterior() {
        if (cancionAnterior != null) {
            System.out.println("▶ Reproduciendo: " + cancionAnterior);
            cancionActual = cancionAnterior;
            cancionAnterior = null;
            historial.agregarCancion(cancionActual);
        } else {
            System.out.println("No hay canción anterior para reproducir.");
        }
    }

    public void activarModoAleatorio() {
        modoAleatorio = !modoAleatorio;
        String estado = modoAleatorio ? "activado" : "desactivado";
        System.out.println("Modo aleatorio " + estado + ".");
    }

    public void activarModoRepetir() {
        modoRepetir = !modoRepetir;
        String estado = modoRepetir ? "activado" : "desactivado";
        System.out.println("Modo repetir " + estado + ".");
    }

    public void mostrarCola() {
        cola.mostrarCola();
    }

    public void mostrarHistorial() {
        historial.mostrarHistorial();
    }

    public void añadirCancionAFavoritos(int index) {
        if (index < 0 || index >= Main.cancionesDisponibles.length) {
            System.out.println("Índice inválido.");
            return;
        }
        Cancion cancion = Main.cancionesDisponibles[index];
        if (numFavoritas >= 20) {
            System.out.println("Ya tienes el máximo de canciones favoritas.");
            return;
        }
        cancionesFavoritas[numFavoritas++] = cancion;
        cancion.setFavorita(true);
        System.out.println("Canción añadida a favoritos: " + cancion);
    }

    public void eliminarCancionDeFavoritos(int index) {
        if (index < 0 || index >= numFavoritas) {
            System.out.println("Índice inválido.");
            return;
        }
        Cancion cancion = cancionesFavoritas[index];
        cancion.setFavorita(false);
        System.arraycopy(cancionesFavoritas, index + 1, cancionesFavoritas, index, numFavoritas - index - 1);
        numFavoritas--;
        System.out.println("Canción eliminada de favoritos: " + cancion);
    }

    public void verCancionesFavoritas() {
        System.out.println("=== Canciones Favoritas ===");
        if (numFavoritas == 0) {
            System.out.println("No hay canciones favoritas.");
            return;
        }
        for (int i = 0; i < numFavoritas; i++) {
            System.out.println((i + 1) + ". " + cancionesFavoritas[i]);
        }
    }

    public void crearPlaylist(String nombre) {
        if (numPlaylists >= playlists.length) {
            System.out.println("Máximo de playlists alcanzado.");
            return;
        }
        playlists[numPlaylists++] = new Playlist(nombre);
        System.out.println("Playlist creada: " + nombre);
    }

    public void verPlaylists() {
        System.out.println("=== Playlists ===");
        if (numPlaylists == 0) {
            System.out.println("No hay playlists.");
            return;
        }
        for (int i = 0; i < numPlaylists; i++) {
            System.out.println((i + 1) + ". " + playlists[i].getNombre());
        }
    }

    public void añadirCancionAPlaylist(int index, int cancionIndex) {
        if (index < 0 || index >= numPlaylists) {
            System.out.println("Índice de playlist inválido.");
            return;
        }
        if (cancionIndex < 0 || cancionIndex >= Main.cancionesDisponibles.length) {
            System.out.println("Índice de canción inválido.");
            return;
        }
        playlists[index].agregarCancion(Main.cancionesDisponibles[cancionIndex]);
        System.out.println("Canción añadida a la playlist: " + Main.cancionesDisponibles[cancionIndex]);
    }

    public void mostrarCancionesDisponibles() {
        System.out.println("=== Canciones Disponibles ===");
        for (int i = 0; i < Main.cancionesDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + Main.cancionesDisponibles[i]);
        }
    }
}