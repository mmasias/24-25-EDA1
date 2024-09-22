package entregas.Ejercicio_1;

class Restaurante {

    private void atender() {
        Cocinero bobEsponja = new Cocinero();
        Camarero calamardo = new Camarero();

        bobEsponja.prepararHamburguesa();
        calamardo.recibir(bobEsponja.entregar());

        calamardo.servir();
    }

    public static void main(String[] args) {
        Restaurante crustaceoCrujiente = new Restaurante();
        crustaceoCrujiente.atender();
    }
}