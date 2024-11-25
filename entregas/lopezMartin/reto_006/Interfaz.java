package entregas.lopezMartin.reto_006;
import java.util.Scanner;

public class Interfaz {

    private Pila lineas;
    private Pila versionesAnteriores;
    private Pila versionesPosteriores;

    public Interfaz(Pila lineas, Pila versionesAnteriores, Pila versionesPosteriores){

        this.lineas = lineas;
        this.versionesAnteriores = versionesAnteriores;
        this.versionesPosteriores = versionesPosteriores;

    }

    public void mostrar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenidos el editor EDLIN \n Utilice el menu inferior para editar el texto \n ------ \n [L] permite definir la linea activa \n [E]permite editar la linea activa \n [I] permite intercambiar dos lineas \n [B] borra el contenido de la linea activa \n [S] sale del programa \n");
        String input = sc.nextLine();
        switch (input.toUpperCase()) {
            case "L":
                
                break;

            case "E":

                break;

            case "I": 

                break;

            case "B":

                break;

            case "D":

                break;

            case "R":

                break;

            case "S":

                break;
        
            default:
                System.out.println("Saliendo del programa");
        }

            

    }
    
}
