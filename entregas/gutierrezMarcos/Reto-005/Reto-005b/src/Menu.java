import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    int opcion = 0;

    public Menu(){
        System.out.println("1. Mostrar Ramas");
        System.out.println("2. Crear Rama");
        System.out.println("3. Eliminar Rama");
        System.out.println("4. Moverse de Rama");
        System.out.println("5. Guardar Versión");
        System.out.println("6. Mostrar Versión");
        System.out.println("7. Ir a Versión Anterior");
        System.out.println("8. Ir a Versión Siguiente");

        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                
                break;
        
            default:
                break;
        }
    }
}
