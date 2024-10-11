import java.util.LinkedList;
import java.util.List;

public class NodeWrapper {
    private List<Node> nodes;

    public NodeWrapper() {
        nodes = new LinkedList<>();
    }

    public void add(Node node) {
        nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
