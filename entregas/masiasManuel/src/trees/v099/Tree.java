package trees.v099;

public class Tree {
    private Node root;
    private InsertionRule insertionRule;
    
    public Tree(InsertionRule rule) {
        this.root = null;
        this.insertionRule = rule;
    }
    
    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            insertionRule.insert(root, newNode);
        }
    }
    
    public void print() {
        printRecursive(root, 0);
    }
    
    private void printRecursive(Node node, int level) {
        if (node == null) return;
        
        printRecursive(node.right, level + 1);
        
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.value);
        
        printRecursive(node.left, level + 1);
    }
}