//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        int timer = 0;
        Fila fila = new Fila();
        Cliente cliente = new Cliente();
        for (timer = 0; timer < 150; timer++) {
            fila.adicionar(cliente);
            fila.remover();
            fila.clienteSeva();
            fila.clientesinbultos();
            fila.clientesecuela();
            fila.moverclientes();
        }
    }





}
