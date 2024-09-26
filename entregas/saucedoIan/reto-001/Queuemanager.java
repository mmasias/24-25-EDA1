

class QueueManager (Client Client[])x {
  private Client[] queue;
  private int size;
  private static final int MAX_CAPACITY = 100;

  public QueueManager() { 
    queue = new Client[MAX_CAPACITY];
    size = 0;
  }

  public void addClient(Client client) {

  }

  public void attendFirstClient() {

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