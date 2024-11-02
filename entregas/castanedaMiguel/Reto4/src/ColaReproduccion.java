import java.util.Random;

public class ColaReproduccion {

        Cancion[] cola ;
        int size ;
        int cancionActual;

        String nombre;


       

        public ColaReproduccion (String newNombre){
            size=0;
            cola=null;
            nombre=newNombre;
        }

        public ColaReproduccion(String newNombre ,Cancion[] newCola){
            cola=newCola;
            size=cola.length;
            nombre=newNombre;
        }

        public String getNombre(){
            return nombre;
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


    public void quitar(int cancion){
        int i=cancion;
        while(i< size-1){
            cola[i]=cola[i+1];
            i++;
        }
        size--;
    }


}
