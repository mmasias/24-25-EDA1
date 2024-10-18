import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa la cadena a comprimir: ");
        String cadena = scanner.nextLine();

        CompresorLZ compresor = new CompresorLZ();

        String compresion = compresor.comprime(cadena);
        System.out.println("\n El resultado comprimido es: ");
        System.out.println(compresion);

        System.out.println("\nEl diccionario es: ");
        System.out.println(compresor.mostrarDiccionario());

        scanner.close();
    }
}

