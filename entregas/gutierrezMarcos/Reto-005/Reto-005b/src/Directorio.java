public class Directorio {
    private int nArchivos;

    public Directorio(){
        nArchivos = 0;
    }

    public int numeroArchivos(){
        return nArchivos;
    }

    private void cambiarNumArchivos(int nArchivos){
        this.nArchivos = nArchivos;
    }
}
