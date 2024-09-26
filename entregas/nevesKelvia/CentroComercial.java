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
}
