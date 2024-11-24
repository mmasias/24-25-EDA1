package entregas.Vinas_Alejandro.Reto_005;

class ControlVersion {
    Node root;
    Node currentBranch; 

    
    public ControlVersion(String rootId, String[] rootData) {
        this.root = new Node(rootId, rootData, null);
        this.currentBranch = root; 
    }

    
    public Node createBranch(String[] additionalData) {
        return currentBranch.addChild(additionalData);
    }

    
    public boolean switchBranch(String branchId) {
        Node branch = findNode(root, branchId);
        if (branch != null) {
            currentBranch = branch;
            return true;
        }
        return false; // Rama no encontrada
    }

    
    public void printTree(Node node, int level) {
        if (node == null) return;

        
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        String activeIndicator = (node == currentBranch) ? " (ACTIVE)" : "";
        System.out.println("Node ID: " + node.id + ", Data: " + String.join(", ", node.data) + activeIndicator);

        
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