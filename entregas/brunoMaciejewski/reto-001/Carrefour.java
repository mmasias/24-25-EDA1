class Carrefour{
    public static void main(String[] args) {
        Fila fila=new Fila();
        for(int i = 0; i < 8;i++){
            fila.añadirCliente();
            fila.imprimir();
        }
        fila.atenderPrimero();
        fila.imprimir();
        fila.clienteSeVa(fila.seleccionarCliente());
        fila.imprimir();
        fila.seleccionarCliente().añadirItems();
        fila.imprimir();
        Cliente cliente=new Cliente();
        cliente.colarse(fila);
        fila.imprimir();
        Fila fila2=new Fila("Pasen por esta caja en orden de fila",fila);
        fila.imprimir();
        fila2.imprimir();
    }
}