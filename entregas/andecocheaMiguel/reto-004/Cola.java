

import java.util.LinkedList;

public class Cola {
    private LinkedList<Cancion> cola;

    public Cola() {
        cola = new LinkedList<>();
    }

    public void agregar(Cancion cancion) {
        cola.add(cancion);
    }

    public Cancion sacar() {
        return cola.poll();
    }

    public void mostrarCola() {
        for (int i = 0; i < cola.size(); i++) {
            Cancion cancion = cola.get(i);
            System.out.println((i + 1) + ". " + cancion);
        }
    }

    public boolean isEmpty() {
        return cola.isEmpty();
    }
}