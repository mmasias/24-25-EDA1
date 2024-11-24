public class Main {
    private Tree arbol;
    private Directorio directorio = new Directorio();
    private TreeNode ramaActual;
    private Node versionActual;
    
    public Main(){
        arbol = new Tree(directorio);
        arbol.crearRama("main");
        ramaActual = arbol.getRoot();
        versionActual = ramaActual.getVersiones().obtenerUltimo();
    }
    public static void main(String[] args) {
        Main main = new Main();
        new Menu(main);
    }

    public Tree getArbol() {
        return arbol;
    }

    public TreeNode getRamaActual() {
        return ramaActual;
    }

    public void setRamaActual(TreeNode ramaActual) {
        this.ramaActual = ramaActual;
    }

    public Node getVersionActual() {
        return versionActual;
    }

    public void setVersionActual(Node versionActual) {
        this.versionActual = versionActual;
    }
}