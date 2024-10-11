package entregas.DiegoJimenez.reto002;
import java.util.ArrayList;

class FoundNodeList {

    private ArrayList<NodeWrapper> wrappedNodes;

    public FoundNodeList() {
        this.wrappedNodes = new ArrayList<>();
    }

    public void add(NodeWrapper nodeWrapper) {
        this.wrappedNodes.add(nodeWrapper);
    }

    public String[] getValues() {
        String[] values = new String[this.wrappedNodes.size()];
        for (int i = 0; i < wrappedNodes.size(); i++) {
            values[i] = wrappedNodes.get(i).getValue();
        }
        return values;
    }

    public int size() {
        return this.wrappedNodes.size();
    }

    public boolean isEmpty() {
        return this.wrappedNodes.isEmpty();
    }
}