package Reto004;


public class Nodo {
   Cancion cancion;
   Nodo anterior; 
   Nodo siguiente;

   public Nodo(Cancion cancion) {
       this.cancion = cancion;
       this.anterior = null;
       this.siguiente = null;
   }

   
    
}
