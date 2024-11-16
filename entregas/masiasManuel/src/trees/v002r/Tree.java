package trees.v002r;

class Tree {
    private Node root;
    
    public Tree() {
        this.root = null;
    }
    
    public void insert(int value) {
        root = recursiveInsert(root, value);
    }

    private Node recursiveInsert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        
        if (value > node.value) {
            node.left = recursiveInsert(node.left, value);
        } else {
            node.right = recursiveInsert(node.right, value);
        }
        
        return node;
    }
    
    public void print() {
        if (root == null) {
            System.out.println("Árbol vacío");
            return;
        }
        System.out.println("Árbol:");
        recursivePrint(root, 0);
    }
    
    private void recursivePrint(Node node, int nivel) {
        if (node == null) return;
        
        recursivePrint(node.right, nivel + 1);
        
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        System.out.println(node.value);
        
        recursivePrint(node.left, nivel + 1);
    }
}