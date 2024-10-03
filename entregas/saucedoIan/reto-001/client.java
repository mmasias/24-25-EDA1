class Client {
  private int id;
  private int items;

  public Client(int id, int items) {
    this.id = id;
    this.items = items;
  }

  public int getItems() {
    return items;
  }

  public int getId() {
    return id;
  }

  public boolean hasItems() {
    return items > 0;
  }

  public void setItems(int items) {
    this.items = items;
  }

  public void addItems(int additionalItems) {
    this.items += additionalItems;
  }

  @Override
  public String toString() {
    return "Client{" + "id=" + id + ", items=" + items + '}';
  }
}