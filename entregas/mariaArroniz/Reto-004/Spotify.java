import java.util.Scanner;

class Spotify {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuReproduccion menuReproduccion = new MenuReproduccion();
        MenuBiblioteca menuBiblioteca = new MenuBiblioteca();
        int seleccion;

        do {
            menuPrincipal.imprimir();
            System.out.println("Seleccione una opcion: ");
            seleccion = scanner.nextInt();

            switch (seleccion) {
                case 1:
                    menuReproduccion.imprimir();
                    menuReproduccion.seleccionar();
                    break;
                case 2:
                    menuBiblioteca.imprimir();
                    menuBiblioteca.seleccionar();
                    break;
                case 3:
                    break;
            }
        } while (seleccion != 3);
    }
}
