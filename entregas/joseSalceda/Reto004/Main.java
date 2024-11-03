package entregas.joseSalceda.Reto004;

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

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " [" + duracion + "s]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cancion cancion = (Cancion) obj;
        return titulo.equals(cancion.titulo) && artista.equals(cancion.artista);
    }
}

class Album {
    private String titulo;
    private String artista;
    private int año;
    private ListaDoble<Cancion> canciones;
    
    public Album(String titulo, String artista, int año) {
        this.titulo = titulo;
        this.artista = artista;
        this.año = año;
        this.canciones = new ListaDoble<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.agregar(cancion);
    }

    public ListaDoble<Cancion> getCanciones() {
        return canciones;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + año + ")";
    }
}

// Lista doblemente enlazada para la biblioteca general y playlists
class NodoDoble<T> {
    T dato;
    NodoDoble<T> siguiente;
    NodoDoble<T> anterior;
    
    public NodoDoble(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}

class ListaDoble<T> {
    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int tamaño;
    
    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }
    
    public void agregar(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        tamaño++;
    }
    
    public void eliminar(T dato) {
        NodoDoble<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                } else {
                    cabeza = actual.siguiente;
                }
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                } else {
                    cola = actual.anterior;
                }
                tamaño--;
                return;
            }
            actual = actual.siguiente;
        }
    }
    
    public int getTamaño() {
        return tamaño;
    }
    
    public T obtener(int indice) {
        if (indice < 0 || indice >= tamaño) return null;
        NodoDoble<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    public void mostrar() {
        NodoDoble<T> actual = cabeza;
        int indice = 1;
        while (actual != null) {
            System.out.println(indice + ". " + actual.dato);
            actual = actual.siguiente;
            indice++;
        }
    }
}

// Pila para el historial de reproducción
class Pila<T> {
    private NodoDoble<T> tope;
    private int tamaño;
    
    public Pila() {
        this.tope = null;
        this.tamaño = 0;
    }
    
    public void push(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (tope != null) {
            nuevo.siguiente = tope;
            tope.anterior = nuevo;
        }
        tope = nuevo;
        tamaño++;
    }
    
    public T pop() {
        if (tope == null) return null;
        T dato = tope.dato;
        tope = tope.siguiente;
        if (tope != null) {
            tope.anterior = null;
        }
        tamaño--;
        return dato;
    }
    
    public T peek() {
        return tope != null ? tope.dato : null;
    }

    public void mostrar() {
        NodoDoble<T> actual = tope;
        int indice = 1;
        while (actual != null) {
            System.out.println(indice + ". " + actual.dato);
            actual = actual.siguiente;
            indice++;
        }
    }
}

// Cola para la reproducción actual
class Cola<T> {
    private NodoDoble<T> frente;
    private NodoDoble<T> final_;
    private int tamaño;
    
    public Cola() {
        this.frente = null;
        this.final_ = null;
        this.tamaño = 0;
    }
    
    public void encolar(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (final_ == null) {
            frente = nuevo;
            final_ = nuevo;
        } else {
            final_.siguiente = nuevo;
            nuevo.anterior = final_;
            final_ = nuevo;
        }
        tamaño++;
    }
    
    public T desencolar() {
        if (frente == null) return null;
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente != null) {
            frente.anterior = null;
        } else {
            final_ = null;
        }
        tamaño--;
        return dato;
    }
    
    public T peek() {
        return frente != null ? frente.dato : null;
    }

    public void mostrar() {
        NodoDoble<T> actual = frente;
        int indice = 1;
        while (actual != null) {
            if (indice == 1) {
                System.out.println(indice + ". ▶ " + actual.dato + " (ACTUAL)");
            } else {
                System.out.println(indice + ". " + actual.dato);
            }
            actual = actual.siguiente;
            indice++;
        }
    }

    public int getTamaño() {
        return tamaño;
    }
}

class SistemaReproduccion {
    private ListaDoble<Cancion> biblioteca;
    private ListaDoble<Cancion> favoritas;
    private ListaDoble<Playlist> playlists;
    private Cola<Cancion> colaReproduccion;
    private Pila<Cancion> historial;
    private Cancion cancionActual;
    private boolean modoAleatorio;
    private boolean modoRepeticion;
    
    public SistemaReproduccion() {
        this.biblioteca = new ListaDoble<>();
        this.favoritas = new ListaDoble<>();
        this.playlists = new ListaDoble<>();
        this.colaReproduccion = new Cola<>();
        this.historial = new Pila<>();
        this.modoAleatorio = false;
        this.modoRepeticion = false;
        
        inicializarBiblioteca();
    }

    public Cancion getCancionActual() {
        return cancionActual;
    }

    public boolean hayCancionActual() {
        return cancionActual != null;
    }
    
    private void inicializarBiblioteca() {
        biblioteca.agregar(new Cancion("Demoliendo Hoteles", "Charly García", 258));
        biblioteca.agregar(new Cancion("Los Dinosaurios", "Charly García", 234));
        biblioteca.agregar(new Cancion("Rasguña Las Piedras", "Sui Generis", 285));
        biblioteca.agregar(new Cancion("Canción Para Mi Muerte", "Sui Generis", 342));
        biblioteca.agregar(new Cancion("No Soy Un Extraño", "Charly García", 295));
        biblioteca.agregar(new Cancion("Seminare", "Serú Girán", 238));
        biblioteca.agregar(new Cancion("Promesas Sobre El Bidet", "Charly García", 243));
        biblioteca.agregar(new Cancion("Rezo Por Vos", "Charly García & Luis Alberto Spinetta", 266));
        biblioteca.agregar(new Cancion("Película sordomuda", "Charly García", 235));
        biblioteca.agregar(new Cancion("¿Qué se puede hacer salvo ver películas?", "La máquina de hacer pájaros", 325));
    }
    
    public void mostrarBiblioteca() {
        System.out.println("\nCanciones disponibles:\n");
        biblioteca.mostrar();
    }

    public void reproducirCancion(int indice) {
        Cancion cancion = biblioteca.obtener(indice - 1);  // Ajustamos el índice ya que mostramos desde 1
        if (cancion != null) {
            if (cancionActual != null) {
                historial.push(cancionActual);
            }
            cancionActual = cancion;
            System.out.println("\n▶ Reproduciendo: " + cancionActual);
        }
    }
    
    public void siguienteCancion() {
        if (cancionActual != null) {
            historial.push(cancionActual);
        }
        if (modoAleatorio) {
            int indiceAleatorio = (int) (Math.random() * biblioteca.getTamaño());
            cancionActual = biblioteca.obtener(indiceAleatorio);
        } else {
            cancionActual = colaReproduccion.desencolar();
            if (cancionActual == null && modoRepeticion) {
                reproducirCancion(1);  // Volver a empezar si está activada la repetición
            }
        }
        if (cancionActual != null) {
            System.out.println("\n▶ Reproduciendo: " + cancionActual);
        } else {
            System.out.println("\nNo hay más canciones en la cola.");
        }
    }
    
    public void cancionAnterior() {
        Cancion anterior = historial.pop();
        if (anterior != null) {
            if (cancionActual != null) {
                colaReproduccion.encolar(cancionActual);
            }
            cancionActual = anterior;
            System.out.println("\n▶ Reproduciendo: " + cancionActual);
        } else {
            System.out.println("\nNo hay canciones anteriores en el historial.");
        }
    }
    
    public void verCancionActual() {
        if (cancionActual != null) {
            System.out.println("\n▶ Reproduciendo actualmente: " + cancionActual);
        } else {
            System.out.println("\nNo hay canción en reproducción.");
        }
    }
    
    public void verColaReproduccion() {
        if (colaReproduccion.getTamaño() > 0) {
            System.out.println("\nCOLA DE REPRODUCCIÓN:");
            colaReproduccion.mostrar();
        } else {
            System.out.println("\nLa cola de reproducción está vacía.");
        }
        System.out.println("\nEstado: " + (modoAleatorio ? "Aleatorio" : "Normal") + 
                          " | Repetición: " + (modoRepeticion ? "ON" : "OFF"));
    }
    
    public void verHistorial() {
        System.out.println("\nHISTORIAL DE REPRODUCCIÓN:");
        historial.mostrar();
    }
    
    public void toggleModoAleatorio() {
        modoAleatorio = !modoAleatorio;
        System.out.println("\nModo aleatorio: " + (modoAleatorio ? "Activado" : "Desactivado"));
    }
    
    public void toggleModoRepeticion() {
        modoRepeticion = !modoRepeticion;
        System.out.println("\nModo repetición: " + (modoRepeticion ? "Activado" : "Desactivado"));
    }
    
    public void agregarAFavoritos(int indice) {
        Cancion cancion = biblioteca.obtener(indice - 1);
        if (cancion != null && !cancion.isFavorita()) {
            favoritas.agregar(cancion);
            cancion.setFavorita(true);
            System.out.println("\n'" + cancion.getTitulo() + "' añadida a favoritos");
        }
    }
    
    public void eliminarDeFavoritos(int indice) {
        Cancion cancion = favoritas.obtener(indice - 1);
        if (cancion != null) {
            favoritas.eliminar(cancion);
            cancion.setFavorita(false);
            System.out.println("\n'" + cancion.getTitulo() + "' eliminada de favoritos");
        }
    }
    
    public void verFavoritas() {
        System.out.println("\nCANCIONES FAVORITAS:");
        favoritas.mostrar();
    }
    
    public void crearPlaylist(String nombre) {
        playlists.agregar(new Playlist(nombre));
        System.out.println("\nPlaylist '" + nombre + "' creada con éxito.");
    }
    
    public void mostrarPlaylists() {
        System.out.println("\nPLAYLISTS DISPONIBLES:");
        playlists.mostrar();
    }
    
    public void agregarAPlaylist(int indicePlaylist, int indiceCancion) {
        Playlist playlist = playlists.obtener(indicePlaylist - 1);
        Cancion cancion = biblioteca.obtener(indiceCancion - 1);
        if (playlist != null && cancion != null) {
            playlist.agregarCancion(cancion);
            System.out.println("\n'" + cancion.getTitulo() + "' añadida a " + playlist.getNombre());
        }
    }

    public void eliminarDePlaylist(int indicePlaylist, int indiceCancion) {
        Playlist playlist = playlists.obtener(indicePlaylist - 1);
        if (playlist != null) {
            Cancion cancion = playlist.getCancion(indiceCancion - 1);
            if (cancion != null) {
                playlist.eliminarCancion(cancion);
                System.out.println("\n'" + cancion.getTitulo() + "' eliminada de " + playlist.getNombre());
            }
        }
    }
    
    public void verCancionesPlaylist(int indice) {
        Playlist playlist = playlists.obtener(indice - 1);
        if (playlist != null) {
            System.out.println("\nCANCIONES EN " + playlist.getNombre().toUpperCase() + ":");
            playlist.mostrarCanciones();
        }
    }
}

class Playlist {
    private String nombre;
    private ListaDoble<Cancion> canciones;
    
    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ListaDoble<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void agregarCancion(Cancion cancion) {
        canciones.agregar(cancion);
    }
    
    public void eliminarCancion(Cancion cancion) {
        canciones.eliminar(cancion);
    }
    
    public Cancion getCancion(int indice) {
        return canciones.obtener(indice);
    }
    
    public void mostrarCanciones() {
        canciones.mostrar();
    }
    
    @Override
    public String toString() {
        return nombre + " (" + canciones.getTamaño() + " canciones)";
    }
}


class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SistemaReproduccion sistema = new SistemaReproduccion();
    
    public static void main(String[] args) {
        System.out.println("=== SPOTIFY ===\n");
        System.out.println("BIBLIOTECA INICIAL");
        sistema.mostrarBiblioteca();
        
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    menuReproduccion();
                    break;
                case 2:
                    menuBiblioteca();
                    break;
                case 3:
                    System.out.println("\n¡Hasta luego!");
                    break;
                default:
                    System.out.println("\nOpción no válida.");
            }
        } while (opcion != 3);
    }
    
    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Reproducción");
        System.out.println("2. Biblioteca");
        System.out.println("3. Salir");
        System.out.print("\nSeleccione una opción: ");
    }
    
    private static void menuReproduccion() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ REPRODUCCIÓN ===");
            System.out.println("1. Ver canción actual");
            System.out.println("2. Reproducir siguiente");
            System.out.println("3. Reproducir anterior");
            System.out.println("4. Ver cola de reproducción");
            System.out.println("5. Ver historial");
            System.out.println("6. Activar/desactivar aleatorio");
            System.out.println("7. Activar/desactivar repetición");
            System.out.println("8. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    sistema.verCancionActual();
                    if (sistema.getCancionActual() == null) {
                        System.out.print("¿Desea comenzar a reproducir? (S/N): ");
                        if (scanner.nextLine().equalsIgnoreCase("S")) {
                            sistema.mostrarBiblioteca();
                            System.out.print("\nSeleccione canción: ");
                            sistema.reproducirCancion(scanner.nextInt());
                            scanner.nextLine();
                        }
                    }
                    break;
                case 2:
                    sistema.siguienteCancion();
                    break;
                case 3:
                    sistema.cancionAnterior();
                    break;
                case 4:
                    sistema.verColaReproduccion();
                    break;
                case 5:
                    sistema.verHistorial();
                    break;
                case 6:
                    sistema.toggleModoAleatorio();
                    break;
                case 7:
                    sistema.toggleModoRepeticion();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("\nOpción no válida.");
            }
        } while (opcion != 8);
    }
    
    private static void menuBiblioteca() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Añadir canción a favoritos");
            System.out.println("2. Eliminar canción de favoritos");
            System.out.println("3. Ver canciones favoritas");
            System.out.println("4. Crear nueva playlist");
            System.out.println("5. Añadir canción a playlist");
            System.out.println("6. Eliminar canción de playlist");
            System.out.println("7. Ver playlists");
            System.out.println("8. Ver canciones de una playlist");
            System.out.println("9. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    sistema.mostrarBiblioteca();
                    System.out.print("\nSeleccione canción para añadir a favoritos: ");
                    sistema.agregarAFavoritos(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 2:
                    sistema.verFavoritas();
                    System.out.print("\nSeleccione canción para eliminar de favoritos: ");
                    sistema.eliminarDeFavoritos(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 3:
                    sistema.verFavoritas();
                    break;
                case 4:
                    System.out.print("\nNombre de la nueva playlist: ");
                    sistema.crearPlaylist(scanner.nextLine());
                    break;
                case 5:
                    sistema.mostrarPlaylists();
                    System.out.print("\nSeleccione playlist: ");
                    int playlistIndex = scanner.nextInt();
                    sistema.mostrarBiblioteca();
                    System.out.print("\nSeleccione canción a añadir: ");
                    int cancionIndex = scanner.nextInt();
                    scanner.nextLine();
                    sistema.agregarAPlaylist(playlistIndex, cancionIndex);
                    
                    System.out.print("\n¿Desea añadir otra canción? (S/N): ");
                    while (scanner.nextLine().equalsIgnoreCase("S")) {
                        sistema.mostrarBiblioteca();
                        System.out.print("\nSeleccione canción a añadir: ");
                        cancionIndex = scanner.nextInt();
                        scanner.nextLine();
                        sistema.agregarAPlaylist(playlistIndex, cancionIndex);
                        System.out.print("\n¿Desea añadir otra canción? (S/N): ");
                    }
                    break;
                case 6:
                    sistema.mostrarPlaylists();
                    System.out.print("\nSeleccione playlist: ");
                    playlistIndex = scanner.nextInt();
                    sistema.verCancionesPlaylist(playlistIndex);
                    System.out.print("\nSeleccione canción a eliminar: ");
                    cancionIndex = scanner.nextInt();
                    scanner.nextLine();
                    sistema.eliminarDePlaylist(playlistIndex, cancionIndex);
                    break;
                case 7:
                    sistema.mostrarPlaylists();
                    break;
                case 8:
                    sistema.mostrarPlaylists();
                    System.out.print("\nSeleccione playlist: ");
                    sistema.verCancionesPlaylist(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("\nOpción no válida.");
            }
        } while (opcion != 9);
    }
}
    
