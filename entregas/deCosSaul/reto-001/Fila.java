public class Fila{

    private Persona[] fila;

    public Fila(int LONGITUD){
        fila = new Persona[LONGITUD];
    }

    public void llegaPersona(int posicion){
        fila[posicion] = new Persona();
    }

    public void pasaACaja(){
        System.out.println("=".repeat(30));
        mostrarFila();
        System.out.println("\nLa primera persona de la fila pasa a la caja con [" + fila[0].items + "] items");
        avanzarFila(1);
        mostrarFila();
        System.out.println();
        System.out.println("=".repeat(30));
    }

    public void clienteAburrido(){
        int posicionAburrido = (int) (Math.random() * 9 + 1);
        fila[posicionAburrido] = null;
        String mensaje = "El cliente en la posicion " + (posicionAburrido + 1) + " se ha aburrido y se ha marchado";
        if (calculoProbabilidad(50)){
            llegaPersona(posicionAburrido);
            mensaje += ", en su posicion se ha colado ilicitamente un clietne con " + fila[posicionAburrido].items + " items";
            System.out.println(mensaje);
            mostrarFila();
        } else{
            System.out.println(mensaje);
            avanzarFila(posicionAburrido + 1);
            mostrarFila();
        }
    }

    public void avanzarFila(int posicion){
        for (int i = posicion; i < fila.length; i++){
            fila[i - 1] = fila[i];
        }
        fila[fila.length - 1] = null;
    }

    public void clienteSeCuela(int itemsTrae) {
        System.out.println("\n" + "=".repeat(30));
        int posicion;
        do{
            posicion = (int) (Math.random() * 9 + 1);
        } while (fila[posicion] == null);
            fila[posicion].recibe(itemsTrae);
            System.out.println("Un cliente se ha colado licitamente, dandole al cliente en la posicion " + (posicion + 1) + " sus " + itemsTrae + " items");
            mostrarFila();
            System.out.println("\n" + "=".repeat(30));
    }

    private void mostrarFila() {
        for (int i = 0; i < fila.length; i++){
            if (fila[i] == null){
                System.out.print("[],");
            } else{
                fila[i].mostrar();
            }
        }
    }

    static boolean calculoProbabilidad(int probabilidad) {
        if (numeroAleatorio(0, 100) < probabilidad){
            return true;
        } else {
            return false;
        }
    }
    static int numeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + minimo);
    }
}