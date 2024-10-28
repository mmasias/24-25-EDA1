package reto004;

public class Canciones {
    private String cancion;
    private Canciones siguiente;
    private Canciones anterior;


    public Canciones(String cancion){
        this.cancion = cancion;
        this.siguiente = null;
        this.anterior = null;
    }


    public String getCancion() {
        return cancion;
    }


    public void setCancion(String cancion) {
        this.cancion = cancion;
    }


    public Canciones getSiguiente() {
        return siguiente;
    }


    public void setSiguiente(Canciones siguiente) {
        this.siguiente = siguiente;
    }


    public Canciones getAnterior() {
        return anterior;
    }


    public void setAnterior(Canciones anterior) {
        this.anterior = anterior;
    }
    

    }
    

