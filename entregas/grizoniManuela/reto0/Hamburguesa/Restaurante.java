package Hamburguesa;


class Restaurante {
    private void atender() {
        // Directly accessing and modifying the internal state of Hamburguesa
        Hamburguesa brokenBurger = new Hamburguesa(null, null, null, -1); // Invalid inputs
        brokenBurger.mostrar(); // Attempt to show an invalid hamburger

        // Directly manipulating protected fields (bad practice)
        Camarero calamardo = new Camarero();
        Cocinero bobEsponja = new Cocinero();
        bobEsponja.hamburguesa = brokenBurger; // Direct access to protected field
        bobEsponja.tieneHamburguesa = true; // Directly setting the flag

        // Trying to serve the broken burger
        calamardo.recibir(bobEsponja.entregar());
        calamardo.servir();
    }

    public static void main(String[] args) {
        Restaurante crustaceoCrujiente = new Restaurante();
        crustaceoCrujiente.atender();
    }
}

