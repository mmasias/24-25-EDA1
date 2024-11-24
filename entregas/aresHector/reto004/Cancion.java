class Cancion {
    private String titulo;
    private String artista;
    private int duracion;    
    private boolean favorita;
    
    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.favorita = false;
    }

    public String toString() {
        return titulo + " - " + artista + " (" + duracion + "s)";
    }

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }
}

class Playlist {
    private String nombre;
    private NodoCancion cabeza;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.cabeza = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void eliminarCancion(Cancion cancion) {
        if (cabeza == null) return;

        if (cabeza.cancion.equals(cancion)) {
            cabeza = cabeza.siguiente;
            return;
        }

        NodoCancion actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.cancion.equals(cancion)) {
                actual.siguiente = actual.siguiente.siguiente;
                return;
            }
            actual = actual.siguiente;
        }
    }

    public void mostrarCanciones() {
        if (cabeza == null) {
            System.out.println("No hay canciones en la playlist.");
            return;
        }
        NodoCancion actual = cabeza;
        int i = 1;
        while (actual != null) {
            System.out.println(i + ". " + actual.cancion);
            actual = actual.siguiente;
            i++;
        }
    }
}

class NodoCancion {
    Cancion cancion;
    NodoCancion siguiente;

    public NodoCancion(Cancion cancion) {
        this.cancion = cancion;
        this.siguiente = null;
    }
}

class Reproductor {
    private ColaReproduccion cola;
    private Historial historial;
    private boolean modoAleatorio;
    private boolean modoRepetir;
    public Cancion cancionActual;
    public Playlist[] playlists;
    public int numPlaylists;
    Cancion[] cancionesFavoritas;
    public int numFavoritas;
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
        System.out.println("Modo aleatorio: " + (modoAleatorio ? "Activado" : "Desactivado"));
    }

    public void activarModoRepetir() {
        modoRepetir = !modoRepetir;
        System.out.println("Modo repetir: " + (modoRepetir ? "Activado" : "Desactivado"));
    }

    public void mostrarHistorial() {
        historial.mostrarHistorial();
    }

    public void agregarCancionACola(Cancion cancion) {
        cola.agregarCancion(cancion);
    }

    public void crearPlaylist(String nombre) {
        if (numPlaylists < playlists.length) {
            playlists[numPlaylists++] = new Playlist(nombre);
            System.out.println("Playlist \"" + nombre + "\" creada con éxito.");
        } else {
            System.out.println("No se pueden crear más playlists.");
        }
    }

    public void verPlaylists() {
        System.out.println("Playlists disponibles:");
        for (int i = 0; i < numPlaylists; i++) {
            System.out.println((i + 1) + ". " + playlists[i].getNombre());
        }
    }

    public void añadirCancionAPlaylist(int indicePlaylist, Cancion cancion) {
        if (indicePlaylist >= 0 && indicePlaylist < numPlaylists) {
            playlists[indicePlaylist].agregarCancion(cancion);
            System.out.println("\"" + cancion + "\" añadida a " + playlists[indicePlaylist].getNombre());
        } else {
            System.out.println("Playlist no válida.");
        }
    }

    public void mostrarCancionesDisponibles() {
        System.out.println("Canciones disponibles:");
        for (int i = 0; i < Main.cancionesDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + Main.cancionesDisponibles[i]);
        }
    }
    
    public void mostrarCola() {
        if (cola.estaVacia()) {
            System.out.println("La cola de reproducción está vacía.");
            return;
        }
        NodoCancion actual = cola.frente;
        int i = 1;
        while (actual != null) {
            System.out.println(i + ". " + actual.cancion + (actual == cola.frente ? " (ACTUAL)" : ""));
            actual = actual.siguiente;
            i++;
        }
    }

    public void añadirCancionAFavoritos(Cancion cancion) {
        if (numFavoritas < cancionesFavoritas.length) {
            cancionesFavoritas[numFavoritas++] = cancion;
            cancion.setFavorita(true);
            System.out.println("\"" + cancion + "\" añadida a favoritos.");
        } else {
            System.out.println("No se pueden añadir más canciones a favoritos.");
        }
    }

    public void eliminarCancionDeFavoritos(Cancion cancion) {
        for (int i = 0; i < numFavoritas; i++) {
            if (cancionesFavoritas[i].equals(cancion)) {
                cancionesFavoritas[i].setFavorita(false);
                cancionesFavoritas[i] = cancionesFavoritas[numFavoritas - 1];
                cancionesFavoritas[numFavoritas - 1] = null;
                numFavoritas--;
                System.out.println("\"" + cancion + "\" eliminada de favoritos.");
                return;
            }
        }
        System.out.println("La canción no está en favoritos.");
    }

    public Cancion[] getCancionesFavoritas() {
        Cancion[] favoritas = new Cancion[numFavoritas];
        System.arraycopy(cancionesFavoritas, 0, favoritas, 0, numFavoritas);
        return favoritas;
    }

    public void verCancionesFavoritas() {
        System.out.println("Canciones favoritas:");
        for (int i = 0; i < numFavoritas; i++) {
            System.out.println((i + 1) + ". " + cancionesFavoritas[i]);
        }
    }
}

class ColaReproduccion {
    public NodoCancion frente;
    private NodoCancion fin;

    public ColaReproduccion() {
        this.frente = null;
        this.fin = null;
    }

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        if (fin != null) {
            fin.siguiente = nuevoNodo;
        }
        fin = nuevoNodo;
        if (frente == null) {
            frente = nuevoNodo;
        }
    }

    public Cancion siguienteCancion() {
        if (frente == null) return null;
        Cancion cancion = frente.cancion;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return cancion;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}

class Historial {
    private NodoCancion cabeza;

    public Historial() {
        this.cabeza = null;
    }

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void mostrarHistorial() {
        NodoCancion actual = cabeza;
        System.out.println("HISTORIAL DE REPRODUCCIÓN:");
        while (actual != null) {
            System.out.println(actual.cancion);
            actual = actual.siguiente;
        }
    }
}