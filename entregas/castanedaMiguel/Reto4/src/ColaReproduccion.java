import java.util.Random;

public class ColaReproduccion {

        Cancion[] cola ;
        int size ;
        int cancionActual;


       

        public ColaReproduccion (){
            size=0;
            cola=null;
        }

        public ColaReproduccion(Cancion[] newCola){
            cola=newCola;
            size=cola.length;
        }




        public boolean hayCancion(int posicion){
            if(size<posicion||cola[posicion]==null){
                return false;
            }
            return true;
        }




    boolean shuffle=false;
    boolean repeat=false;

    public void reproducirCancion(int cancion){
        System.out.println("▶ Reproduciendo: "+ cola[cancion].toString());

    }

    public void cancionAnterior(){
        //mirando en el historial, por supuesto.
        intentoRetroceso();
        reproducirCancion(cancionActual);

    }
    public void siguienteCancion(){
        Random r=new Random();
        int i=r.nextInt(size);
        if(repeat){
            reproducirCancion(cancionActual);
        }else{
            if(shuffle) {
                cancionActual=i;
                reproducirCancion(cancionActual);
            }else{
                intentoAvance();
                reproducirCancion(cancionActual);
            }
        }
    }
    public void intentoAvance(){
        if(cancionActual!=size){
            cancionActual=cancionActual+1;
        }
    }

    public void intentoRetroceso(){
        if(cancionActual!=0){
            cancionActual=cancionActual-1;
        }
    }
    public void añadir(Cancion cancion){
        if(size== cola.length){
            Cancion[] nuevaCola=new Cancion[cola.length+10];
            for(int i=0;i<cola.length;i++){
                nuevaCola[i]=cola[i];
            }
            cola=nuevaCola;
        }
        cola[size]=cancion;
        size++;
    }


}
