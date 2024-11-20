class CentroComercial {
    final static int LONGITUD = 10;
    static Fila fila = new Fila(LONGITUD);
    public static void main(String[] args) {
        for (int i = 0; i<10; i++){
            fila.llegaPersona(i);
            System.out.println();
        }
        fila.pasaACaja();
        fila.clienteAburrido();
        int itemsTrae = (int)(Math.random() * 9 + 1);
        fila.clienteSeCuela(itemsTrae);
    }
}