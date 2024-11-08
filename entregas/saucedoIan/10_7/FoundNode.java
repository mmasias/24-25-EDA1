
public class FoundNode {
  private Node originalNode;
  private FoundNode next;

  public FoundNode(Node originalNode) {
    this.originalNode = originalNode;
    this.next = null;
  }

  public Node getOriginalNode() {
    return originalNode;
  }

  public FoundNode getNext() {
    return next;
  }

  public void setNext(FoundNode next) {
    this.next = next;
  }

}
