package entregas.lopezMartin.reto_006;

public class Lista {

    private Nodo primero;
    private Nodo lineaActiva;

    public Lista(){

        this.primero = null;
        inicializar();
        this.lineaActiva = primero;

    }

    private void inicializar() {
        Nodo nodoActual = null;

        for (int i = 1; i <= 10; i++) {
            Nodo nuevoNodo = new Nodo(i);
            if (primero == null) {
                primero = nuevoNodo;
                nodoActual = primero;
            } else {
                nodoActual.setSiguiente(nuevoNodo);
                nodoActual = nuevoNodo;
            }
        }
    }

    public void print() {
        Nodo current = primero;
        while (current!=null) {
            if (current == lineaActiva) {
                System.out.println(current.obtenerIndice() + ":*|" + current.obtenerContenido());
            }else{
                System.out.println(current.obtenerIndice() + ": |" + current.obtenerContenido());
            }
            current = current.getSiguiente();
        }
    }

    public void cambiarLineaActiva(int numeroLinea) {
        assert numeroLinea>=1 && numeroLinea<=10;

        Nodo current = primero;
        while(current!=null){
            if (current.obtenerIndice()==numeroLinea) {
                this.lineaActiva = current;
                return;
            }
            current = current.getSiguiente();
        }
        
    }

}
