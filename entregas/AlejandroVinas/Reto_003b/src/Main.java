import java.util.*;


public class Main {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese la cadena a comprimir: ");
    String cadena = scanner.nextLine();

    CompresorLZW compresor = new CompresorLZW();
    ResultadoCompresion resultado = compresor.comprime(cadena);

    System.out.println(resultado);

    scanner.close();
}
}

