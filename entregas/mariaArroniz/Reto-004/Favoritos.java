import java.util.Scanner;

class Favoritos {

    private Favoritos next;
    private Cancion primera = null;

    public int tamañoFavoritos() {

        if (this.primera == null) {
            return 0;
        }
        int contador = 1;
        Cancion iterador = primera;
        while (iterador.getNext() != null) {
            contador++;
            iterador = (Cancion) iterador.getNext();
        }
        return contador;
    }

    public void añadirCancion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qué canción quiere añadir: ");
        String nombre = scanner.nextLine();
        System.out.println("Cuánto dura la canción: ");
        int duracion = scanner.nextInt();

        Cancion cancion = new Cancion(nombre, duracion);
        this.primera=cancion;

        if (this.primera == null) {
            this.primera = cancion;
        } else {
            Cancion iterador = this.primera;
            while (iterador.getNext() != null) {
                iterador = (Cancion) iterador.getNext();
            }
            iterador.setNext(cancion);
        }

    }

    public void eliminarCancion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qué canción quiere eliminar: ");
        String nombre = scanner.nextLine();

        Cancion iterador = this.primera;
        if (iterador == null) {
            System.out.println("No hay canciones para eliminar");
        } else if (iterador.getNombre() == nombre) {
            iterador = null;
        } else {
            iterador.getNext();
        }
        
    }

    public String[] imprimir() {
        String[] favoritos = new String[this.tamañoFavoritos()];
        Cancion iterador = this.primera;

        if (tamañoFavoritos() == 0) {
            System.out.println("Todavía no hay canciones en la favoritos");
        }
        int contador = 0;
        while (iterador != null) {
            favoritos[contador] = iterador.getNombre();
            contador++;
            iterador = (Cancion) iterador.getNext();
        }
        return favoritos;
        
    }


}
