public class Fila {

    public final int MAX=30;
    public int separaFilas=3;
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

    public void espacioParaPersona(int espacio){
        this.posicion++;
        int p=posicion;
        while(p>espacio){
            this.fila[p]=this.fila[p-1];
            p--;
        }
        this.fila[espacio]=null;
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

    public void colarseLicitamente(Persona p1, Persona p2){
        int espacio=this.buscaPersona(p2);
        espacioParaPersona(espacio+1);

        this.fila[espacio+1]=p1;

    }

    public void colarseIlicitamente(Persona p, int espacio){
        espacioParaPersona(espacio);
        this.fila[espacio]=p;

    }

    public void darAOtraFila(Fila f){
        int s=this.separaFilas;
        int p=this.posicion;
        while(s<p){
            f.llegaPersona(this.fila[s]);
            this.fila[s]=null;
            this.posicion--;
            s++;
        }
    }

    public void mostrarFila(){
        System.out.println("La fila está formada por:");
        for(int i=0;i<posicion;i++) {
            System.out.println("-Persona con " + this.fila[i].cosas + "cosas");
        }
        System.out.println("");
    }


}
