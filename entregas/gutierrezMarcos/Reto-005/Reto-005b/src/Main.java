public class Main {
    private Tree arbol;
    private Directorio directorio = new Directorio();
    private TreeNode ramaActual;
    private Node versionActual;
    public Main(){
        arbol = new Tree(directorio);
        arbol.crearRama("main")
        ramaActual = arbol.getRoot();
        versionActual = ramaActual.getVersiones().obtenerUltimo();
    }
    public static void main(String[] args) {
        new Main();
        new Menu();
    }
}