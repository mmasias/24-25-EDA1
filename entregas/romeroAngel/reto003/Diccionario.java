package romeroAngel.reto003;

class Diccionario {
    
    private List diccionario;
    private int indice;

    public Diccionario(){
        this.diccionario = new List();
        this.indice = 1;
        
    }

    public int estaEnDiccionario(String letra) {
        Node encontrado = diccionario.encontrarPrimer(letra); 
        if (encontrado != null) {
            return diccionario.obtenerIndice(encontrado);
        } 

        return -1;
    }

    public void agregar(String letra){
        diccionario.insertEnd(letra);
        indice++;
    }

    public String[] listar() {
        String[] listaDiccionario = new String[diccionario.size()];
        Node iterator = diccionario.getFirst();
        
        int index = 0;
        while (iterator != null) {
            listaDiccionario[index] = (index + 1) + ":" + iterator.getValue(); 
            index++;
            iterator = iterator.getNext(); 
        }
        
        return listaDiccionario; 
    }
}



