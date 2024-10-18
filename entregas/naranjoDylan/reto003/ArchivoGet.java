package entregas.naranjoDylan.reto003;

import java.util.Scanner;

public class ArchivoGet {
    private String cadena;
    
    public void agregarCadena() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una cadena de texto:");
        cadena = scanner.nextLine();
    }
    
    public String getCadena() {
        return cadena;
    }
}

