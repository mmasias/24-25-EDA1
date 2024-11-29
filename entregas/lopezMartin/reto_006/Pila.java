package entregas.lopezMartin.reto_006;

public class Pila {

    private NodoVersion cima;

    public Pila() {

        this.cima = null;

    }

    public void apilar(int indice, String contenido){
        NodoVersion nuevoNodo = new NodoVersion(indice, contenido);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
    }

    public NodoVersion obtenerCima(){
        return this.cima;
    }

    public void reordenarCima() {
        cima = cima.obtenerSiguiente(); 
    }
}
