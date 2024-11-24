package entregas.andecocheaMiguel.reto-004;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Cancion> canciones;
    private ArrayList<Cancion> cancionesFavoritas;

    public Biblioteca() {
        canciones = new ArrayList<>();
        cancionesFavoritas = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public void agregarAFavoritas(Cancion cancion) {
        if (!cancionesFavoritas.contains(cancion)) {
            cancion.setFavorita(true);
            cancionesFavoritas.add(cancion);
        }
    }

    public void eliminarDeFavoritas(Cancion cancion) {
        if (cancionesFavoritas.contains(cancion)) {
            cancion.setFavorita(false);
            cancionesFavoritas.remove(cancion);
        }
    }

    public void mostrarCanciones() {
        for (int i = 0; i < canciones.size(); i++) {
            System.out.println((i + 1) + ". " + canciones.get(i));
        }
    }

    public void mostrarCancionesFavoritas() {
        for (int i = 0; i < cancionesFavoritas.size(); i++) {
            System.out.println((i + 1) + ". " + cancionesFavoritas.get(i));
        }
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public ArrayList<Cancion> getCancionesFavoritas() {
        return cancionesFavoritas;
    }
}
