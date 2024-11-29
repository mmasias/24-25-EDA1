public class Tree {
    private TreeNode root;
    private Directorio directorio;

    public Tree(Directorio directorio) {
        this.directorio = directorio;
        this.root = null;
    }

    public void crearRama(String nombre) {
        if (root == null) {
            root = new TreeNode(nombre);
        } else {
            TreeNode nuevaRama = new TreeNode(nombre);
            root.agregarHijo(nuevaRama);
        }
    }

    public TreeNode getRoot() {
        return root;
    }
}