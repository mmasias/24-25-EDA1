public class Cliente{

    private int numItems;

    public Cliente(int numItems){
        this.numItems = numItems;
    }

    public int getNumItems(){
        return numItems;
    }

    public void aumentarItems(int cantidad) {
        if (cantidad > 0) {
            this.numItems += cantidad;
        }
    }

    @Override
    public String toString() {
        return "Cliente con " + numItems + " ítems.";
    }
}



