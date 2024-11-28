public class Arbol {
    Nodo nodo;

    Arbol[] arboles;

    public Arbol(){
        nodo=null;
        arboles=null;
    }

    public Arbol(Arbol newArbol){
        nodo=newArbol.getNodo();
        arboles=new Arbol[newArbol.getSize()];

        for(int i=0;0<arboles.length;i++){
            arboles[i]=newArbol.getArbol(i);

        }
    }

    public void setNodo(Nodo newNodo){
        nodo=newNodo;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public int getSize(){
        return arboles.length;
    }

    public Arbol getArbol(int i){
        return arboles[i];
    }

    public int longitud(){
        int longitud=0;
        for(int i=0;i< arboles.length;i++){
            longitud=arboles[i].longitud();
        }
        return longitud;
    }



}
