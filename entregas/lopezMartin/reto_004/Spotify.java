package entregas.lopezMartin.reto_004;

import java.util.Scanner;

public class Spotify {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cancion[] cancionesDisponibles = {
            new Cancion(1, "Bitcoin", "LEÏTI", 187),
            new Cancion(2, "La vida padre", "ToteKing", 147),
            new Cancion(3, "R.I.P", "Playboi Carti", 192),
            new Cancion(4, "redrum", "21 Savage", 271),
            new Cancion(5, "LENNY", "ABHIR", 129),
            new Cancion(6, "Mandaloriano", "JohnPo", 179),
            new Cancion(7, "Marlboro Nights", "Lonely God", 69),
            new Cancion(8, "20 Min", "Lil Uzi Vert", 221),
            new Cancion(9, "If we beeing rëal", "Yeat", 173),
            new Cancion(10, "Capo", "NLE Choppa", 192)
        };
        ListaPlaylists playlists = new ListaPlaylists();
        
        while(true){
            System.out.println("\n=== SPOTIFY === \n");
            System.out.println("BIBLIOTECA INICIAL \n");
            System.out.println("Canciones disponibles: \n");
            for(int i= 0; i<cancionesDisponibles.length;i++){
                System.out.println(i+1 + ". " +cancionesDisponibles[i].toString());
            }
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir \n");
            System.out.println("Seleccione una opción:");
            int eleccionMenuPrincipal = sc.nextInt();
            switch(eleccionMenuPrincipal) {
                case 1:
                    boolean enReproduccion = true;
                    while(enReproduccion){
                        System.out.println("\n=== MENÚ REPRODUCCIÓN ===");
                        System.out.println("1. Ver canción actual");
                        System.out.println("2. Reproducir siguiente");
                        System.out.println("3. Reproducir anterior");
                        System.out.println("4. Ver cola de reproducción");
                        System.out.println("5. Ver historial");
                        System.out.println("6. Activar/desactivar aleatorio");
                        System.out.println("7. Activar/desactivar repetición");
                        System.out.println("8. Volver al menú principal");
                        System.out.println("\nSeleccione una opción:");
                        int eleccionMenuReproduccion = sc.nextInt();
                        switch (eleccionMenuReproduccion){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                enReproduccion = false;
                                break;
                            default:
                            System.out.println("Elección inválida, intente de nuevo");
                        }
                    }
                    
                    break;

                case 2:
                    boolean enBiblioteca = true;
                    while(enBiblioteca){
                        System.out.println("\n=== MENÚ BIBLIOTECA ===");
                        System.out.println("1. Añadir canción a favoritos");
                        System.out.println("2. Eliminar canción de favoritos");
                        System.out.println("3. Ver canciones favoritas");
                        System.out.println("4. Crear nueva playlist");
                        System.out.println("5. Añadir canción a playlist");
                        System.out.println("6. Eliminar canción de playlist");
                        System.out.println("7. Ver playlists");
                        System.out.println("8. Ver canciones de una playlist");
                        System.out.println("9. Volver al menú principal");
                        System.out.println("\nSeleccione una opción:");
                        int eleccionMenuBiblioteca = sc.nextInt();
                        switch (eleccionMenuBiblioteca) {
                            case 1:
                                System.out.println("\nSeleccione la cancion que desea añadir a favoritos (1-10):");
                                int idCancionAñadir = sc.nextInt();
                                assert idCancionAñadir >=1 && idCancionAñadir <=10;
                                if(cancionesDisponibles[idCancionAñadir-1].esFavorita()){
                                    System.out.println("Ya tienes esta cancion en favoritos.");
                                }else{
                                    cancionesDisponibles[idCancionAñadir-1].setFavorita();
                                }
                                break;
                                
                            case 2:
                                System.out.println("\nSeleccione la cancion que desea eliminar de favoritos (1-10):");
                                int idCancionEliminar = sc.nextInt();
                                assert idCancionEliminar >=1 && idCancionEliminar <=10;
                                if(!cancionesDisponibles[idCancionEliminar-1].esFavorita()){
                                    System.out.println("Esta cancion no la tienes en favoritos.");
                                }else{
                                    cancionesDisponibles[idCancionEliminar-1].unsetFavorita();
                                }
                                break;

                            case 3:
                                for(int i = 0;i<cancionesDisponibles.length;i++){
                                    if (cancionesDisponibles[i].esFavorita()) {
                                        System.out.println(cancionesDisponibles[i].toString());
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Nombre de la nueva playlist: ");
                                sc.nextLine();
                                String nombreNuevaPlaylist = sc.nextLine();
                                playlists.insertUltimo(nombreNuevaPlaylist);
                                System.out.println("Playlist creada con exito.");
                                break;
                            case 5:
                                playlists.mostrar();
                                if (!playlists.isEmpty()) {
                                    System.out.println("\nSeleccione una playlist");
                                    int playlistID = sc.nextInt();
                                    System.out.println("Canciones disponibles: \n");
                                    for(int i= 0; i<cancionesDisponibles.length;i++){
                                        System.out.println(i+1 + ". " + cancionesDisponibles[i].toString());
                                    }
                                    System.out.println("\nSeleccione canción a añadir: ");
                                    int idCancion = sc.nextInt();
                                    playlists.encontrar(playlistID).añadirCancion(cancionesDisponibles[idCancion-1]);
                                }
                                break;
                            case 6:
                                playlists.mostrar();
                                if (!playlists.isEmpty()) {
                                    System.out.println("\nSeleccione una playlist");
                                    int playlistID = sc.nextInt();
                                    NodoPlaylist playlist = playlists.encontrar(playlistID);
                                    System.out.println("Canciones disponibles: \n");
                                    System.out.println(playlist.mostrar());
                                    System.out.println("\nSeleccione canción para eliminar: ");
                                    int idCancion = sc.nextInt();
                                    playlist.eliminarCancion(cancionesDisponibles[idCancion-1]);
                                }
                                break;
                            case 7:
                                playlists.mostrar();
                                break;
                            case 8:
                                playlists.mostrar();
                                if (!playlists.isEmpty()) {
                                    System.out.println("\nSeleccione una playlist");
                                    int playlistID = sc.nextInt();
                                    NodoPlaylist playlist = playlists.encontrar(playlistID);
                                    if (playlist != null) {
                                        System.out.println("Canciones en la playlist " + playlist.getNombre() + ":");
                                        System.out.println(playlist.mostrar());
                                    } else {
                                        System.out.println("No se encontró la playlist con ID: " + playlistID);
                                    }
                                }else{
                                    System.out.println("No hay playlists existentes");
                                }
                                break;
                            
                            case 9:
                                enBiblioteca = false;
                                break;
                            default:
                                System.out.println("Elección inválida, intente de nuevo");
                        }
                    }
                    break;
                    
                case 3:
                    return;
                default:
                    System.out.println("Elección inválida, intente de nuevo");
            }
        }
        
        
    }
    
}
