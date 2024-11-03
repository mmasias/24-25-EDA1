import java.util.Scanner;

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

    public void mostrarCanciones() {
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
class ColaReproduccion {
    public NodoCancion frente; // Cambiar a público para acceso en Reproductor
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
class Reproductor {
    private ColaReproduccion cola;
    private Historial historial;
    private boolean modoAleatorio;
    private boolean modoRepetir;
    public Cancion cancionActual; // Cambiado a público para acceso directo
    private Playlist[] playlists;
    private int numPlaylists;

    public Reproductor() {
        this.cola = new ColaReproduccion();
        this.historial = new Historial();
        this.modoAleatorio = false;
        this.modoRepetir = false;
        this.playlists = new Playlist[10]; // Limite de 10 playlists
        this.numPlaylists = 0;
    }

    public void reproducir() {
        if (cola.estaVacia()) {
            System.out.println("No hay canciones en la cola.");
            return;
        }
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
        // Implementa aquí la lógica para manejar la canción anterior
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
        NodoCancion actual = cola.frente; // Aquí asumimos que tienes acceso a "frente"
        int i = 1;
        while (actual != null) {
            System.out.println(i + ". " + actual.cancion + (actual == cola.frente ? " (ACTUAL)" : ""));
            actual = actual.siguiente;
            i++;
        }
    }
}