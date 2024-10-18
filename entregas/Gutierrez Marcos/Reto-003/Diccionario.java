public class Diccionario {
    private List secuencias;

    public Diccionario() {
        secuencias = new List();
    }

    public boolean contiene(String string) {
       for(int i = 0; i < secuencias.size(); i++){
        if(string == secuencias.valor()){
            return true;
        }
       }
       return false;
    }

    public void agregar(String valueOf) {
        secuencias.insertEnd(valueOf);
    }

}