public class ListaNodo {
    private Nodo first;
    private int tamaño=0;
    public ListaNodo(Nodo newNodo){

    }
    public ListaNodo(){
        first=null;
    }

    public void insertarPrimerNodo(Nodo newNodo){
        newNodo.setSiguiente(first);
        first=newNodo;
        Nodo actual=first;
        if(tamaño<5){
            tamaño++;
        }else{
            for(int i=0;i<4;i++){
                actual=actual.siguiente;
            }
            actual.siguiente=null;
        }
    }

    public Nodo getNodo(){
        return first;
    }

    public void quitarPrimerNodo(){
        first=first.siguiente; tamaño--;
    }

    public void clear(){first=null;}

}
