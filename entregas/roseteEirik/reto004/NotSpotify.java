package entregas.roseteEirik.reto004;
import java.util.Scanner;

public class NotSpotify {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option;

        do {

            MainMenu.display();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    MusicPlayerMenu.display();
                    break;
                case 2:
                    LibraryMenu.display();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option");
            }

        } while (true);
    }
}
