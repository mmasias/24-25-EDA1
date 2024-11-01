public class ColaReproduccion {

        Cancion[] cola ;
        int size ;

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


}
