package Reto006;

import java.util.Scanner;

public class UserInput {
    private static Scanner input = new Scanner(System.in);
    private static String clipboard = ""; 
    public static char askChar() {
        System.out.print("Ingrese un comando: ");
        return input.next().charAt(0);
    }

    public static int askInt() {
        System.out.print("Ingrese un número: ");
        return input.nextInt();
    }

    public static String askString() {
        input.nextLine(); 
        return input.nextLine();
    }

    public static void copyToClipboard(String text) {
        clipboard = text;
        System.out.println("Texto copiado.");
    }

    public static String pasteFromClipboard() {
        return clipboard;
    }
}