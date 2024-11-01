class SpotifyPlayer {
   private PlayerList playerList;
   private Stack history;
   private Song currentSong;
   private boolean shuffle;
   private boolean repeat;

   public SpotifyPlayer() {
      setPlayerList();
      this.history = new Stack(10);
      this.currentSong = null;
      this.shuffle = false;
      this.repeat = false;
   }

   public void run() {
      while (true) {
         displayMenu();
         int choice = getChoice();
         switch (choice) {
            case 1:
               displayCurrentSong();
               break;
            case 2:
               playNextSong();
               break;
            case 3:
               playPreviousSong();
               break;
            case 4:
               displayPlayerList();
               break;
            case 5:
               displayHistory();
               break;
            case 6:
               toggleShuffle();
               break;
            case 7:
               toggleRepeat();
               break;
            case 8:
               return;
         }
      }
   }

   private void displayMenu() {
      System.out.println("=== MENÚ REPRODUCCIÓN===");
      System.out.println("1. Ver canción actual");
      System.out.println("2. Reproducir siguiente");
      System.out.println("3. Reproducir anterior");
      System.out.println("4. Ver cola de reproducción");
      System.out.println("5. Ver historial");
      System.out.println("6. Activar/desactivar aleatorio");
      System.out.println("7. Activar/desactivar repetición");
      System.out.println("8. Volver al menú principal");

   }

   private void setPlayerList() {
      Song[] availableSongs = new Song[10];
      availableSongs[0] = new Song("Demoliendo Hoteles", "Charly García", 258);
      availableSongs[1] = new Song("Los Dinosaurios", "Charly García", 234);
      availableSongs[2] = new Song("Rasguña Las Piedras", "Sui Generis", 285);
      availableSongs[3] = new Song("Canción Para Mi Muerte", "Sui Generis", 342);
      availableSongs[4] = new Song("No Soy Un Extraño", "Charly García", 295);
      availableSongs[5] = new Song("Seminare", "Serú Girán", 238);
      availableSongs[6] = new Song("Promesas Sobre El Bidet", "Charly García", 243);
      availableSongs[7] = new Song("Rezo Por Vos", "Charly García & Luis Alberto Spinetta", 266);
      availableSongs[8] = new Song("Película sordomuda", "Charly García", 235);
      availableSongs[9] = new Song("¿Qué se puede hacer salvo ver películas?", "La máquina de hacer pájaros", 325);
      this.playerList = new PlayerList();
      for (int i = 0; i < availableSongs.length; i++) {
         this.playerList.addSong(availableSongs[i]);
      }
   }

   private int getChoice() {
      int choice;
      while (true) {
         try {
            choice = Integer.parseInt(System.console().readLine());
            if (choice < 1 || choice > 8) {
               throw new NumberFormatException();
            }
            return choice;
         } catch (NumberFormatException e) {
            System.out.println("Por favor, introduce un número válido");
         }
      }
   }

   private void displayCurrentSong() {
      if (this.currentSong == null) {
         System.out.println("\nNo hay canción actual\n");
         return;
      }
      System.out.println("\nReproduciendo: " + this.currentSong.toString());
      System.out.println();
   }

   private void playNextSong() {
      if (this.playerList.isEmpty()) {
         System.out.println("\nNo hay canciones en la cola de reproducción\n");
         return;
      }
      if (this.currentSong != null) {
         this.history.push(this.currentSong);
      }
      this.currentSong = this.shuffle ? this.playerList.shuffle() : this.playerList.getNextSong();
      System.out.println("\nReproduciendo siguiente canción: " + this.currentSong.toString());
      System.out.println();
   }

   private void playPreviousSong() {
      if (this.playerList.isEmpty()) {
         System.out.println("\nNo hay canciones en la cola de reproducción\n");
         return;
      }
      if (this.currentSong != null) {
         this.history.push(this.currentSong);
      }
      this.currentSong = this.playerList.getPreviousSong();
      System.out.println("\nReproduciendo canción anterior: " + this.currentSong.toString());
      System.out.println();
   }

   private void displayPlayerList() {
      if (this.playerList.isEmpty()) {
         System.out.println("No hay canciones en la cola de reproducción");
         return;
      }
      System.out.println("\n=== Cola de reproducción ===\n");
      this.playerList.display();
      System.out.println();
   }

   private void displayHistory() {
      if (this.history.isEmpty()) {
         System.out.println("No hay canciones en el historial");
         return;
      }
      System.out.println("\n=== Historial ===");
      this.history.display();
      System.out.println();
   }

   private void toggleShuffle() {
      this.shuffle = !this.shuffle;
      String status = (this.shuffle ? "activado" : "desactivado");
      System.out.println("\nAleatorio " + status + "\n");
   }

   private void toggleRepeat() {
      this.repeat = !this.repeat;
      String status = (this.repeat ? "activada" : "desactivada");
      System.out.println("Repetición " + status + "\n");
   }
}
