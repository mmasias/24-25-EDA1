public class Directorio {

    private Arbol arbol;

    private int estado;

    public Directorio(){
        arbol=null; estado=0;
    }

    public Directorio(Arbol newArbol){
        arbol=newArbol;
        estado=arbol.longitud();
    }





}
