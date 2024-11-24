package reto004;

class ListaReproduccion {
    private Cancion cabeza;
    private Cancion actual;
    private Cancion favoritosCabeza;

    public ListaReproduccion() {
        this.cabeza = null;
        this.actual = null;
        this.favoritosCabeza = null;
    }

    public void agregarCancion(String nombre, int duracion) {
        Cancion nuevaCancion = new Cancion(nombre, duracion);
        if (cabeza == null) {
            cabeza = nuevaCancion;
            actual = nuevaCancion;
        } else {
            Cancion temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevaCancion;
        }
    }

    public void agregarAFavoritos(int indice) {
        Cancion temp = cabeza;
        int contador = 0;

        while (temp != null) {
            if (contador == indice) {
                Cancion nuevaFavorita = new Cancion(temp.getNombre(), temp.getDuracion());
                if (favoritosCabeza == null) {
                    favoritosCabeza = nuevaFavorita;
                } else {
                    Cancion fTemp = favoritosCabeza;
                    while (fTemp.siguiente != null) {
                        fTemp = fTemp.siguiente;
                    }
                    fTemp.siguiente = nuevaFavorita;
                }
                System.out.println("Canción añadida a favoritos: " + temp.getNombre());
                return;
            }
            temp = temp.siguiente;
            contador++;
        }
        System.out.println("Índice de canción no válido.");
    }

    public void mostrarFavoritos() {
        if (favoritosCabeza == null) {
            System.out.println("No hay canciones en favoritos.");
            return;
        }
        Cancion temp = favoritosCabeza;
        while (temp != null) {
            System.out.println("- " + temp.getNombre() + " (Duración: " + temp.getDuracion() + " segundos)");
            temp = temp.siguiente;
        }
    }

    public void siguienteCancion() {
        if (actual != null) {
            actual = actual.siguiente;
            if (actual != null) {
                System.out.println("Reproduciendo: " + actual.getNombre() + " (Duración: " + actual.getDuracion() + " segundos)");
            } else {
                System.out.println("No hay más canciones.");
            }
        } else {
            System.out.println("No hay canciones en la lista.");
        }
    }

    public void anteriorCancion() {
        if (cabeza == null || cabeza == actual) {
            System.out.println("No hay canción anterior.");
            return;
        }

        Cancion temp = cabeza;
        while (temp.siguiente != null && temp.siguiente != actual) {
            temp = temp.siguiente;
        }

        if (temp != null) {
            actual = temp;
            System.out.println("Reproduciendo: " + actual.getNombre() + " (Duración: " + actual.getDuracion() + " segundos)");
        }
    }

    public void mostrarCanciones() {
        Cancion temp = cabeza;
        int indice = 0;
        while (temp != null) {
            System.out.println(indice + ". " + temp.getNombre() + " (Duración: " + temp.getDuracion() + " segundos)");
            temp = temp.siguiente;
            indice++;
        }
    }

    public Cancion getCancionActual() {
        return actual;
    }
}
