public class Fila {

    public final int MAX=30;
    public int separaFilas;
    public int posicion;
    public Persona[] fila;

    public Fila(){
        this.fila=new Persona[MAX];
        this.posicion=0;
    }

    public void llegaPersona(Persona p){
        this.fila[this.posicion]=p;
        this.posicion++;

    }

    public void seAtiendePersona(){
        int i=0;
        while(i<posicion-1){
            this.fila[i]=this.fila[i+1];
            i++;
        }
        this.posicion--;
        this.fila[this.posicion]=null;

    }


}
