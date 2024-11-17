package trees.v099;

public class BSTRule implements InsertionRule {
    @Override
    public void insert(Node root, Node newNode) {
        if (newNode.value < root.value) {
            if (root.left == null) {
                root.left = newNode;
            } else {
                insert(root.left, newNode);
            }
        } else {
            if (root.right == null) {
                root.right = newNode;
            } else {
                insert(root.right, newNode);
            }
        }
    }
}