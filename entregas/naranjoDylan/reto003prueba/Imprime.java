package entregas.naranjoDylan.reto003prueba;

import java.util.Scanner;

public class Imprime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una cadena de texto:");
        String cadena = scanner.nextLine();

        Compresor compresor = new Compresor();
        String resultadoComprimido = compresor.comprime(cadena);

        System.out.println("Cadena original: " + cadena);
        System.out.println("Cadena comprimida: " + resultadoComprimido);
        System.out.println("Diccionario:");
        for (String key : compresor.getDiccionario().keySet()) {
            if (compresor.getDiccionario().get(key) >= 256) {
                System.out.println(compresor.getDiccionario().get(key) + ": " + key);
            }
        }

    }
}
