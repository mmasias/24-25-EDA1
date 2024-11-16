package trees.v000;

class Tree {
    private Node root;
    
    public Tree() {
        this.root = null;
    }
    
    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        
        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }
    
    public void print() {
        if (root == null) {
            System.out.println("Árbol vacío");
            return;
        }
        
        Node[] pila = new Node[100];
        int[] niveles = new int[100];
        int top = -1;
        Node current = root;
        int nivelActual = 0;
    
        while (true) {
            while (current != null) {
                top++;
                pila[top] = current;
                niveles[top] = nivelActual;
                current = current.right;
                nivelActual++;
            }
    
            if (top >= 0) {
                current = pila[top];
                nivelActual = niveles[top];
                top--;
    
                for (int i = 0; i < nivelActual; i++) {
                    System.out.print("    ");
                }
                System.out.println(current.value);
    
                current = current.left;
                nivelActual++;
            } else {
                break;
            }
        }
    }   
}