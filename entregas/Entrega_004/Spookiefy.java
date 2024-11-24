package entregas.Entrega_004;
import java.util.Scanner;

public class Spookiefy {
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproduccion");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Has seleccionado la Opción 1");
                    
                    break;
                case 2:
                    System.out.println("Has seleccionado la Opción 2");
                    
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
    }
}
