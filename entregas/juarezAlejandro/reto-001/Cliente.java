class Cliente {

    private String nombre;
    private int id;
    private int numItems;

    public Cliente(String nombre, int id, int numItems) {
        this.nombre = nombre;
        this.id = id;
        this.numItems = numItems;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public int getNumItems() {
        return numItems;
    }

    public void aumentarItems(int cantidad) {
        this.numItems += cantidad;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ") espera con " + numItems + " ítems";
    }

}
