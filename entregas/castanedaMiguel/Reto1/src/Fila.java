public class Fila {

    public final int MAX=30;
    public int separaFilas;
    public int posicion;
    public Persona[] fila;

    public Fila(){
        this.fila=new Persona[MAX];
        this.posicion=0;
    }

    public int buscaPersona(Persona p){
        for(int i=0;i<posicion;i++){
            if(this.fila[i]==p){
                return i;
            }
        }
        return -1;
    }

    public boolean existePersona(Persona p){
        if(buscaPersona(p)!=-1){
            return true;
        }
        return false;
    }

    public void llegaPersona(Persona p){
        if(buscaPersona(p)== -1){
            this.fila[this.posicion]=p;
            this.posicion++;
        }
    }

    public void seAtiendePersona(){
        seVaPersona(0);
    }

    public void seVaPersona(int p){
        int i=p;
        while(i<posicion-1){
            this.fila[i]=this.fila[i+1];
            i++;
        }
        this.posicion--;
        this.fila[this.posicion]=null;

    }

    public void seAburrePersona(Persona p){
        seVaPersona(buscaPersona(p));
    }

    public void personaDaCosas (Persona p1, Persona p2){
        p1.darCosas(p2);
    }


}
