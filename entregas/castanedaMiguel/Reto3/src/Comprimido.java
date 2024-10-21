public class Comprimido {

    ComprimidoList Comprimido;

    private int number;
    private String cadena;

    private Comprimido next;

    public Comprimido(String cadena){
        this.setCadena(cadena);
    }

    public Comprimido(int number, String cadena){
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
    public Comprimido getNext() {
        return next;
    }

    public void setNext(Comprimido next) {
        this.next = next;
    }





}
