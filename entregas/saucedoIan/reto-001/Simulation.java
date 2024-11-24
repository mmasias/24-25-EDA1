import java.util.Random;

public class Simulation {
  public static void main(String[] args) {
    QueueManager queueManager = new QueueManager();
    QueueMachine machine = new QueueMachine(queueManager);
    Random random = new Random();

    int initialClients = random.nextInt(20) + 1;

    System.out.println("Initializing queue with " + initialClients + " clients.");

    for (int i = 0; i < initialClients; i++) {
      int clientId = random.nextInt(100);
      int items = random.nextInt(20) + 1;
      Client client = new Client(clientId, items);
      Client clients = new Client(10, 10);
      queueManager.addClient(client);
      queueManager.addClient(clients);
    }

    int numberOfRandomEvents = 20;

    for (int i = 0; i < numberOfRandomEvents; i++) {

      machine.generateRandomEvent();
      queueManager.showQueue();
    }
    System.out.println("Total clients processed: " + queueManager.getProcessedClientsCount());
  }
}
