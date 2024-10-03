class Hamburguesa {
    private Pan[] pan;
    private Carne carne;
    private Ingrediente ingredientes[];
    private int ingredientesAñadidos = 0;

    public Hamburguesa(Pan arriba, Pan abajo, Carne carne, int numeroDeExtras) {
        ingredientes = new Ingrediente[numeroDeExtras];
        pan = new Pan[2];
        pan[0] = arriba;
        pan[1]= abajo;
        this.carne = carne;
    }

    public void agregarExtra(Extra extra) {
        ingredientes[ingredientesAñadidos] = extra;
        ingredientesAñadidos++;
    }

    public String describir() {
        String descripcion = "";
        descripcion += pan[0].getNombre() + ", ";
        descripcion += carne.getNombre() + " " + carne.getCoccion();
        for (int i = 0; i < ingredientes.length; i++) {
            descripcion += ", " + ingredientes[i].describir();
        }
        return descripcion + "!!!" + "\n";
    }

    public void mostrar() {
        pan[0].mostrar();
        carne.mostrar();
        for (int i = 0; i < ingredientes.length; i++) {
            ingredientes[i].mostrar();
        }
        pan[1].mostrar();
        System.out.println();
    }
}
