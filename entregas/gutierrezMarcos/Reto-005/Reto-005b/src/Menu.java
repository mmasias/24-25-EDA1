import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Main main;

    public Menu(Main main) {
        this.main = main;
        int opcion;
        do {
            System.out.println("1. Mostrar Ramas");
            System.out.println("2. Crear Rama");
            System.out.println("3. Eliminar Rama");
            System.out.println("4. Moverse de Rama");
            System.out.println("5. Guardar Versión");
            System.out.println("6. Mostrar Versión");
            System.out.println("7. Ir a Versión Anterior");
            System.out.println("8. Ir a Versión Siguiente");
            System.out.println("9. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarRamas();
                    break;
                case 2:
                    crearRama();
                    break;
                case 3:
                    eliminarRama();
                    break;
                case 4:
                    moverseRama();
                    break;
                case 5:
                    guardarVersion();
                    break;
                case 6:
                    mostrarVersion();
                    break;
                case 7:
                    irAVersionAnterior();
                    break;
                case 8:
                    irAVersionSiguiente();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            
        } while (opcion != 9);
    }

    private void mostrarRamas() {
        System.out.println("Ramas actuales:");
    
        TreeNode root = main.getArbol().getRoot();
        if (root == null) {
            System.out.println("No hay ramas disponibles.");
            return;
        }

        System.out.println(root.getNombre());
    
        Node hijo = root.getHijos().getFirst();
        while (hijo != null) {
            TreeNode hijoNodo = hijo.getValue();
            System.out.println(hijoNodo.getNombre());
            hijo = hijo.getNext();
        }
    }

    private void crearRama() {
        System.out.print("Ingrese el nombre de la nueva rama: ");
        String nombre = scanner.next();
        main.getRamaActual().agregarHijo(new TreeNode(nombre));
        System.out.println("Rama creada: " + nombre);
    }

    private void eliminarRama() {

    }

    private void moverseRama() {

    }

    private void guardarVersion() {
        System.out.print("Cuantos Documentos tiene la nueva version: ");
        String contenido = scanner.next();
        main.getRamaActual().getVersiones().insertEnd(contenido);
        System.out.println("Versión guardada.");
    }

    private void mostrarVersion() {
        System.out.println("Versión actual: " + main.getVersionActual().getValue());
    }

    private void irAVersionAnterior() {

    }

    private void irAVersionSiguiente() {

    }
}
