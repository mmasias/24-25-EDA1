public class Diccionario {
    
    private int number;
    private String cadena;
    
    private Diccionario next;

    public Diccionario(String cadena){
        this.setCadena(cadena);
    }

    public Diccionario(int number, String cadena){
        this.setNumber(number);
        this.setCadena(cadena);
    }


    public int getNumber() {
        return this.number;
    }

    public void setNumber(int newValue) {
        this.number = newValue;
    }


    public String getCadena() {
        return this.cadena;
    }

    public void setCadena(String NewCadena) {
        this.cadena= NewCadena;
    }
    public Diccionario getNext() {
        return next;
    }

    public void setNext(Diccionario next) {
        this.next = next;
        next.setNumber(this.number+1);
    }
    
    


}
