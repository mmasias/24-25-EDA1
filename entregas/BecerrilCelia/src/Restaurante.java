package src;

class Restaurante {

    private void atender(Carne carne) {

        Cocinero bobEsponja = new Cocinero();
        Camarero calamardo = new Camarero();
        
        bobEsponja.prepararHamburguesa(carne);
        calamardo.recibir(bobEsponja.entregar());

        calamardo.servir();
    }
    public static void main(String[] args) {
        Carne carne = new Res("poco hecha");
        Restaurante crustaceoCrujiente = new Restaurante();
        crustaceoCrujiente.atender(carne);
        crustaceoCrujiente.atender(carne);
    }
}
