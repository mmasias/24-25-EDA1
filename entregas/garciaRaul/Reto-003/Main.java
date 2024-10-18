import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar la cadena al usuario
        System.out.println("Ingrese la cadena a comprimir:");
        String cadena = scanner.nextLine();

        // Crear una instancia de Compresor
        Compresor compresor = new Compresor();

        // Obtener el resultado comprimido
        String[] resultado = compresor.comprime(cadena);

        // Mostrar el resultado comprimido
        System.out.println("El resultado comprimido es: " + resultado[0]);

        // Mostrar el diccionario
        System.out.println("El diccionario es:");
        System.out.println(resultado[1]);
    }
}

