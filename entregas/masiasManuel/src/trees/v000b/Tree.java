package trees.v000b;

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
        boolean posicionEncontrada = false;

        while (!posicionEncontrada) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = newNode;
                    posicionEncontrada = true;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    posicionEncontrada = true;
                } else {
                    current = current.right;
                }
            }
        }
    }

    public void print() {
        if (root == null) {
            System.out.println("Árbol vacío");
            return;
        }
        
        Node[] nodosEnPila = new Node[50];
        int[] nivelesEnPila = new int[50];
        int elementosEnPila = 0;
        
        Node nodoActual = root;
        int nivelActual = 0;
        
        boolean impresionCompletada = false;
        while (!impresionCompletada) {
            while (nodoActual != null) {
                nodosEnPila[elementosEnPila] = nodoActual;
                nivelesEnPila[elementosEnPila] = nivelActual;
                elementosEnPila++;
                
                nodoActual = nodoActual.right;
                nivelActual++;
            }
            
            if (elementosEnPila == 0) {
                impresionCompletada = true;
            } else {
                elementosEnPila--;
                nodoActual = nodosEnPila[elementosEnPila];
                nivelActual = nivelesEnPila[elementosEnPila];
                
                for (int i = 0; i < nivelActual; i++) {
                    System.out.print("    ");
                }
                System.out.println(nodoActual.value);
                
                nodoActual = nodoActual.left;
                nivelActual = nivelesEnPila[elementosEnPila] + 1;
            }
        }
    }
}