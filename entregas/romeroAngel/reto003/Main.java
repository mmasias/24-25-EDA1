package romeroAngel.reto003;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Compresor compresor = new Compresor();

        System.out.println("Ingrese la cadena a comprimir:");
        String cadena = scanner.nextLine();

        String[][] resultado = compresor.comprime(cadena);

        System.out.println("El resultado comprimido es:");
        System.out.println(resultado[0][0]); 

        System.out.println("El diccionario es:");
        for (String entry : resultado[1]) {
            System.out.println(entry); 
        }

        scanner.close();
    }
}