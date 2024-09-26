
class QueueManager {
  private Client[] queue;
  private int size;
  private static final int MAX_CAPACITY = 100;

  public QueueManager() {
    queue = new Client[MAX_CAPACITY];
    size = 0;
  }

  public void addClient(Client client) {
    if (size < MAX_CAPACITY) {
      queue[size++] = client;
      System.out.println("Client " + client.getId() + " with " + client.getItems() + " items joins the queue.");
    } else {
      System.out.println("Queue is full, cannot add client.");
    }
  }

  public void attendFirstClient() {
    if (size > 0) {
      Client client = queue[0];
      System.out.println("Client " + client.getId() + " with " + client.getItems() + " items is being attended.");
      for (int i = 1; i < size; i++) {
        queue[i - 1] = queue[i];
      }
      queue[--size] = null;
    } else {
      System.out.println("The queue is empty.");
    }

  }

  public void clientLeaves(int id) {

  }

  public void bringItemsToClient(int id, int extraItems) {

  }

  public void licitSneakIn(Client client) {

  }

  public void illicitSneakIn(Client client, int position) {

  }

  public void showQueue() {

  }

  public int getQueueSize() {

  }

  public boolean shouldOpenNewRegister() {

  }

  private int findClientIndex(int id) {

  }

}