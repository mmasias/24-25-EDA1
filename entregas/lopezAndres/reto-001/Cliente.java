import java.util.Random;

public class Cliente {

    private int items;

    public Cliente(){

        items = new Random().nextInt(11);

    }

    public void añadirItems(int items) {
        this.items += items;
    }

}
