class Restaurante {

    private void atender() {

        Cocinero bobEsponja = new Cocinero();
        Camarero calamardo = new Camarero();

        for (int i = 0; i < 5; i++) {
            bobEsponja.prepararHamburguesa();
            calamardo.recibir(bobEsponja.entregar());
            calamardo.servir();
            System.out.println("-".repeat(85));
        }
        /*
         * Tambien sirve como ejemplo
         * calamardo.servir();
         * System.out.println("-".repeat(85));
         * calamardo.servir();
         * System.out.println("-".repeat(85));
         * calamardo.servir();
         * System.out.println("-".repeat(85));
         * calamardo.servir();
         * System.out.println("-".repeat(85));
         * calamardo.servir();
         * System.out.println("-".repeat(85));
         */
    }

    public static void main(String[] args) {
        Restaurante crustaceoCrujiente = new Restaurante();
        crustaceoCrujiente.atender();
    }
}