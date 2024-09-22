package entregas.Ejercicio_1maluso;

public class Hamburguesa {

    private Pan panSuperior;
    private Pan panInferior;
    private Carne laCarne;
    private int extrasIntroducidos;
    private Extras[] extras;

    public Hamburguesa(Pan panSuperior, Pan panInferior, Carne laCarne, int numeroExtras) {
        this.panSuperior = panSuperior;
        this.panInferior = panInferior;
        this.laCarne = laCarne;
        if (numeroExtras > 4) {
            numeroExtras = 4;
        }
        this.extras = new Extras[numeroExtras];
        this.extrasIntroducidos = 0;
    }

    public void agregarExtra(Extras extra) {
        if (extrasIntroducidos < extras.length) {
            this.extras[extrasIntroducidos] = extra;
            extrasIntroducidos++;
        }
    }

    public Pan getPanSuperior() {
        return panSuperior;
    }

    public Pan getPanInferior() {
        return panInferior;
    }

    public Carne getLaCarne() {
        return laCarne;
    }

    public int getExtrasIntroducidos() {
        return extrasIntroducidos;
    }

    public Extras[] getExtras() {
        return extras;
    }

    public String describir() {
        String texto = "";
        texto = "Sale una " + this.panSuperior.describir();

        texto += ",  " + this.laCarne.describir();

        for (int i = 0; i < extras.length; i++) {
            texto += ", " + extras[i].describir();
        }
        return texto;

    }

    public void mostrar() {

        System.out.println(panSuperior.mostrar());
        System.out.println(laCarne.mostrar());
        for (int i = 0; i < extras.length; i++) {
            System.out.println(extras[i].mostrar());
        }
        System.out.println(panInferior.mostrar());
    }

}
