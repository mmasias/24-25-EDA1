package trees.v099;

public class Jardinero {
    public static void main(String[] args) {
        System.out.println("Árbol con regla BST:");
        Tree bstTree = new Tree(new BSTRule());
        bstTree.insert(2);
        bstTree.insert(6);
        bstTree.insert(5);
        bstTree.insert(3);
        bstTree.insert(7);
        bstTree.insert(1);
        bstTree.insert(9);
        bstTree.insert(10);
        bstTree.print();
        
        System.out.println("Árbol con regla de Balance:");
        Tree balanceTree = new Tree(new BalanceRule());
        balanceTree.insert(2);
        balanceTree.insert(6);
        balanceTree.insert(5);
        balanceTree.insert(3);
        balanceTree.insert(7);
        balanceTree.insert(1);
        balanceTree.insert(9);
        balanceTree.insert(10);
        balanceTree.print();
    }
}
