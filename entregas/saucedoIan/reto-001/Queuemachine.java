import java.util.Random;

class QueueMachine {
  private QueueManager queueManager;
  private Random random;

  public QueueMachine(QueueManager queueManager) {
    this.queueManager = queueManager;
    this.random = new Random();
  }

  public void generateRandomEvent() {

    queueManager.attendFirstClient();
    if (queueManager.shouldOpenNewRegister()) {
      System.out.println("A new register is opened due to too many clients in the queue.");
      return;
    }

    int event = random.nextInt(6);
    int randomClientId = random.nextInt(100);
    int randomItems = random.nextInt(10) + 1;
    int randomPosition = random.nextInt(queueManager.getQueueSize() + 1);

    switch (event) {
      case 0:
        queueManager.addClient(new Client(randomClientId, randomItems));
        break;
      case 1:
        queueManager.addClient(new Client(randomClientId, randomItems));
        break;
      case 2:
        queueManager.clientLeaves(randomClientId);
        break;
      case 3:
        queueManager.bringItemsToClient(randomClientId, randomItems);
        break;
      case 4:
        queueManager.licitSneakIn(new Client(randomClientId, randomItems));
        break;
      case 5:
        queueManager.illicitSneakIn(new Client(randomClientId, randomItems), randomPosition);
        break;
      default:
        System.out.println("Unrecognized event.");
    }
  }
}
