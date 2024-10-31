package entregas.lopezMartin.reto_004;

import java.util.Scanner;

public class Spotify {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cancion cancion1 = new Cancion("Bitcoin", "LEÏTI", 187);
        Cancion cancion2 = new Cancion("La vida padre", "ToteKing", 147);
        Cancion cancion3 = new Cancion("R.I.P", "Playboi Carti", 192);
        Cancion cancion4 = new Cancion("redrum", "21 Savage", 271);
        Cancion cancion5 = new Cancion("LENNY", "ABHIR", 129);
        Cancion cancion6 = new Cancion("Mandaloriano", "JohnPo", 179);
        Cancion cancion7 = new Cancion("Marlboro Nights", "Lonely God", 69);
        Cancion cancion8 = new Cancion("20 Min", "Lil Uzi Vert", 221);
        Cancion cancion9 = new Cancion("If we beeing rëal", "Yeat", 173);
        Cancion cancion10 = new Cancion("Capo", "NLE Choppa", 192);
        Cancion[] cancionesDisponibles = new Cancion[10];
        cancionesDisponibles[0] = cancion1;
        cancionesDisponibles[1] = cancion2;
        cancionesDisponibles[2] = cancion3;
        cancionesDisponibles[3] = cancion4;
        cancionesDisponibles[4] = cancion5;
        cancionesDisponibles[5] = cancion6;
        cancionesDisponibles[6] = cancion7;
        cancionesDisponibles[7] = cancion8;
        cancionesDisponibles[8] = cancion9;
        cancionesDisponibles[9] = cancion10;
        
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
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
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
