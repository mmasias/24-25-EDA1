class Biblioteca {
    private Cancion[] canciones;
    private int cantidadCanciones;

    public Biblioteca(int capacidad) {
        canciones = new Cancion[capacidad];
        cantidadCanciones = 0;
    }

    public void agregarCancion(Cancion cancion) {
        if (cantidadCanciones < canciones.length) {
            canciones[cantidadCanciones++] = cancion;
            System.out.println("Canción agregada: " + cancion);
        } else {
            System.out.println("La biblioteca está llena.");
        }
    }

    public void mostrarCanciones() {
        System.out.println("=== Canciones en la Biblioteca ===");
        for (int i = 0; i < cantidadCanciones; i++) {
            System.out.println((i + 1) + ". " + canciones[i]);
        }
    }

    public Cancion obtenerCancion(int indice) {
        if (indice >= 0 && indice < cantidadCanciones) {
            return canciones[indice];
        } else {
            System.out.println("Índice de canción no válido.");
            return null;
        }
    }

    public int getCantidadCanciones() {
        return cantidadCanciones;
    }
}
