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
            System.out.println("1. Añadir nueva versión");
            System.out.println("2. Volver a la versión anterior");
            System.out.println("3. Moverse a la primera rama de esta versión");
            System.out.println("4. Cambiarse a la siguiente rama hermana");
            System.out.println("5. Cambiarse a la anterior rama hermana");
            System.out.println("6. Ver diagrama de versiones");
            System.out.println("7. Salir");
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
                    cleanScreen();
                    break;

                case 3:
                    tree.moversePrimeraRama();
                    cleanScreen();
                    break;

                case 4:
                    tree.moverseRamaDerecha();
                    cleanScreen();
                    break;
                    
                case 5: 
                    tree.moverseRamaIzquierda();
                    cleanScreen();
                    break;

                case 6:
                    tree.print();
                    break;

                case 7:
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
