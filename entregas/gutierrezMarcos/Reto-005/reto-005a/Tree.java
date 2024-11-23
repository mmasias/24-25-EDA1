
public class Tree {
    private Node root;
    private Node versionActual;

    public Tree() {
        this.root = null;
        this.versionActual = null;
    }

    public void insert(int value) {
        if (root==null) {
            root = new Node(value, null, null, null);
            versionActual = root;
        }else{
            versionActual.añadirVersion(value, versionActual);
            versionActual = versionActual.getLista().getUltimo();
        }
    }


    public void print() {
        if (root == null) {
            System.out.println("No existe ninguna versión en el sistema");
            return;
        }
        System.out.println("Árbol:");
        //TODO
    }
    

    public String mostrarVersionActual(){

        if (versionActual==null) {
            return "de momento no existe ninguna version en el sistema.";
        }else{
            return versionActual.mostrar();
        }

    }

    public void moverseVersionAnterior() {
        if (versionActual.getPadre()==null) {
            System.out.println("Te encuentras en la versión inicial");
        }else{
            versionActual = versionActual.getPadre();
        }
        
    }

    public void moverseRamaIzquierda() {
        if (versionActual.getAnterior()!=null) {
            versionActual = versionActual.getAnterior();
        }else{
            System.out.println("Te encuentras actualmente en la primera rama");
        }
    }

    public void moverseRamaDerecha() {
        if (versionActual.getSiguiente()!=null) {
            versionActual = versionActual.getSiguiente();
        }else{
            System.out.println("No existe una rama a la derecha, muevete a la version anterior y crea una versión.");
        }
    }

}