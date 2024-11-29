import java.util.Scanner;

public class InterfazUsuario {
    private ArbolVersiones arbolVersiones;

    public InterfazUsuario(ArbolVersiones arbolVersiones) {
        this.arbolVersiones = arbolVersiones;
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        boolean ejecutando = true;
        System.out.println("-- SISTEMA DE CONTROL DE VERSIONES --");
        while (ejecutando) {
            System.out.println("\nVersión actual: " + arbolVersiones.obtenerVersionActual());
            System.out.println("1. Agregar nueva versión");
            System.out.println("2. Mover a versión padre");
            System.out.println("3. Mover al primer hijo");
            System.out.println("4. Mover al siguiente hermano");
            System.out.println("5. Mover al hermano anterior");
            System.out.println("6. Mostrar árbol de versiones");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce la cantidad de archivos para la nueva versión: ");
                    int cantidadArchivos = sc.nextInt();
                    arbolVersiones.agregarVersion(cantidadArchivos);
                    break;
                case 2:
                    arbolVersiones.moverAPadre();
                    break;
                case 3:
                    arbolVersiones.moverAPrimerHijo();
                    break;
                case 4:
                    arbolVersiones.moverASiguienteHermano();
                    break;
                case 5:
                    arbolVersiones.moverAAnteriorHermano();
                    break;
                case 6:
                    arbolVersiones.mostrarArbol();
                    break;
                case 7:
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }
}
