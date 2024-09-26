package evaluaciones.retos.pinedaOscar_reto01;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int TIEMPO_TOTAL = 120;
        final int CAPACIDAD_Fila = 10;
        int tiempo = 0;
        Random rand = new Random();

        ArrayList<Fila> filas = new ArrayList<>();
        Fila filaActual = new Fila("Fila1", CAPACIDAD_Fila);
        filas.add(filaActual);

        while (tiempo < TIEMPO_TOTAL) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Minuto: " + tiempo);

            int evento = rand.nextInt(6) + 1; 

            switch (evento) {
                case 1:
                    System.out.println("Evento: Una persona se une a la fila.");
                    Persona nuevaPersona = new Persona();
                    filaActual.agregarPersona(nuevaPersona);
                    break;
                case 2:
                    System.out.println("Evento: Persona en el frente es atendida.");
                    if (!filaActual.estaVacia()) {
                        filaActual.removerPersona();
                    } else {
                        System.out.println("La fila está vacía, nadie para atender.");
                    }
                    break;
                case 3:
                    System.out.println("Evento: Una persona se aburre y se va.");
                    int tamanoCola = filaActual.getTamano();
                    if (tamanoCola > 0) {
                        int posicion = rand.nextInt(tamanoCola);
                        filaActual.removerPersonaEnPosicion(posicion);
                    } else {
                        System.out.println("La fila está vacía, nadie para remover.");
                    }
                    break;
                case 4:
                    if (!filaActual.estaVacia()) {
                        System.out.println("Evento: Alguien trae cosas a una persona en la cola.");
                    } else {
                        System.out.println("No hay nadie en la cola para que le traigan cosas.");
                    }
                    break;
                case 5:
                    System.out.println("Evento: Una persona se une a la cola lícitamente.");
                    Persona personaLegitima = new Persona();
                    filaActual.agregarPersona(personaLegitima);
                    break;
                case 6:
                    System.out.println("Evento: Una persona se cuela en la cola ilícitamente.");
                    int posicionColarse;
                    if (filaActual.getTamano() > 0) {
                        posicionColarse = rand.nextInt(filaActual.getTamano());
                    } else {
                        posicionColarse = 0;
                    }
                    Persona personaIlicita = new Persona();
                    filaActual.agregarPersonaEnPosicion(personaIlicita, posicionColarse);
                    break;
                default:
                    break;
            }

            if (filaActual.estaLlena()) {
                System.out.println("Anuncio del centro comercial:");
                System.out.println("\"Pasen por esta caja en orden de fila...\"");

                ArrayList<Persona> ultimasCincoPersonas = filaActual.obtenerUltimasPersonas(5);
                filaActual.removerUltimasPersonas(5);

                String nuevoNombreCola = "Fila" + (filas.size() + 1);
                Fila nuevaFila = new Fila(nuevoNombreCola, CAPACIDAD_Fila);
                filas.add(nuevaFila);

                for (Persona p : ultimasCincoPersonas) {
                    nuevaFila.agregarPersona(p);
                }

                filaActual = nuevaFila;
            }

            filaActual.imprimirfila();

            tiempo++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("La simulación ha terminado.");
    }
}

