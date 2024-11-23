import java.util.Scanner;

public class Interfaz {
    
    private Tree tree;

    public Interfaz(Tree tree){
        this.tree = tree;
    }

    public void mostrar() {
        
        Scanner sc = new Scanner(System.in);
        boolean ejecutando = true;
        System.out.println("--SISTEMA DE CONTROL DE VERSIONES-- \n");
        while(ejecutando){
            System.out.println("Versión actual: " + tree.mostrarVersionActual());
            System.out.println("1. Añadir nueva versión estableciendo un número de archivos");
            System.out.println("2. Moverse a la versión anterior");
            System.out.println("3. Cambiarse a la rama anterior");
            System.out.println("4. Cambiarse a la siguiente rama");
            System.out.println("5. Ver versiones");
            System.out.println("6. Salir");
            int eleccionMenu = sc.nextInt();
            switch (eleccionMenu) {
                case 1:
                    System.out.println("Establece un número de archivos para tu versión");
                    int numeroArchivos = sc.nextInt();
                    tree.insert(numeroArchivos);
                    cleanScreen();
                    break;

                case 2:
                    tree.moverseVersionAnterior();
                    break;

                case 3:
                    tree.moverseRamaIzquierda();
                    break;

                case 4: 
                    tree.moverseRamaDerecha();
                    break;

                case 5:
                    tree.print();
                    break;

                case 6:
                    ejecutando = false;
                    break;
            
                default:
                    System.out.println("Eleccion inválida, intente de nuevo");
            }
        }
    }

    private void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
