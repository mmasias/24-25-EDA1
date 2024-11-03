
public class Reproductor {
    public Cancion cancionActual;
    public ColaReproduccion cola;
    public Historial historial;
    public boolean modoAleatorio;
    public boolean modoRepetir;
    public Playlist[] playlists;
    public int numPlaylists;
    public Cancion[] cancionesFavoritas;
    public int numFavoritas;

    public Reproductor() {
        cola = new ColaReproduccion();
        historial = new Historial();
        modoAleatorio = false;
        modoRepetir = false;
        playlists = new Playlist[10];  // Capacidad inicial
        numPlaylists = 0;
        cancionesFavoritas = new Cancion[10];  // Capacidad inicial
        numFavoritas = 0;
    }

    public void reproducir() {
        if (cola.estaVacia()) {
            System.out.println("La cola de reproducción está vacía.");
            return;
        }
        cancionActual = cola.obtenerSiguiente();
        historial.agregar(cancionActual);
        System.out.println("Reproduciendo: " + cancionActual);
    }

    public void siguiente() {
        if (modoRepetir && cancionActual != null) {
            System.out.println("Reproduciendo de nuevo: " + cancionActual);
        } else if (!cola.estaVacia()) {
            reproducir();
        } else {
            System.out.println("No hay más canciones en la cola.");
        }
    }

    public void anterior() {
        Cancion anterior = historial.obtenerAnterior();
        if (anterior != null) {
            cancionActual = anterior;
            System.out.println("Reproduciendo: " + cancionActual);
        } else {
            System.out.println("No hay canciones en el historial.");
        }
    }

    public void mostrarCola() {
        cola.mostrar();
    }

    public void mostrarHistorial() {
        historial.mostrar();
    }

    public void activarModoAleatorio() {
        modoAleatorio = !modoAleatorio;
        System.out.println("Modo aleatorio " + (modoAleatorio ? "activado" : "desactivado"));
    }

    public void activarModoRepetir() {
        modoRepetir = !modoRepetir;
        System.out.println("Modo repetir " + (modoRepetir ? "activado" : "desactivado"));
    }

    public void añadirCancionAFavoritos(Cancion cancion) {
        if (numFavoritas >= cancionesFavoritas.length) {
            System.out.println("Lista de favoritas llena.");
            return;
        }
        cancionesFavoritas[numFavoritas++] = cancion;
        cancion.setFavorita(true);
        System.out.println("Añadida a favoritos: " + cancion);
    }

    public void eliminarCancionDeFavoritos(Cancion cancion) {
        boolean encontrada = false;
        for (int i = 0; i < numFavoritas; i++) {
            if (cancionesFavoritas[i].equals(cancion)) {
                encontrada = true;
                cancionesFavoritas[i] = cancionesFavoritas[--numFavoritas];
                cancionesFavoritas[numFavoritas] = null;
                cancion.setFavorita(false);
                break;
            }
        }
        if (encontrada) {
            System.out.println("Eliminada de favoritos: " + cancion);
        } else {
            System.out.println("Canción no encontrada en favoritos.");
        }
    }

    public void verCancionesFavoritas() {
        if (numFavoritas == 0) {
            System.out.println("No hay canciones en la lista de favoritos.");
            return;
        }
        for (int i = 0; i < numFavoritas; i++) {
            System.out.println((i + 1) + ". " + cancionesFavoritas[i]);
        }
    }

    public void crearPlaylist(String nombre) {
        if (numPlaylists >= playlists.length) {
            System.out.println("Capacidad máxima de playlists alcanzada.");
            return;
        }
        playlists[numPlaylists++] = new Playlist(nombre);
        System.out.println("Playlist creada: " + nombre);
    }

    public void verPlaylists() {
        if (numPlaylists == 0) {
            System.out.println("No hay playlists disponibles.");
            return;
        }
        for (int i = 0; i < numPlaylists; i++) {
            System.out.println((i + 1) + ". " + playlists[i].getNombre());
        }
    }

    public void añadirCancionAPlaylist(int indexPlaylist, Cancion cancion) {
        if (indexPlaylist < 0 || indexPlaylist >= numPlaylists) {
            System.out.println("Índice de playlist no válido.");
            return;
        }
        playlists[indexPlaylist].agregarCancion(cancion);
        System.out.println("Canción añadida a la playlist: " + cancion);
    }
}
