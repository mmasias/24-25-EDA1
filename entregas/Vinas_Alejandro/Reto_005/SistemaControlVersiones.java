package entregas.Vinas_Alejandro.Reto_005;

import java.util.Scanner;

public class SistemaControlVersiones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Bienvenido al sistema de control de versiones.");
        System.out.print("Ingrese el ID del nodo raíz: ");
        String rootId = scanner.nextLine();
        System.out.print("Ingrese los datos iniciales del nodo raíz (separados por comas): ");
        String[] rootData = scanner.nextLine().split(",");
        ControlVersion vcs = new ControlVersion(rootId, rootData);

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Crear nueva rama");
            System.out.println("2. Cambiar rama de trabajo");
            System.out.println("3. Mostrar árbol");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            if (option == 1) {
                System.out.print("Ingrese los datos de la nueva rama (separados por comas): ");
                String[] branchData = scanner.nextLine().split(",");
                Node newBranch = vcs.createBranch(branchData);
                System.out.println("Nueva rama creada con ID: " + newBranch.id);
            } else if (option == 2) {
                System.out.print("Ingrese el ID de la rama a la que desea cambiar: ");
                String branchId = scanner.nextLine();
                if (vcs.switchBranch(branchId)) {
                    System.out.println("Cambiado a la rama: " + branchId);
                } else {
                    System.out.println("Rama no encontrada.");
                }
            } else if (option == 3) {
                System.out.println("Árbol de control de versiones:");
                vcs.printTree(vcs.root, 0);
            } else if (option == 4) {
                System.out.println("Saliendo del sistema. ¡Adiós!");
                break;
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
