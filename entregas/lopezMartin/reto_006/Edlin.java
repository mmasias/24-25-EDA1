package entregas.lopezMartin.reto_006;

import java.util.Scanner;

public class Edlin{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas lineas quieres?");
        int nLineas = sc.nextInt();
        Documento documento = new Documento(nLineas);
        documento.ejecutar();
        
    }
}