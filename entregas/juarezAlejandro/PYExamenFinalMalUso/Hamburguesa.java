class Hamburguesa {

    private Pan[] panes;
    private Carne carne;
    private Extras[] extras;
    private int extrasAgregados;

    public Hamburguesa(Pan panSuperior, Pan panInferior, Carne carne, int numeroExtras) {
        this.panes = new Pan[] { panSuperior, panInferior };
        this.carne = carne;
        this.extras = new Extras[numeroExtras];
        this.extrasAgregados = 0;
    }

    public void agregarExtra(Extras extra) {
        extras[extrasAgregados] = extra;
        extrasAgregados++;
    }

    public void mostrar() {
        panes[0].mostrar();
        carne.mostrar();
        for (int i = 0; i < extrasAgregados; i++) {
            extras[i].mostrar();
        }
        panes[1].mostrar();
    }

    public String describir() {
        String descripcion;
        descripcion = panes[0].describir() + ", " + carne.describir();
        for (int i = 0; i < extrasAgregados; i++) {
            descripcion = descripcion + ", " + extras[i].describir();
        }
        descripcion = descripcion + "\n";
        return descripcion;
    }
}
