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
            System.out.println("1. Añadir rama");
            System.out.println("2. Mostrar árbol");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (option == 1) {
                System.out.print("Ingrese el ID del nodo padre: ");
                String parentId = scanner.nextLine();
                Node parentNode = vcs.findNode(vcs.root, parentId);

                if (parentNode != null) {
                    System.out.print("Ingrese el ID de la nueva rama: ");
                    String branchId = scanner.nextLine();
                    System.out.print("Ingrese los datos de la nueva rama (separados por comas): ");
                    String[] branchData = scanner.nextLine().split(",");
                    vcs.createBranch(parentNode, branchId, branchData);
                    System.out.println("Rama creada exitosamente.");
                } else {
                    System.out.println("Nodo padre no encontrado.");
                }
            } else if (option == 2) {
                System.out.println("Árbol de control de versiones:");
                vcs.printTree(vcs.root, 0);
            } else if (option == 3) {
                System.out.println("Saliendo del sistema. ¡Adiós!");
                break;
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
}
}
