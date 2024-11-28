public class Nodo {

    int linea;
    String contenido;
    Nodo siguiente;

    boolean intercambio;

    int lineas[]= {0,0};

    public Nodo (int nuevaLinea, String nuevoContenido){
        setAll(nuevaLinea,nuevoContenido);
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int nuevaLinea){
        linea=nuevaLinea;
    }

    public String getContenido(){
        return contenido;
    }

    public void setContenido(String nuevoContenido){
        contenido=nuevoContenido;
    }

    public void setAll(int nuevaLinea,String nuevoContenido){
        setLinea(nuevaLinea);
        setContenido(nuevoContenido);
    }
    public void setSiguiente(Nodo nuevoNodo){
        siguiente=nuevoNodo;
    }

    public void setLineas(int lineaUno,int lineaDos){
        lineas[0]=lineaUno;
        lineas[1]=lineaDos;
        intercambio=true;
    }
}
