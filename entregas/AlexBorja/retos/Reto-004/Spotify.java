class Spotify {
   private boolean appRunning;
   private SpotifyLibrary library;
   private SpotifyPlayer player;

   public Spotify() {
      this.appRunning = true;
      this.library = new SpotifyLibrary();
      this.player = new SpotifyPlayer();
   }

   public void init() {
      while (this.appRunning) {
         int mainMenuChoice = getMainMenuChoice();
         switch (mainMenuChoice) {
            case 1:
               library.run();
               break;
            case 2:
               player.run();
               break;
            case 3:
               this.appRunning = false;
               break;
         }
      }
   }

   public static int getMainMenuChoice() {
      System.out.println("=== SPOTIFY  === ");
      System.out.println("=== MENÚ PRINCIPAL ===\n");

      System.out.println("1. Biblioteca");
      System.out.println("2. Reproducir");
      System.out.println("3. Salir");

      while (true) {
         try {
            int choice = Integer.parseInt(System.console().readLine());
            if (choice < 1 || choice > 3) {
               throw new NumberFormatException();
            }
            return choice;
         } catch (NumberFormatException e) {
            System.out.println("Por favor, introduce un número válido");
         }
      }
   }
}
