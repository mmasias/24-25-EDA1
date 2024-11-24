public class Cliente {

    private int id;

    public Cliente(int id) {
        this.id = id;
    }

    public String mostrarCliente() {
        return "Cliente-" + id;
    }
}