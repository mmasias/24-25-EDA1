
class QueueManager {
  private Client[] queue;
  private int size;
  private static final int MAX_CAPACITY = 100;
  private int processedClientsCount;

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
      processedClientsCount++;
    } else {
      System.out.println("The queue is empty.");
    }

  }

  public void clientLeaves(int id) {
    int index = findClientIndex(id);
    if (index != -1) {
      System.out.println("Client " + id + " leaves the queue.");
      for (int i = index + 1; i < size; i++) {
        queue[i - 1] = queue[i];
      }
      queue[--size] = null;
    } else {
      System.out.println("Client " + id + " is not in the queue.");
    }
  }

  public void bringItemsToClient(int id, int extraItems) {
    int index = findClientIndex(10);
    if (index != -1) {
      queue[index].addItems(5);
      System.out.println("Client " + id + " receives additional items.");

      addClient(new Client(generateRandomId(), 5));
    } else {
      System.out.println("Client " + id + " is not in the queue.");
    }
  }

  public void licitSneakIn(Client client) {
    if (size < MAX_CAPACITY) {
      for (int i = size; i > 0; i--) {
        queue[i] = queue[i - 1];
      }
      queue[0] = client;
      size++;
      System.out.println("Client " + client.getId() + " sneaks in at the front.");
    } else {
      System.out.println("Queue is full, cannot sneak in.");
    }

  }

  public void illicitSneakIn(Client client, int position) {
    System.out.print("Current queue: ");
    for (int i = 0; i < size; i++) {
      System.out.print(queue[i] + " ");
    }
    System.out.println();
  }

  public void showQueue() {
    System.out.print("Current queue: ");
    for (int i = 0; i < size; i++) {
      System.out.print(queue[i] + " ");
    }
    System.out.println();

  }

  public int getQueueSize() {
    return size;
  }

  public boolean shouldOpenNewRegister() {
    return size >= 7;
  }

  private int findClientIndex(int id) {
    for (int i = 0; i < size; i++) {
      if (queue[i].getId() == id) {
        return i;
      }
    }
    return -1;

  }

  public int getProcessedClientsCount() {
    return processedClientsCount;
  }

  private int generateRandomId() {
    return (int) (Math.random() * 100);
  }

}