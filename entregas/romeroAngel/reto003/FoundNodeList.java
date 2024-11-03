package romeroAngel.reto003;

import romeroAngel.reto004.Node;

public class FoundNodeList {
    private FoundNodeWrapper first;
    private int size;

    public FoundNodeList() {
        this.first = null;
        this.size = 0;
    }

    public void add(Node node) {
        FoundNodeWrapper newWrapper = new FoundNodeWrapper(node);
        if (first == null) {
            first = newWrapper;
        } else {
            FoundNodeWrapper current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newWrapper);
        }
        size++;
    }

    public FoundNodeWrapper getFirst() {
        return first;
    }

    public int size() {
        return size;
    }

    public void showInConsole() {
        System.out.println("=".repeat(25));
        System.out.println("Fila de " + this.size());
        System.out.println("-".repeat(25));
        if (this.first != null) {
            FoundNodeWrapper iterator = this.first;
            while (iterator != null) {
                System.out.print("[" + iterator.getFoundNode().getValue() + "]" + iterator.getFoundNode() + " / ");
                iterator = iterator.getNext();
            }
        }
        System.out.println();
    }    

}