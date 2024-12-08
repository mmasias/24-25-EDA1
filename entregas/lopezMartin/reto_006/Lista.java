package entregas.lopezMartin.reto_006;

public class Lista {

    private Nodo primero;
    private Nodo lineaActiva;
    private int nLineas;

    public Lista(int nLineas){

        this.primero = null;
        inicializar(nLineas);
        this.lineaActiva = primero;
        this.nLineas = nLineas;

    }

    private void inicializar(int nLineas) {
        Nodo nodoActual = null;

        for (int i = 1; i <= nLineas; i++) {
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
                System.out.println(current.obtenerIndice() + ":*|" + ((current.obtenerContenido() == null) ? "" : current.obtenerContenido()));
            }else{
                System.out.println(current.obtenerIndice() + ": |" + ((current.obtenerContenido() == null) ? "" : current.obtenerContenido()));
            }
            current = current.getSiguiente();
        }
    }

    public void cambiarLineaActiva(int numeroLinea) {
        assert numeroLinea>=1 && numeroLinea<=nLineas;

        Nodo current = primero;
        while(current!=null){
            if (current.obtenerIndice()==numeroLinea) {
                this.lineaActiva = current;
                return;
            }
            current = current.getSiguiente();
        }
        
    }

    public void editarLinea(String contenido) {
        if(contenido!=null){
            lineaActiva.setContenido(contenido);
        }else{
            lineaActiva.setContenido("");
        }
    }

    public void intercambiarLineas(int indiceL1, int indiceL2, FileManager manager) {
        assert (indiceL1 >= 1 && indiceL1 <= nLineas) && (indiceL2 >= 1 && indiceL2 <= nLineas);

        String contenidoL1 = "";
        String contenidoL2 = "";

        Nodo currentL1 = primero;
        while(currentL1!=null){
            if (currentL1.obtenerIndice()==indiceL1) {
                contenidoL1 = currentL1.obtenerContenido();
                break;
            }
            currentL1 = currentL1.getSiguiente();
        }

        Nodo currentL2 = primero;
        while(currentL2!=null){
            if (currentL2.obtenerIndice()==indiceL2) {
                contenidoL2 = currentL2.obtenerContenido();
                break;
            }
            currentL2 = currentL2.getSiguiente();
        }

        manager.updateLine(indiceL1, contenidoL2);
        manager.updateLine(indiceL2, contenidoL1);

    }

    public Nodo obtenerLineaActiva(){
        return this.lineaActiva;
    }

    public void borrarLineaActiva() {
        lineaActiva.setContenido("");
    }

    public void deshacerCambios(Pila versionesAnteriores, Pila versionesPosteriores) {

        if (versionesAnteriores.obtenerCima()!=null) {
            versionesPosteriores.apilar(obtenerLineaActiva().obtenerIndice(), obtenerLineaActiva().obtenerContenido());
            cambiarLineaActiva(versionesAnteriores.obtenerCima().obtenerIndice());
            editarLinea(versionesAnteriores.obtenerCima().obtenerContenido());
            versionesAnteriores.reordenarCima();
        }else{
            System.out.println("No hay versiones anteriores");
        }
    }

    public void pegar(String portapapeles) {
        if(portapapeles!=null){
            lineaActiva.setContenido(portapapeles);
        }else{
            System.out.println("No tienes nada en el portapapeles");
        }
    }

    public void rehacerCambios(Pila versionesPosteriores, Pila versionesAnteriores) {
        if (versionesPosteriores.obtenerCima()!=null) {
            versionesAnteriores.apilar(obtenerLineaActiva().obtenerIndice(), obtenerLineaActiva().obtenerContenido());
            cambiarLineaActiva(versionesPosteriores.obtenerCima().obtenerIndice());
            editarLinea(versionesPosteriores.obtenerCima().obtenerContenido());
            versionesPosteriores.reordenarCima();
        }else{
            System.out.println("No hay versiones posteriores");
        }
    }

    public int obtenerNumeroLineas(){
        return this.nLineas;
    }
}
