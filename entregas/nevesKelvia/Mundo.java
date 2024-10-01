package entregas.nevesKelvia;

import java.util.Scanner;

class Mundo {
    private CentroComercial fila;
    private int tiempoTotal;

    public Mundo(int tiempoTotal) {
        fila = new CentroComercial();
        this.tiempoTotal = tiempoTotal;
    }

    public void simular() {
        boolean centroAbierto = true;
        int minutoActual = 0;
        do {
            minutoActual++;
            centroAbierto = minutoActual <= this.tiempoTotal;
            
            if (llegaUnaPersona()) {
                Persona persona = new Persona();
                fila.recibe(persona);
            }

            if (personaAbandona()) {
                fila.abandonaFila();
            }

            if (colarseLicito()) {
                Persona persona = new Persona();
                fila.colarseLicito(persona);
            }

            if (colarseIlicito()) {
                Persona persona = new Persona();
                fila.colarseIlicito(persona);
            }

            fila.atenderPersona();

            fila.verEstado(minutoActual);

            new Scanner(System.in).nextLine();

        } while (centroAbierto);
    }

    private boolean llegaUnaPersona() {
        return Math.random() <= 0.4;
    }

    private boolean personaAbandona() {
        return Math.random() <= 0.2;
    }

    private boolean colarseLicito() {
        return Math.random() <= 0.1;
    }

    private boolean colarseIlicito() {
        return Math.random() <= 0.05;
    }

    public static void main(String[] args) {
        final int TIEMPO_TOTAL = 60;
        new Mundo(TIEMPO_TOTAL).simular();
    }
}
