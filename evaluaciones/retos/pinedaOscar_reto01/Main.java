package evaluaciones.retos.pinedaOscar_reto01;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int TIEMPO_TOTAL = 120;
        final int CAPACIDAD_COLA = 10;
        int tiempo = 0;
        Random rand = new Random();

        ArrayList<Cola> colas = new ArrayList<>();
        Cola colaActual = new Cola("Cola1", CAPACIDAD_COLA);
        colas.add(colaActual);

        while (tiempo < TIEMPO_TOTAL) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Minuto: " + tiempo);

            int evento = rand.nextInt(6) + 1; 

            switch (evento) {
                case 1:
                    System.out.println("Evento: Una persona se une a la cola.");
                    Persona nuevaPersona = new Persona();
                    colaActual.agregarPersona(nuevaPersona);
                    break;
                case 2:
                    System.out.println("Evento: Persona en el frente es atendida.");
                    if (!colaActual.estaVacia()) {
                        colaActual.removerPersona();
                    } else {
                        System.out.println("La cola está vacía, nadie para atender.");
                    }
                    break;
                case 3:
                    System.out.println("Evento: Una persona se aburre y se va.");
                    int tamanoCola = colaActual.getTamano();
                    if (tamanoCola > 0) {
                        int posicion = rand.nextInt(tamanoCola);
                        colaActual.removerPersonaEnPosicion(posicion);
                    } else {
                        System.out.println("La cola está vacía, nadie para remover.");
                    }
                    break;
                case 4:
                    if (!colaActual.estaVacia()) {
                        System.out.println("Evento: Alguien trae cosas a una persona en la cola.");
                    } else {
                        System.out.println("No hay nadie en la cola para que le traigan cosas.");
                    }
                    break;
                case 5:
                    System.out.println("Evento: Una persona se une a la cola lícitamente.");
                    Persona personaLegitima = new Persona();
                    colaActual.agregarPersona(personaLegitima);
                    break;
                case 6:
                    System.out.println("Evento: Una persona se cuela en la cola ilícitamente.");
                    int posicionColarse;
                    if (colaActual.getTamano() > 0) {
                        posicionColarse = rand.nextInt(colaActual.getTamano());
                    } else {
                        posicionColarse = 0;
                    }
                    Persona personaIlicita = new Persona();
                    colaActual.agregarPersonaEnPosicion(personaIlicita, posicionColarse);
                    break;
                default:
                    break;
            }

            if (colaActual.estaLlena()) {
                System.out.println("Anuncio del centro comercial:");
                System.out.println("\"Pasen por esta caja en orden de fila...\"");

                ArrayList<Persona> ultimasCincoPersonas = colaActual.obtenerUltimasPersonas(5);
                colaActual.removerUltimasPersonas(5);

                String nuevoNombreCola = "Cola" + (colas.size() + 1);
                Cola nuevaCola = new Cola(nuevoNombreCola, CAPACIDAD_COLA);
                colas.add(nuevaCola);

                for (Persona p : ultimasCincoPersonas) {
                    nuevaCola.agregarPersona(p);
                }

                colaActual = nuevaCola;
            }

            colaActual.imprimirCola();

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

