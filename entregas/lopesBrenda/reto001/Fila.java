
public class Fila {
    private String[] fila;
    private int tamanoActual ;
    //private int numeroFila = 1;


    public Fila(int capacidad){
        this.fila = new String[capacidad];
        this.tamanoActual = 0;  
        for (int i = 0; i < capacidad; i++) {
            fila[i] = "[]"; 
        }
        mostrarFila();
    }

    //public void abrirFila(){}

    public void llegaPersona(){
        if (tamanoActual < fila.length) {
            fila[tamanoActual] = "[X]"; 
            tamanoActual++;
            System.out.println("Alguien ha llegado a la fila.");
            mostrarFila();
        } else {
           filaLlena();
        }
    }

    public void atender(){
        if (tamanoActual > 0) {
            System.out.println("La primera persona ha sido atendida.");
            personaSeVa();
        } else {
            System.out.println("No hay nadie en la fila.");
        }
    }

    public void personaAburrida(int posicion){
        if (posicion < tamanoActual && posicion >= 0){
            System.out.println("La persona en la posición: " + (posicion + 1) + " se ha aburrido y se fue de la fila.");
            personaSeVa();
        }
    }

    public void personaSeVa(){
        for (int i = 1; i < tamanoActual; i++) {
            fila[i-1] = fila[i];
        }
        fila[tamanoActual - 1] = "[]"; 
        tamanoActual--;
        mostrarFila();
    }

    public void traer(int posicion){
        if (posicion < tamanoActual && posicion >= 0){
            System.out.println("Le han traido cosas a la persona en la posición: " + (posicion + 1));
            mostrarFila();
        }
    }

    public void colarseLicito(){}

    public void colarseIlicito(){}

    // public void filaLlena(){
    //     System.out.println("Fila llena, pasen por esta caja en orden de fila");
    //     Fila fila2 = new Fila(10);
    //     mostrarFila();
    // }

    public void mostrarFila(){
        //System.out.print("\n" + "Fila " + numeroFila + ": " );
        System.out.print("\n" + "Fila: " );
        for (int i = 0; i < fila.length; i++) {
            System.out.print(fila[i] + " ");
        }
        System.out.println();
    }
    

    public static void main(String[] args){
        Fila fila1 = new Fila(10);

        fila1.llegaPersona();
        fila1.llegaPersona();
        fila1.llegaPersona();



    }
}