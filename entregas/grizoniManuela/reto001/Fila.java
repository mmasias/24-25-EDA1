package entregas.grizoniManuela.reto001;

import java.util.Random;

public class Fila {
    private String[] fila;
    private int tamanoActual;
    private int capacidad;

    public Fila(int capacidad){
        this.capacidad = capacidad;
        this.fila = new String[capacidad];
        this.tamanoActual = 0;  

    }

    public void abrirFila(){
        for (int i = 0; i < capacidad; i++) {
            fila[i] = "[]"; 
        }
        System.out.println("Se ha abierto una fila");
        mostrarFila();
    }

    public void llegaPersona(){
        if (tamanoActual < capacidad) {
            fila[tamanoActual] = "[X]"; 
            tamanoActual++;
            System.out.println("Alguien ha llegado a la fila.");
            mostrarFila();
        } else {
            System.out.println("La fila esta llena.");
        }
    }

    public void atenderPersona(){
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

    public void recibeCosas(int posicion){
        if (posicion < tamanoActual && posicion >= 0){
            System.out.println("Le han traido cosas a la persona en la posición: " + (posicion + 1));
            mostrarFila();
        }
    }

    public void colarseLicito(int posicion){
        if (posicion < tamanoActual && posicion >= 0){
            if (tamanoActual < capacidad) {
                fila[tamanoActual] = "[X]"; 
                tamanoActual++;
                System.out.println("Llega una nueva persona y le dejan pasar.");
                mostrarFila();
            } else {
                System.out.println("La fila esta llena.");
            }
        }
    }

    public void colarseIlicito(){
        Random r = new Random();
        int posicionAleatoria = r.nextInt(10)+1;
        if (posicionAleatoria < tamanoActual && posicionAleatoria >= 0){
            if (tamanoActual < capacidad) {
                fila[tamanoActual] = "[X]"; 
                tamanoActual++;
                System.out.println("Alguien se ha colado");
                mostrarFila();
            } else {
                System.out.println("La fila esta llena.");
            }
        }
    }

    public void mostrarFila(){
        System.out.print("Fila: " );
        for (int i = 0; i < fila.length; i++) {
            System.out.print(fila[i] + " ");
        }
        System.out.println("\n");
    }
    

    public static void main(String[] args){
        Fila fila1 = new Fila(10);

        fila1.abrirFila();

        fila1.llegaPersona();
        fila1.llegaPersona();
        fila1.llegaPersona();

        fila1.personaAburrida(0);

        fila1.llegaPersona();

        fila1.atenderPersona();

        fila1.colarseLicito(1);

        fila1.colarseIlicito();
        fila1.colarseIlicito();


        fila1.recibeCosas(1);

        fila1.llegaPersona();

        fila1.atenderPersona();

    }
}
