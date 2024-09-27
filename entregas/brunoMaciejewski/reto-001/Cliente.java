import java.util.Random;

public class Cliente {
    private int items;

    public Cliente(){
        items=new Random().nextInt(1,20);
    }

    public void añadirItems() {
        items+=new Random().nextInt(1,5);
    }

    public void colarse(Fila fila) {
        fila.colarCliente(this);
    }

    public int getItems() {
        return items;
    }
}
