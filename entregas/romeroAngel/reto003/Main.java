package romeroAngel.reto003;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Compresor compresor = new Compresor();

        // Solicitar la cadena al usuario
        System.out.println("Ingrese la cadena a comprimir:");
        String cadena = scanner.nextLine();

        // Comprimir la cadena
        String[][] resultado = compresor.comprime(cadena);

        // Mostrar el resultado comprimido
        System.out.println("El resultado comprimido es:");
        System.out.println(resultado[0][0]); // Resultado comprimido

        // Mostrar el diccionario
        System.out.println("El diccionario es:");
        for (String entry : resultado[1]) {
            System.out.println(entry); // Listar entradas del diccionario
        }

        scanner.close(); // Cerrar el scanner
    }
}