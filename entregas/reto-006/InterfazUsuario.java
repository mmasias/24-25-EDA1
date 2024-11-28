import java.util.Scanner;

public class InterfazUsuario {
    private ColeccionLineas lineas;

    public InterfazUsuario(ColeccionLineas lineas) {
        this.lineas = lineas;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;

        System.out.println("¡Bienvenido al Editor de Texto!");
        while (ejecutando) {
            System.out.println("[S] Salir");
            System.out.print("Elige una opción: ");
            String opcion = scanner.nextLine().toUpperCase();

            switch (opcion) {
                case "S":
                    ejecutando = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}