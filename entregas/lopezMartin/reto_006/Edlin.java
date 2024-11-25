package entregas.lopezMartin.reto_006;
public class Edlin{

    public static void main(String[] args) {

        Pila lineas = new Pila();
        Pila versionesAnteriores = new Pila();
        Pila versionesPosteriores = new Pila();
        Interfaz interfaz = new Interfaz(lineas, versionesAnteriores, versionesPosteriores);
        interfaz.mostrar();
        
    }
}