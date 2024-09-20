class Restaurante {
    private void atender() {
        Cocinero bobEsponja = new Cocinero();
        Camarero calamardo = new Camarero();

        // 5 hamburguesas con la misma carne
        Carne carneRes = new Res("poco hecha");
        for (int i = 0; i < 5; i++) {
            Hamburguesa hamburguesa = bobEsponja.prepararHamburguesa(carneRes);
            calamardo.recibir(hamburguesa);
            calamardo.servir();
        }

        // 5 hamburguesas con diferentes instancias de Res
        for (int i = 0; i < 5; i++) {
            Carne carneResDiferente = new Res("poco hecha"); // Crear una nueva instancia de Res
            Hamburguesa hamburguesa = bobEsponja.prepararHamburguesa(carneResDiferente);
            calamardo.recibir(hamburguesa);
            calamardo.servir();
        }
    }

    public static void main(String[] args) {
        Restaurante crustaceoCrujiente = new Restaurante();
        crustaceoCrujiente.atender();
    }
}
