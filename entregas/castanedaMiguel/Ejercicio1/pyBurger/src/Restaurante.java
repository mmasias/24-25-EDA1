class Restaurante {

    private void atender() {

        Cocinero bobEsponja = new Cocinero();
        Camarero calamardo = new Camarero();
        for(int i=0; i<5; i++) {
            bobEsponja.prepararHamburguesa();
            calamardo.recibir(bobEsponja.entregar());

            System.out.println(bobEsponja.entregar().hashCode());
            calamardo.servir();
        }
    }
    public static void main(String[] args) {
        Restaurante crustaceoCrujiente = new Restaurante();
        crustaceoCrujiente.atender();
    }
}
