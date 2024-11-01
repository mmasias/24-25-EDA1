public class App {
    public Cancion actual;
    public Canciones canciones = new Canciones();
    
    public App(){
        new Menu(actual, canciones);
    }

    public static void main(String[] args) {
        new App();
    }
}