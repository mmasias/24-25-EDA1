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

    public String desapilar() {
        if (cima==null) {
            return null;
        }
        String contenido = cima.obtenerContenido();
        cima = cima.obtenerSiguiente();
        return contenido;
    }

    public NodoVersion obtenerCima(){
        return this.cima;
    }

    public void reordenarCima() {
        cima = cima.obtenerSiguiente(); 
    }

    public void apilarVersion(NodoVersion nodo) {
        NodoVersion nuevoNodo = new NodoVersion(nodo.obtenerIndice(), nodo.obtenerContenido());
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
    }
}
