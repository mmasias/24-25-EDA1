public class Cliente {
    private int items;

    public Cliente() {
        this.items = 5 + (int) (Math.random() * 11); 
    }

    public int getItems() {
        return items;
    }
}
