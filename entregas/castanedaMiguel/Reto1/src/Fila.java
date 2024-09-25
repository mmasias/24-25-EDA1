public class Fila {

    public final int MAX=30;
    public int separaFilas;
    public int posición;
    public Persona[] fila;

    public Fila(){
        this.fila=new Persona[MAX];
        this.posición=0;
    }

    public void llegaPersona(Persona p){
        this.fila[this.posición]=p;
        this.posición++;

    }


}
