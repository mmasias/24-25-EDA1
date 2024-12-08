package entregas.lopezMartin.reto_006;

public class Documento {

    private Lista lineasTexto;
    private Pila versionesAnteriores;
    private Pila versionesPosteriores;
    private FileManager manager;
    private Interfaz interfaz;
    
    public Documento(int nLineas){
        this.lineasTexto = new Lista(nLineas);
        this.versionesAnteriores = new Pila();
        this.versionesPosteriores = new Pila();
        this.manager = new FileManager("entregas/lopezMartin/reto_006/Edlin.txt", nLineas);
        this.interfaz = new Interfaz(lineasTexto, versionesAnteriores, versionesPosteriores, manager);
    }

    public void ejecutar() {
        interfaz.mostrar();
    }
}