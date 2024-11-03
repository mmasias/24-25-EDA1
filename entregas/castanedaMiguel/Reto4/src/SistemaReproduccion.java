import java.util.Random;
import java.util.Scanner;

public class SistemaReproduccion{

    ColaReproduccion colaActual;
    ColaReproduccion historial;

    Biblioteca bibliotecaPersonal;

    public SistemaReproduccion(ColaReproduccion newCola){
        colaActual=newCola;
        historial=new ColaReproduccion("historial");
        bibliotecaPersonal=new Biblioteca();
    }
    public void menu (){
        int opcion;
        boolean continua=true;
        Scanner s= new Scanner(System.in);
        while(continua) {
            System.out.println("=== MENÚ PRINCIPAL === \n"+
                    "1. Reproducción\n"+
                    "2. Biblioteca\n"+
                    "3. Salir\n");
            opcion=s.nextInt();
            switch (opcion) {
                case 1:
                    colaActual.elegirCancion();
                    menuReproduccion();
                    break;
                case 2:
                    menuBiblioteca();
                    break;
                case 3:
                    return;
                default:
            }
        }
    }

    public void menuReproduccion(){
        int opcion;
        boolean continua=true;
        Scanner s= new Scanner(System.in);
        while(continua) {
            System.out.println(
                    "=== MENÚ REPRODUCCIÓN ===\n"+
                            "1. Ver canción actual\n"+
                            "2. Reproducir siguiente\n"+
                            "3. Reproducir anterior\n"+
                            "4. Ver cola de reproducción\n"+
                            "5. Ver historial\n"+
                            "6. Activar/desactivar aleatorio\n"+
                            "7. Activar/desactivar repetición\n"+
                            "8. Volver al menú principal\n"
            );
            opcion=s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println(colaActual.mostrarCancion());
                    break;
                case 2:
                    colaActual.cancionSiguiente();
                    break;
                case 3:
                    colaActual.cancionAnterior();
                    break;
                case 4:
                    colaActual.mostrarRestoCola();
                    break;
                case 5:
                    historial.mostrarRestoCola();
                    break;
                case 6:
                    colaActual.changeShuffle();
                    break;
                case 7:
                    colaActual.changeRepeat();
                    break;
                case 8:
                    return;
                default:
                    break;
            }
        }

    }

    public void menuBiblioteca(){
        int opcion;
        int opcion2;
        String opcionS;
        boolean continua=true;
        Scanner s= new Scanner(System.in);
        while(continua) {
            System.out.println("=== MENÚ BIBLIOTECA ===\n"+
                    "1. Añadir canción a favoritos\n"+
                    "2. Eliminar canción de favoritos\n"+
                    "3. Ver canciones favoritas\n"+
                    "4. Crear nueva playlist\n"+
                    "5. Añadir canción a playlist\n"+
                    "6. Eliminar canción de playlist\n"+
                    "7. Ver playlists\n"+
                    "8. Ver canciones de una playlist\n"+
                    "9. Volver al menú principal);\n");
            opcion=s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Elige la canción");
                    opcion=s.nextInt();
                    bibliotecaPersonal.nuevaFavorita(colaActual.devolverCancion(opcion));
                    break;
                case 2:
                    System.out.println("Elige una cancion: ");
                    bibliotecaPersonal.getFavoritas().mostrarCola();
                    opcion=s.nextInt();
                    bibliotecaPersonal.quitarFavorita(opcion);
                    break;
                case 3:
                    bibliotecaPersonal.getFavoritas().mostrarCola();
                    break;
                case 4:
                    System.out.println("Escribe un nombre: ");
                    opcionS=s.nextLine();
                    bibliotecaPersonal.nuevaCola(opcionS);
                    break;
                case 5:
                    System.out.println("Elige la canción que quieres añadir:");
                    colaActual.mostrarCola();
                    opcion=s.nextInt();
                    System.out.println("Elige a qué playlist añadir la canción:");
                    bibliotecaPersonal.visualizar();
                    opcion2=s.nextInt();
                    bibliotecaPersonal.adquirirCola(opcion2).añadir(colaActual.devolverCancion(opcion));
                    break;
                case 6:
                    System.out.println("Elige de qué playlist eliminar la canción:");
                    bibliotecaPersonal.visualizar();
                    opcion=s.nextInt();
                    System.out.println("Elige la canción que quieres eliminar:");
                    bibliotecaPersonal.adquirirCola(opcion).mostrarCola();
                    opcion2=s.nextInt();
                    bibliotecaPersonal.adquirirCola(opcion).quitar(opcion2);
                    break;
                case 7:
                    bibliotecaPersonal.visualizar();
                    break;
                case 8:
                    System.out.println("Elige qué playlist ver:");
                    bibliotecaPersonal.visualizar();
                    opcion=s.nextInt();
                    bibliotecaPersonal.adquirirCola(opcion).mostrarCola();
                    break;
                case 9:
                    return;
            }

        }
    }




}
