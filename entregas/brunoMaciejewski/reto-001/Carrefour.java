class Carrefour{
    public static void main(String[] args) {
        Fila fila=new Fila();
        for(int i = 0; i < 8;i++){
            fila.añadirCliente();
        }
        fila.atenderPrimero();
        fila.clienteSeVa(fila.seleccionarCliente());
        fila.seleccionarCliente().añadirItems();
        Cliente cliente=new Cliente();
        cliente.colarse(fila);
        Fila fila2=new Fila("Pasen por esta caja en orden de fila",fila);
    }
}