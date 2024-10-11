class Fila {
    private Persona[] personas;
    private int longitud;
    private int capacidad;

    public Fila(int capacidad) {
        this.capacidad = capacidad;
        this.personas = new Persona[capacidad];
        this.longitud = 0;
        System.out.println("Se ha abierto una fila en el centro comercial.");
    }

    public void entrar(Persona persona) {
        if (longitud < capacidad) {
            personas[longitud] = persona;
            longitud++;
            System.out.println(persona.getNombre() + " se ha unido a la fila.");
        } else {
            System.out.println("La fila está llena. " + persona.getNombre() + " no puede unirse.");
        }
    }

    public Persona salir() {
        if (longitud > 0) {
            Persona atendida = personas[0];
            for (int i = 0; i < longitud - 1; i++) {
                personas[i] = personas[i + 1];
            }
            personas[--longitud] = null;
            System.out.println(atendida.getNombre() + " sale de la fila para que le atiendan.");
            return atendida;
        } else {
            System.out.println("No hay nadie en la fila para atender.");
            return null;
        }
    }

    public void abandonar() {
        int i = (int) (Math.random() * longitud);
        System.out.println(personas[i].getNombre() + " se ha aburrido y se va de la fila.");
        for (int j = i; j < longitud - 1; j++) {
            personas[j] = personas[j + 1];
        }
        personas[--longitud] = null;
        return;
    }

    public Persona abandonar(int posicion) {
        Persona quienSale;
        quienSale = personas[posicion];
        for (int j = posicion; j < longitud - 1; j++) {
            personas[j] = personas[j + 1];
        }
        personas[--longitud] = null;
        return quienSale;
    }

    public void traerCosas(String nombre) {
        for (int i = 0; i < longitud; i++) {
            if (personas[i].getNombre().equals(nombre)) {
                System.out.println("Alguien trajo cosas para " + nombre);
                return;
            }
        }
        System.out.println("Traian cosas para " + nombre + ", pero no estaba en la fila!!!");
    }

    public void colarseIlicitamente(Persona persona, int posicion) {
        if (posicion < 0 || posicion > longitud) {
            System.out.println("Posición inválida para colarse.");
            return;
        }
        if (longitud < capacidad) {
            for (int i = longitud; i > posicion; i--) {
                personas[i] = personas[i - 1];
            }
            personas[posicion] = persona;
            longitud++;
            System.out.println(persona.getNombre() + " se ha colado en la posición " + (posicion + 1) + ".");
        } else {
            System.out.println("La fila está llena. " + persona.getNombre() + " no puede colarse.");
        }
    }

    public void colarseLicitamente(Persona persona, int posicion) {
        colarseIlicitamente(persona, posicion);
        System.out.println("(Pero esta vez era lícito)");
    }

    public void mostrar() {
        System.out.print("+-- Estado actual de la fila:\n");
        for (int i = 0; i < longitud; i++) {
            System.out.print("| " + (i + 1) + ". " + personas[i].getNombre() + " / ");
        }
        System.out.println("\n+-- Total de personas en la fila: " + longitud);
    }

    public Fila dividir() {
        Fila nuevaFila = new Fila(capacidad);
        int mitad = (longitud + 1) / 2;
        int mover = longitud - mitad;

        for (int i = 0; i < mover; i++) {
            nuevaFila.entrar(this.abandonar(mitad));
        }
        return nuevaFila;
    }
}