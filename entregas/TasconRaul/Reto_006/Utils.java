package entregas.tasconRaul.Reto_006;

import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);

    public static char askChar() {
        return scanner.next().charAt(0);
    }

    public static int askInt() {
        return scanner.nextInt();
    }

    public static int askInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    public static String askString() {
        scanner.nextLine(); 
        return scanner.nextLine();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

