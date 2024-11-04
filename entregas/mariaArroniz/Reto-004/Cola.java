import java.util.Scanner;

class Cola {

    private Cola next;
    private Cancion primera = null;

    public int tamañoCola() {
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

    public void sonando() {
        System.out.println("Está sonando: " + this.primera.getNombre());
    }

    public void siguiente() {
        int tamaño = tamañoCola();

        if (tamaño <= 1) {
            System.out.println("No hay siguiente cancion en cola");
        } else {
            Cancion iterador = this.primera;
            System.out.println("Ahora sonando: " + this.primera.getNext().getNombre());

        }
    }

    public void imprimir() {
        int tamaño = this.tamañoCola();

        if (tamaño == 0) {
            System.out.println("Todavía no hay canciones en la cola");
            return;
        }

        Cancion iterador = this.primera;
        System.out.println("Canciones:");
        while (iterador != null) {
            System.out.println("- " + iterador.getNombre());
            iterador = (Cancion) iterador.getNext();
        }
    }

    public void getPrevious() {

    }
}
