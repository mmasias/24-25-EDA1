package entregas.fondoAlejandro.reto001;

class Main {
    public static void main(String[] args){
        Fila fila1 = new Fila(6);

        fila1.abrirFila();
        fila1.llegaCliente();
        fila1.llegaCliente();
        fila1.colarseLicito(1);
        fila1.llegaCliente();
        fila1.clienteSeAburre(3);
        fila1.atenderCliente();
        fila1.llegaCliente();
        fila1.atenderCliente();
        fila1.colarseIlicito(1);
        fila1.clienteSeAburre(1);
        fila1.llegaCliente();
        fila1.atenderCliente();
        fila1.colarseIlicito(2);
        fila1.atenderCliente();
        fila1.atenderCliente();
        fila1.clienteRecibeProductos(0);
        fila1.atenderCliente();
    }
}