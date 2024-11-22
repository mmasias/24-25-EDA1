package entregas.Vinas_Alejandro.Reto_005;

class ControlVersion{

Node root; 

    public ControlVersion(String rootId, String[] rootData) {
        this.root = new Node(rootId, rootData, null);
    }

    
    public Node createBranch(Node parentNode, String id, String[] additionalData) {
        return parentNode.addChild(id, additionalData);
    }

    
    public void printTree(Node node, int level) {
        if (node == null) return;

        
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println("Node ID: " + node.id + ", Data: " + String.join(", ", node.data));

       
        for (int i = 0; i < node.children.getSize(); i++) {
            printTree(node.children.get(i), level + 1);
        }
    }

    
    public Node findNode(Node node, String id) {
        if (node.id.equals(id)) {
            return node;
        }
        for (int i = 0; i < node.children.getSize(); i++) {
            Node found = findNode(node.children.get(i), id);
            if (found != null) {
                return found;
            }
        }
        return null; 
}
}