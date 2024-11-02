public class Biblioteca {


    ColaReproduccion[] conjuntoColas;
    int size;

    ColaReproduccion favoritas;

    public Biblioteca(){
        conjuntoColas=null;
        size=0;
    }


    public void nuevaCola(ColaReproduccion newCola){
        size ++;
        if(size== conjuntoColas.length){
            ColaReproduccion[] nuevoConjunto=new ColaReproduccion[conjuntoColas.length+10];
            for(int i=0;i<conjuntoColas.length;i++){
                nuevoConjunto[i]=conjuntoColas[i];
            }
            conjuntoColas=nuevoConjunto;
        }
        conjuntoColas[size]=newCola;
        size++;
    }
    public void nuevaFavorita(Cancion cancion){
        cancion.cambiarFavorita();
        favoritas.añadir(cancion);
    }

    public void quitarFavorita(int cancion){
        favoritas.quitar(cancion);
    }


    public void visualizar(){
        int n=1;
        for(int i=0;i<size;i++) {
            System.out.println(n+". "+conjuntoColas[i].getNombre() );
            n++;
        }

    }





}
