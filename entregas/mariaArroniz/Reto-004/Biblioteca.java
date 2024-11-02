import java.util.Scanner;

class Biblioteca {

    private Favoritos favoritos;
    private Playlist playlist;

    
    public void añadirCancionFavoritos() {
        favoritos.añadirCancion();
    }
    
    public void eliminarCancionFavoritos() {
        favoritos.eliminarCancion();
    }
    
    public void imprimirFavoritos() {
        favoritos.imprimir();
    }
    
    public void crearPlaylist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre de la nueva playlist: ");
        String nombre = scanner.nextLine();

        Playlist playlist = new Playlist(nombre);
    }
    
    public void añadirCancionPlaylist() {
        
    }
    
    public void eliminarCancionPlaylist() {
        
    }
    
    public void imprimir() {
        
    }
    
    public void imprimirPlaylist() {
        
    }

}
