package trees.v010i;

class BalancedStrategy implements InsertionStrategy {
    @Override
    public boolean goLeft(Node current, int value) {
        return countNodes(current.left) <= countNodes(current.right);
    }
    
    private int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}