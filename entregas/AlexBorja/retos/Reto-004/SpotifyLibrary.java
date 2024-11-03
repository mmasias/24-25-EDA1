import java.util.Arrays;

class SpotifyLibrary {
   private Song[] favoriteSongs;
   private Playlist[] playlists;
   private Song[] availableSongs;

   public SpotifyLibrary() {
      this.favoriteSongs = new Song[0];
      this.playlists = new Playlist[0];
      setDefaultSongs();
   }

   public void run() {
      while (true) {
         displayMenu();
         int choice = getUserInput("", 9);
         switch (choice) {
            case 1:
               addFavoriteSong();
               break;
            case 2:
               removeFavoriteSong();
               break;
            case 3:
               displayFavoriteSongs();
               break;
            case 4:
               createPlaylist();
               break;
            case 5:
               addSongToPlaylist();
               break;
            case 6:
               removeSongFromPlaylist();
               break;
            case 7:
               displayPlaylists();
               break;
            case 8:
               displayPlaylistSongs();
               break;
            case 9:
               return;
         }
      }
   }

   private void setDefaultSongs() {
      this.availableSongs = new Song[10];
      this.availableSongs[0] = new Song("Demoliendo Hoteles", "Charly García", 258);
      this.availableSongs[1] = new Song("Los Dinosaurios", "Charly García", 234);
      this.availableSongs[2] = new Song("Rasguña Las Piedras", "Sui Generis", 285);
      this.availableSongs[3] = new Song("Canción Para Mi Muerte", "Sui Generis", 342);
      this.availableSongs[4] = new Song("No Soy Un Extraño", "Charly García", 295);
      this.availableSongs[5] = new Song("Seminare", "Serú Girán", 238);
      this.availableSongs[6] = new Song("Promesas Sobre El Bidet", "Charly García", 243);
      this.availableSongs[7] = new Song("Rezo Por Vos", "Charly García & Luis Alberto Spinetta", 266);
      this.availableSongs[8] = new Song("Película sordomuda", "Charly García", 235);
      this.availableSongs[9] = new Song("¿Qué se puede hacer salvo ver películas?", "La máquina de hacer pájaros", 325);
   }

   public void displayMenu() {
      System.out.println("=== MENÚ BIBLIOTECA ===");
      System.out.println("1. Añadir canción a favoritos");
      System.out.println("2. Eliminar canción de favoritos");
      System.out.println("3. Ver canciones favoritas");
      System.out.println("4. Crear nueva playlist");
      System.out.println("5. Añadir canción a playlist");
      System.out.println("6. Eliminar canción de playlist");
      System.out.println("7. Ver playlists");
      System.out.println("8. Ver canciones de una playlist");
      System.out.println("9. Volver al menú principal");
   }

   private void addFavoriteSong() {
      displayAvailableSongs();
      int songIdx = getUserInput("Introduce el número de la canción: ", this.availableSongs.length) - 1;
      Song song = this.availableSongs[songIdx];

      this.favoriteSongs = Arrays.copyOf(this.favoriteSongs, this.favoriteSongs.length + 1);
      this.favoriteSongs[this.favoriteSongs.length - 1] = song;
      System.out.println("\n" + song.getTitle() + " añadida a favoritos con éxito\n");
   }

   private void removeFavoriteSong() {
      if (this.favoriteSongs.length > 0) {
         displayFavoriteSongs();
         int songIdx = getUserInput("Introduce el número de la canción a eliminar: ", this.favoriteSongs.length) - 1;
         Song song = this.favoriteSongs[songIdx];
         this.favoriteSongs = Arrays.copyOf(this.favoriteSongs, this.favoriteSongs.length - 1);
         System.out.println("\n" + song.getTitle() + " eliminada de favoritos con éxito\n");
      }

   }

   private void displayFavoriteSongs() {
      if (this.favoriteSongs.length > 0) {
         System.out.println();
         for (int i = 0; i < this.favoriteSongs.length; i++) {
            Song song = this.favoriteSongs[i];
            System.out.println("" + (i + 1) + ". " + song.toString());
         }
         System.out.println();
      } else {
         System.out.println("\nNo hay canciones favoritas\n");
      }
   }

   private void createPlaylist() {
      System.out.println("\n=== Introduce el nombre de la playlist ===\n");
      String name = System.console().readLine();
      Playlist newPlaylist = new Playlist(name);

      this.playlists = Arrays.copyOf(this.playlists, this.playlists.length + 1);
      this.playlists[this.playlists.length - 1] = newPlaylist;
      System.out.println("\n=== Playlist creada con éxito ===\n");
   }

   private void addSongToPlaylist() {
      if (playlists.length == 0) {
         System.out.println("\nNo hay playlists disponibles\n");
         return;
      }

      System.out.println("\nPlaylists disponibles:");
      displayPlaylists();
      int playlistIdx = getUserInput("Seleccione playlist: ", this.playlists.length) - 1;
      Playlist playlist = this.playlists[playlistIdx];

      displayAvailableSongs();
      int songIdx = getUserInput("Introduce el número de la canción: ", this.availableSongs.length) - 1;
      Song song = this.availableSongs[songIdx];
      playlist.addSong(song);
      System.out.println("\n" + song.getTitle() + " añadida a " + playlist.getName() + " con éxito\n");
   }

   private void displayAvailableSongs() {
      System.out.println("\nCanciones disponibles:\n");
      for (int i = 0; i < this.availableSongs.length; i++) {
         Song song = this.availableSongs[i];
         System.out.println("" + (i + 1) + ". " + song.toString());
      }
   }

   private void removeSongFromPlaylist() {
      if (playlists.length == 0) {
         System.out.println("\nNo hay playlists disponibles\n");
         return;
      }

      System.out.println("\nPlaylists disponibles:");
      displayPlaylists();
      int playlistIdx = getUserInput("Seleccione playlist: ", this.playlists.length) - 1;
      Playlist playlist = this.playlists[playlistIdx];

      System.out.println();
      playlist.displaySongs();
      int songIdx = getUserInput("Introduce el número de la canción a eliminar: ", playlist.getSize()) - 1;
      Song song = playlist.getSong(songIdx);
      playlist.removeSong(song);
      System.out.println("\n" + song.getTitle() + " eliminada de " + playlist.getName() + " con éxito\n");
   }

   private void displayPlaylists() {
      if (this.playlists.length == 0) {
         System.out.println("\nNo hay playlists disponibles\n");
         return;
      }

      System.out.println("\n=== Playlists ===\n");
      for (int i = 0; i < this.playlists.length; i++) {
         Playlist playlist = this.playlists[i];
         System.out.println("" + (i + 1) + ". " + playlist.getName());
      }
      System.out.println("\n=================\n");
   }

   private void displayPlaylistSongs() {
      if(this.playlists.length == 0) {
         System.out.println("\nNo hay playlists disponibles\n");
         return;
      }

      displayPlaylists();
      int playlistIdx = getUserInput("Introduce el número de la playlist: ", this.playlists.length) - 1;
      Playlist playlist = this.playlists[playlistIdx];

      System.out.println();
      playlist.displaySongs();
      System.out.println();
   }

   private int getUserInput(String prompt, int maxOpt) {
      while (true) {
         System.out.print(prompt);
         int opt = Integer.parseInt(System.console().readLine());
         if (opt > 0 && opt <= maxOpt) {
            return opt;
         } else {
            System.out.println("Introduce una opción válida");
         }
      }
   }
}
