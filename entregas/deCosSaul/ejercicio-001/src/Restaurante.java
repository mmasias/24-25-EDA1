class Restaurante {

    private void atender(Carne laCarne) {
        Cocinero bobEsponja = new Cocinero();
        Camarero calamardo = new Camarero();
        
        bobEsponja.prepararHamburguesa(laCarne);
        calamardo.recibir(bobEsponja.entregar());

        calamardo.servir();
    }
    public static void main(String[] args) {
        Carne laCarne = new Res("poco hecha");
        Restaurante crustaceoCrujiente = new Restaurante();
        crustaceoCrujiente.atender(laCarne);
        crustaceoCrujiente.atender(laCarne);
    }
}