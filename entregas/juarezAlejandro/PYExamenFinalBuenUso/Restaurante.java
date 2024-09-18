class Restaurante {

    private void atender() {
        Cocinero bobEsponja = new Cocinero();
        Camarero calamardo = new Camarero();

        bobEsponja.prepararHamburguesa();
        calamardo.recibir(bobEsponja.entregar());

        calamardo.servir();
        System.out.println("-".repeat(85));
        calamardo.servir();
        System.out.println("-".repeat(85));
        calamardo.servir();
        System.out.println("-".repeat(85));
        calamardo.servir();
        System.out.println("-".repeat(85));
        calamardo.servir();
        System.out.println("-".repeat(85));
        
    }

    public static void main(String[] args) {
        Restaurante crustaceoCrujiente = new Restaurante();
        crustaceoCrujiente.atender();
    }
}