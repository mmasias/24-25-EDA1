public class DiccionarioList {

    Diccionario first;

    public void insertEnd(String value) {
        Diccionario newDiccionario = new Diccionario(1,value);
        if (this.first == null)
            this.first = newDiccionario;
        else {
            Diccionario iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newDiccionario);
        }
    }

    public void insertFront(String value) {
        Diccionario n = new Diccionario(1,value);
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
        Diccionario diccionario=this.first;
        while(diccionario!=null) {
            if (diccionario.getCadena().equals(cadena)) {
                return true;
            }
            diccionario=diccionario.getNext();

        }
        return false;
    }

    public int searchNumber(String cadena){
        if(this.first==null){
            return 0;
        }
        Diccionario diccionario=this.first;
        while(diccionario!=null) {
            if (diccionario.getCadena().equals(cadena)) {
                return diccionario.getNumber();
            }
            diccionario=diccionario.getNext();

        }
        return 0;
    }

    public void show(){
        if(this.first==null){
            System.out.println("El diccionario está vacío");
        }
        Diccionario diccionario=this.first;
        System.out.println("El resultado comprimido es:");
        while(diccionario!=null){
            System.out.println(diccionario.getNumber()+":"+diccionario.getCadena());
            diccionario=diccionario.getNext();
        }



    }



}
