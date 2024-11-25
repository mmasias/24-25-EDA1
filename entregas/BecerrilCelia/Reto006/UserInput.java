package Reto006;
import java.util.Scanner;

public class UserInput {
    private static Scanner input = new Scanner(System.in);

    public static char askChar() {
        System.out.print("Ingrese un comando: ");
        return input.next().charAt(0);
    }

    public static int askInt() {
        System.out.print("Ingrese un número: ");
        return input.nextInt();
    }

    public static String askString() {
        input.nextLine(); // Consumir la nueva línea pendiente
        return input.nextLine();
    }
}