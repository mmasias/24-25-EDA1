package entregas.lopezMartin.reto_006;

public class Documento {

    private Lista lineasTexto;
    private Pila versionesAnteriores;
    private Pila versionesPosteriores;
    private Interfaz interfaz;

    public Documento(){
        this.lineasTexto = new Lista();
        this.versionesAnteriores = new Pila();
        this.versionesPosteriores = new Pila();
        this.interfaz = new Interfaz(lineasTexto, versionesAnteriores, versionesPosteriores);
    }

    public void ejecutar() {
        interfaz.mostrar();
    }
}