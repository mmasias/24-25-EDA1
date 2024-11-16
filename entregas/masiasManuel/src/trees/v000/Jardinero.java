package trees.v000;

class Jardinero {
    public static void main(String[] args) {
        Tree tree = new Tree();
        
        tree.insert(2);
        tree.insert(6);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(9);
        tree.insert(10);
        
        System.out.println("Árbol resultante:");
        tree.print();
    }
}