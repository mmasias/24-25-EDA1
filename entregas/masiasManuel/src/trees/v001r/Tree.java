package trees.v001r;

class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public void insert(int value) {
        root = recursiveInsert(root, value);
    }

    private Node recursiveInsert(Node node, int value) {
        if (node == null) 
            return new Node(value);
        
        int countLeft = countNodes(node.left);
        int countRight = countNodes(node.right);
        
        if (countLeft <= countRight) {
            node.left = recursiveInsert(node.left, value);
        } else {
            node.right = recursiveInsert(node.right, value);
        }
        
        return node;
    }

    private int countNodes(Node node) {
        if (node == null) 
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public void print() {
        if (root == null) {
            System.out.println("Árbol vacío");
            return;
        }
        System.out.println("Árbol:");
        recursivePrint(root, 0);
    }
    
    private void recursivePrint(Node nodo, int nivel) {
        if (nodo == null) return;
        
        recursivePrint(nodo.right, nivel + 1);
        
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        System.out.println(nodo.value);
        
        recursivePrint(nodo.left, nivel + 1);
    }
}