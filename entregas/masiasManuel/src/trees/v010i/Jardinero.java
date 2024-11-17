package trees.v010i;

class Jardinero {
    public static void main(String[] args) {

        Tree normalTree = new Tree(new NormalBSTStrategy());
        Tree balancedTree = new Tree(new BalancedStrategy());
        Tree invertedTree = new Tree(new InvertedBSTStrategy());
        
        System.out.println("Árbol BST Normal:");
        normalTree.insert(2);
        normalTree.insert(6);
        normalTree.insert(5);
        normalTree.insert(3);
        normalTree.insert(7);
        normalTree.insert(1);
        normalTree.insert(9);
        normalTree.insert(10);
        normalTree.print();
        
        System.out.println("Árbol Balanceado:");
        balancedTree.insert(2);
        balancedTree.insert(6);
        balancedTree.insert(5);
        balancedTree.insert(3);
        balancedTree.insert(7);
        balancedTree.insert(1);
        balancedTree.insert(9);
        balancedTree.insert(10);
        balancedTree.print();
        
        System.out.println("Árbol BST Invertido:");
        invertedTree.insert(2);
        invertedTree.insert(6);
        invertedTree.insert(5);
        invertedTree.insert(3);
        invertedTree.insert(7);
        invertedTree.insert(1);
        invertedTree.insert(9);
        invertedTree.insert(10);
        invertedTree.print();
    }    
}