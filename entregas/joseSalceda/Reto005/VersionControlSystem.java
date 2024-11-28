import java.util.Scanner;

public class VersionControlSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Version Control System");
        System.out.print("Enter main version ID: ");
        String mainId = input.nextLine();
        System.out.print("Enter initial version data (comma separated): ");
        String[] initialData = input.nextLine().split(",");
        
        RepositoryManager repo = new RepositoryManager(mainId, initialData);
        
        while (true) {
            System.out.println("\nAvailable Actions:");
            System.out.println("1. Create new version");
            System.out.println("2. Switch version");
            System.out.println("3. Show version tree");
            System.out.println("4. Exit");
            System.out.print("Choose action: ");
            
            int choice = input.nextInt();
            input.nextLine();
            
            if (choice == 1) {
                System.out.print("Enter new version data (comma separated): ");
                String[] versionData = input.nextLine().split(",");
                TreeElement newVersion = repo.newVersion(versionData);
                System.out.println("New version created with ID: " + newVersion.id);
                
            } else if (choice == 2) {
                System.out.print("Enter version ID to switch to: ");
                String versionId = input.nextLine();
                if (repo.moveToVersion(versionId)) {
                    System.out.println("Switched to version: " + versionId);
                } else {
                    System.out.println("Version not found.");
                }
                
            } else if (choice == 3) {
                System.out.println("Version Control Tree:");
                repo.displayVersions(repo.mainNode, 0);
                
            } else if (choice == 4) {
                System.out.println("Exiting system. Goodbye!");
                break;
                
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        input.close();
    }
}