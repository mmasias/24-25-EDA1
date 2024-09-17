class Hamburguesa {
    private Pan panArriba;
    private Pan panAbajo;
    private Carne carne;
    private Extra[] extras;
    private int numeroExtras;
    private int posicionExtra;

    public Hamburguesa(Pan panArriba, Pan panAbajo, Carne carne, int numeroExtras){
        this.panArriba = panArriba;
        this.panAbajo = panAbajo;
        this.carne = carne;
        this.extras = new Extra[numeroExtras];
        this.numeroExtras = numeroExtras;
        this.posicionExtra = 0;
    }

    public String nombrarIngredientes() {
        String ingredientes = "Sale una " + carne.nombrar() + ", " +  panArriba.nombrar() + ", " + panAbajo.nombrar();
        for(int i = 0; i < numeroExtras; i++){
            ingredientes += ", " + extras[i].nombrar();
        }
        return ingredientes;
    }

    public void agregarExtra(Extra extra) {
        extras[posicionExtra] = extra;
        posicionExtra ++;
    }

    public String mostrarIngredientes() {
        String ingredientes = panArriba.mostrar() + panArriba + "\n";
        for (int i = 0; i < numeroExtras; i++){
            ingredientes += extras[i].mostrar() + extras[1] + "\n";
        }
        ingredientes += carne.mostrar() + carne + "\n" + panAbajo.mostrar() + panAbajo;


        return ingredientes;
        
    }

}
