public class ComprimidoList {

    Comprimido first;

    public void insertEnd(int i,String value) {
        Comprimido newComprimido = new Comprimido(i,value);
        if (this.first == null)
            this.first = newComprimido;
        else {
            Comprimido iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newComprimido);
        }
    }

    public void insertFront(String value) {
        Comprimido n = new Comprimido(1,value);
        if (this.first == null)
            this.first = n;
        else {
            n.setNext(this.first);
            this.first = n;
        }
    }


    public boolean search(String cadena){
        if(this.first==null){
            return false;
        }
        Comprimido Comprimido=this.first;
        while(Comprimido!=null) {
            if (Comprimido.getCadena().equals(cadena)) {
                return true;
            }
            Comprimido.getNext();

        }
        return false;
    }

    public void show(){
        String cadenaFinal=" ";
        if(this.first==null){
            System.out.println("El diccionario está vacío");
        }
        Comprimido comprimido=this.first;
        System.out.println("El resultado comprimido es:");
        while(comprimido!=null){
            cadenaFinal=cadenaFinal+"("+comprimido.getNumber()+","+comprimido.getCadena()+")"  ;
            comprimido=comprimido.getNext();
        }


        System.out.println(cadenaFinal);
    }

}
