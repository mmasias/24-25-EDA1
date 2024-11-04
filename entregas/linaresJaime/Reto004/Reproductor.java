package entregas.linaresJaime.Reto004;

import java.util.Random;

public class Reproductor {
    private Playlist playlistSeleccionada;
    private Node cancionActual;
    private Lista historialReproduccion;
    private boolean modoAleatorio;
    private boolean modoRepeticion;

    public Reproductor() {
        this.historialReproduccion = new Lista();
        this.modoAleatorio = false;
        this.modoRepeticion = false;
    }


    public void seleccionarPlaylist(Playlist playlist) {
        this.playlistSeleccionada = playlist;
        this.cancionActual = playlist.getCanciones().getFirst();
        this.historialReproduccion.deleteAll();
        System.out.println("Playlist seleccionada: " + playlist.getTitulo());
    }

    public void reproducirCancionActual() {
        if (cancionActual != null) {
            Object cancion = cancionActual.getValue();
            System.out.println("Reproduciendo: " + cancion.toString());
            historialReproduccion.insertEnd(cancion);
        } else {
            System.out.println("No hay canciones para reproducir.");
        }
    }

    public void activarModoAleatorio() {
        this.modoAleatorio = !this.modoAleatorio;
        System.out.println("Modo aleatorio " + (modoAleatorio ? "activado" : "desactivado"));
    }

    public void activarModoRepeticion() {
        this.modoRepeticion = !this.modoRepeticion;
        System.out.println("Modo repetición " + (modoRepeticion ? "activado" : "desactivado"));
    }

    public void siguienteCancion() {
        if (playlistSeleccionada == null || playlistSeleccionada.getCanciones().getFirst() == null) {
            System.out.println("No hay canciones en la playlist.");
            return;
        }

        if (modoRepeticion) {
            reproducirCancionActual();
        } else if (modoAleatorio) {
            int playlistSize = playlistSeleccionada.getCanciones().size();
            int randomIndex = new Random().nextInt(playlistSize);

            Node iterator = playlistSeleccionada.getCanciones().getFirst();
            for (int i = 0; i < randomIndex; i++) {
                iterator = iterator.getNext();
            }
            cancionActual = iterator;
            reproducirCancionActual();
        } else {
            if (cancionActual != null && cancionActual.getNext() != null) {
                cancionActual = cancionActual.getNext();
                reproducirCancionActual();
            } else {
                System.out.println("Fin de la playlist.");
            }
        }
    }

    public void cancionAnterior() {
        if (cancionActual != null && playlistSeleccionada != null) {
            Node iterador = playlistSeleccionada.getCanciones().getFirst();
            Node anterior = null;
            while (iterador != cancionActual) {
                anterior = iterador;
                iterador = iterador.getNext();
            }
            if (anterior != null) {
                cancionActual = anterior;
                reproducirCancionActual();
            } else {
                System.out.println("Esta es la primera canción de la playlist.");
            }
        } else {
            System.out.println("No hay canciones en la playlist.");
        }
    }

    public void mostrarHistorial() {
        System.out.println("Historial de reproducción:");
        System.out.println(historialReproduccion.listAll());
    }

    public void verColaDeReproduccion() {
        if (playlistSeleccionada == null || playlistSeleccionada.getCanciones().getFirst() == null) {
            System.out.println("No hay canciones en la cola de reproducción.");
            return;
        }

        System.out.println("Cola de reproducción:");
        Node iterator = playlistSeleccionada.getCanciones().getFirst();
        int count = 1;

        while (iterator != null) {
            if (iterator == cancionActual) {
                System.out.println(count + ". [Reproduciendo] " + iterator.getValue().toString());
            } else {
                System.out.println(count + ". " + iterator.getValue().toString());
            }
            count++;
            iterator = iterator.getNext();
        }
    }
}