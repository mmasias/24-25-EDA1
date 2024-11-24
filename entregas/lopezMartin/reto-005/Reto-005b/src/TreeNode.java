public class TreeNode {
    private String nombre;
    private List versiones;
    private TreeNode padre;
    private List hijos;

    public TreeNode(String nombre) {
        this.nombre = nombre;
        this.versiones = new List();
        this.hijos = new List();
        this.padre = null;
        versiones.insertEnd("Versión inicial");
    }

    public void agregarHijo(TreeNode hijo) {
        hijo.padre = this;
        hijos.insertEnd(hijo);
    }

    public String getNombre() {
        return nombre;
    }

    public List getVersiones() {
        return versiones;
    }

    public List getHijos() {
        return hijos;
    }

    public TreeNode getPadre() {
        return padre;
    }
}
