class Client {
  private int id;
  private int items;

  public Client(int id, int items) {
    this.id = id;
    this.items = items;
  }

  public int getId() {
    return id;
  }

  public boolean hasItems() {
    return items > 0;
  }

}