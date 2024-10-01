package entregas.nevesKelvia;

class CentroComercial {
    private Persona[] fila;
    private int ultimo;

    public CentroComercial() {
        fila = new Persona[100];
        ultimo = 0;
    }

    public void recibe(Persona persona) {
        if (ultimo < fila.length) {
            fila[ultimo] = persona;
            ultimo++;
            System.out.println("Ha llegado una nueva persona a la fila.");
        } else {
            System.out.println("La fila está llena.");
        }

        if (ultimo > 10) {
            System.out.println("¡Pasen por esta caja en orden de fila! Hay muchas personas en la fila.");
        }
    }
   
    public void atenderPersona() {
        if (ultimo > 0) {
            System.out.println("La primera persona en la fila ha sido atendida y se va.");
            moverFila();
        } else {
            System.out.println("No hay personas en la fila para atender.");
        }
    }

    public void abandonaFila() {
        if (ultimo > 0) {
            int posicion = (int) (Math.random() * ultimo);
            System.out.println("Una persona en la posición " + (posicion + 1) + " se ha aburrido y se ha ido.");
            for (int i = posicion; i < ultimo - 1; i++) {
                fila[i] = fila[i + 1];
            }
            fila[ultimo - 1] = null;
            ultimo--;
        } else {
            System.out.println("No hay personas en la fila para abandonar.");
        }
    }
  
    private void moverFila() {
        for (int i = 0; i < ultimo - 1; i++) {
            fila[i] = fila[i + 1];
        }
        fila[ultimo - 1] = null;
        ultimo--;
    }

    public void verEstado(int minutoActual) {
        System.out.println("Minuto actual: " + minutoActual);
        System.out.println(ultimo + " personas en la fila.");
    }

    public void colarseLicito(Persona persona) {
        if (ultimo < fila.length) {
            
            for (int i = ultimo; i > 0; i--) {
                fila[i] = fila[i - 1];
            }
            fila[0] = persona;
            ultimo++;
            System.out.println("Una persona se ha colado lícitamente en la primera posición.");
        } else {
            System.out.println("La fila está llena.");
        }
    }

    public void colarseIlicito(Persona persona) {
        if (ultimo < fila.length) {
            int posicion = (int) (Math.random() * ultimo);  
            for (int i = ultimo; i > posicion; i--) {
                fila[i] = fila[i - 1];
            }
            fila[posicion] = persona;
            ultimo++;
            System.out.println("Una persona se ha colado ilícitamente en la posición " + (posicion + 1) + ".");
        } else {
            System.out.println("La fila está llena.");
        }
    }
}



