package entregas.lopezMartin.reto_004;

public class Reproductor {
    private ListaCanciones cola;
    private ListaCanciones historial;
    private Cancion cancionActual;
    private boolean repetir;
    private boolean aleatorio;

    public Reproductor() { 
        this.cola = new ListaCanciones();
        this.historial = new ListaCanciones();      
        this.cancionActual = null;
        this.repetir = false;
        this.aleatorio = false;
    }

    public Cancion getCancionActual(){
        return this.cancionActual;
    }

    public void reproducirCancion(Cancion cancion) {
        cancionActual = cancion;
        System.out.println("Canción actual: " + cancion.toString());
        historial.insertUltimo(cancion);
        cola.insertPrimero(cancion);
    }

    public void siguienteCancion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'siguienteCancion'");
    }

    public void cancionAnterior() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancionAnterior'");
    }

    public void verCola() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verCola'");
    }

    public void verHistorial() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verHistorial'");
    }

    public void activarDesactivarAleatorio() {
        if (aleatorio) {
            aleatorio = false;
            System.out.println("Aleatorio desactivado");
        }else{
            aleatorio = true;
            System.out.println("Aleatorio activado");
        }
    }

    public void activarDesactivarRepeticion() {
        if (repetir) {
            repetir = false;
            System.out.println("Repetición desactivada");
        }else{
            repetir = true;
            System.out.println("Repetición activado");
        }
    }

    
}