public class TreeNode {
    private String nombre;
    private List version;
    private TreeNode padre;
    private List hijos;

    public TreeNode(TreeNode nodo){

    }

    public void  crearRama(TreeNode nodo, String nombre, List version){
        new TreeNode(nodo);
        this.nombre = nombre;
        this.version = version;
    }
}
