package entregas.TasconRaul.Reto_001;

import java.util.Random;

public class Cliente {

    private int objetos;

    public Cliente() {
        this.objetos = new Random().nextInt(10) + 1;
    }

    public int getObjetos() {
        return objetos;
    }

    public void añadirObjetos(int nuevosObjetos) {
        this.objetos += nuevosObjetos;
    }
}
