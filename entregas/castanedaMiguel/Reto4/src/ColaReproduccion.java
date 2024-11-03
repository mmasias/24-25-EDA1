import java.util.Random;
import java.util.Scanner;

public class ColaReproduccion {

        Cancion[] cola ;
        int size ;
        int cancionActual;

        String nombre;
        boolean shuffle=false;
        boolean repeat=false;

       

        public ColaReproduccion (String newNombre){
            size=0;
            cola=null;
            nombre=newNombre;
            cancionActual=0;
        }

        public ColaReproduccion(String newNombre ,Cancion[] newCola){
            cola=newCola;
            size=cola.length;
            nombre=newNombre;
            cancionActual=0;
        }

        public String getNombre(){
            return nombre;
        }

        public Cancion devolverCancion(int n){
                return cola[n];
        }

        public void changeShuffle(){
            shuffle= !shuffle;
            System.out.println("Estado de shuffle: "+shuffle);
        }

        public void changeRepeat(){
            repeat=!repeat;
            System.out.println("Estado de repeat: "+repeat);
        }



        public boolean hayCancion(int posicion){
            if(size<posicion||cola[posicion]==null){
                return false;
            }
            return true;
        }






    public String reproducirCancion(int cancion){
        return"▶ Reproduciendo: "+ cola[cancion].toString();

    }

    public void cancionAnterior(){
        //mirando en el historial, por supuesto.
        intentoRetroceso();
        reproducirCancion(cancionActual);

    }
    public void cancionSiguiente(){
        Random r=new Random();
        int i=r.nextInt(size);
        if(repeat){
            //reproducirCancion(cancionActual);
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

    public String mostrarCancion(){
        return cola[cancionActual].toString();
    }

    public String mostrarCancion(int i){
        if(i<size) {
            return cola[i].toString();
        }
        return "Espacio vacío";

    }

    public void mostrarCola(){
        int i=cancionActual;
        while(i<size){
            System.out.println(i+". "+mostrarCancion(i));
            i++;
        }
    }

    public void mostrarRestoCola(){
        int i=cancionActual;
        System.out.println("▶ "+ mostrarCancion(i));
        i++;
        while(i<size){
            mostrarCancion(i);
            i++;
        }


    }

    public void elegirCancion(){
            Scanner s=new Scanner(System.in);
            int i=-1;
           mostrarCola();
           System.out.println("Elige una cancion");
           while(i<0||i>=size) {
               i = s.nextInt();
               cancionActual = i;
           }




    }


}
