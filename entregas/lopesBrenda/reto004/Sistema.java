package entregas.lopesBrenda.reto004;

public class Sistema {
    private BibliotecaMusical biblioteca;
    private ReproductorMusica reproductor;

    public Sistema() {
        this.biblioteca = new BibliotecaMusical();
        this.reproductor = new ReproductorMusica();
    }

    public void mostrarMenu() {
    }

    public void procesarOpcion(int opcion) {
    }

    public void reproducirCancion(Cancion cancion) {
        reproductor.reproducir(cancion);
    }

    public void gestionarBiblioteca() {
    }
}
