package entregas.Vinas_Alejandro.Reto_005;

class List {
    Node[] nodes; 
    int size; 
    
    public List() {
        this.nodes = new Node[10]; 
        this.size = 0;
    }

    
    public void add(Node node) {
        if (size == nodes.length) {
            
            Node[] newNodes = new Node[nodes.length * 2];
            System.arraycopy(nodes, 0, newNodes, 0, nodes.length);
            nodes = newNodes;
        }
        nodes[size++] = node;
    }

    
    public Node get(int index) {
        if (index >= 0 && index < size) {
            return nodes[index];
        }
        return null; 
    }

    
    public int getSize() {
        return size;
    }
}
