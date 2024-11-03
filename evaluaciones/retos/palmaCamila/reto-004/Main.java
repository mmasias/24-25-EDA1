import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Player player = new Player();

    public static void main(String[] args) {
        initializeLibrary();
        displayMainMenu();
    }

    private static void initializeLibrary() {
        library.addSong(new Song("Demoliendo Hoteles", "Charly García", 258));
        library.addSong(new Song("Los Dinosaurios", "Charly García", 234));
        library.addSong(new Song("Rasguña Las Piedras", "Sui Generis", 285));
        library.addSong(new Song("Canción Para Mi Muerte", "Sui Generis", 342));
        library.addSong(new Song("No Soy Un Extraño", "Charly García", 295));
        library.addSong(new Song("Seminare", "Serú Girán", 238));
        library.addSong(new Song("Promesas Sobre El Bidet", "Charly García", 243));
        library.addSong(new Song("Rezo Por Vos", "Charly García & Luis Alberto Spinetta", 266));
        library.addSong(new Song("Película sordomuda", "Charly García", 235));
        library.addSong(new Song("¿Qué se puede hacer salvo ver películas?", "La máquina de hacer pájaros", 325));

        System.out.println("=== SPOTIFY  ===");
        System.out.println("Biblioteca inicializada con las siguientes canciones:");
        System.out.println(library.toString());
    }

    private static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    displayPlaybackMenu(scanner);
                    break;
                case 2:
                    displayLibraryMenu(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void displayPlaybackMenu(Scanner scanner) {
        while (true) {
            System.out.println("=== MENÚ REPRODUCCIÓN ===");
            System.out.println("1. Ver canción actual");
            System.out.println("2. Reproducir siguiente");
            System.out.println("3. Reproducir anterior");
            System.out.println("4. Ver cola de reproducción");
            System.out.println("5. Ver historial");
            System.out.println("6. Activar/desactivar aleatorio");
            System.out.println("7. Activar/desactivar repetición");
            System.out.println("8. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println(player.toString());
                    break;
                case 2:
                    player.next();
                    break;
                case 3:
                    player.previous();
                    break;
                case 4:
                    System.out.println(player.toString());
                    break;
                case 5:
                    System.out.println(player.toString());
                    break;
                case 6:
                    player.toggleShuffle();
                    break;
                case 7:
                    player.toggleRepeat();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void displayLibraryMenu(Scanner scanner) {
        while (true) {
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
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addFavorite(scanner);
                    break;
                case 2:
                    removeFavorite(scanner);
                    break;
                case 3:
                    System.out.println(library.listFavourites());
                    break;
                case 4:
                    createPlaylist(scanner);
                    break;
                case 5:
                    addToPlaylist(scanner);
                    break;
                case 6:
                    removeFromPlaylist(scanner);
                    break;
                case 7:
                    System.out.println(library.listUserPlayLists());
                    break;
                case 8:
                    viewPlaylist(scanner);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void addFavorite(Scanner scanner) {
        System.out.println("Canciones disponibles:");
        System.out.println(library.toString());
        System.out.print("Seleccione canción a añadir a favoritos: ");
        int songIndex = scanner.nextInt();
        scanner.nextLine();
        Song song = library.getSong(songIndex);
        library.getFavourites().addSong(song);
        System.out.println("\"" + song.toString() + "\" añadida a favoritos.");
    }

    private static void removeFavorite(Scanner scanner) {
        System.out.println("Canciones favoritas:");
        System.out.println(library.listFavourites());
        System.out.print("Seleccione canción a eliminar de favoritos: ");
        int songIndex = scanner.nextInt();
        scanner.nextLine();
        PlayList favourites = library.getFavourites();
        Song song = favourites.getSong(songIndex);
        favourites.removeSong(songIndex);
        System.out.println("\"" + song.toString() + "\" eliminada de favoritos.");
    }

    private static void createPlaylist(Scanner scanner) {
        System.out.print("Nombre de la nueva playlist: ");
        String playlistName = scanner.nextLine();
        library.addPlayList(playlistName);
        System.out.println("Playlist \"" + playlistName + "\" creada con éxito.");
    }

    private static void addToPlaylist(Scanner scanner) {
        if (!library.hasUserPlayLists()) {
            System.out.println("No hay playlists disponibles. Cree una nueva playlist.");
            return;
        }
        System.out.println("Playlists disponibles:");
        System.out.println(library.listUserPlayLists());
        System.out.print("Seleccione playlist: ");
        int playListIndex = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Canciones disponibles:");
        System.out.println(library.listAvailableSongs());
        System.out.print("Seleccione canción a añadir: ");
        int songIndex = scanner.nextInt();
        scanner.nextLine();
        Song song = library.getSong(songIndex);
        PlayList selectedPlayList = library.getPlayList(playListIndex);
        selectedPlayList.addSong(song);
        System.out.println("\"" + song.toString() + "\" añadida a " + selectedPlayList.getName());
    }

    private static void removeFromPlaylist(Scanner scanner) {
        System.out.println("Playlists disponibles:");
        System.out.println(library.listUserPlayLists());
        System.out.print("Seleccione playlist: ");
        int playListIndex = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Canciones en la playlist:");
        PlayList selectedPlayList = library.getPlayList(playListIndex);
        System.out.println(selectedPlayList.toString());
        System.out.print("Seleccione canción a eliminar: ");
        int songIndex = scanner.nextInt();
        scanner.nextLine();
        Song song = selectedPlayList.getSong(songIndex);
        selectedPlayList.removeSong(songIndex);
        System.out.println("\"" + song.toString() + "\" eliminada de " + selectedPlayList.getName());
    }

    private static void viewPlaylist(Scanner scanner) {
        System.out.println("Playlists disponibles:");
        System.out.println(library.listUserPlayLists());
        System.out.print("Seleccione playlist: ");
        int playListIndex = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Canciones en la playlist:");
        System.out.println(library.getPlayList(playListIndex).toString());
    }
}