import java.util.Random;

public class Cliente {

    private int bultos = 0;

    public int timer = 0;


    public Cliente() {
        bultos = new Random().nextInt(10);
    }

    public void setBultos(int bultos) {
        this.bultos = bultos;
    }
    public int getTimer() {
        return timer;
    }
    public void setTimer(int timer) {
        this.timer = timer;
    }


    public int getBultos() {
        return bultos;
    }


}
