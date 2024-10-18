class CentroComercial {

    private String[][] cola;
    private int[] ultimo;

    public CentroComercial(int cajas, int tamañoCola) {
        cola = new String[cajas][tamañoCola];
        ultimo = new int[cajas];
    }

    public void llegaUnCliente(int caja, String cliente) {
        if (caja < 0 || caja >= cola.length) {
            System.out.println("invalido");
            return;
        }

        if (ultimo[caja] == cola[caja].length) {
            System.out.println("Está llena la caja " + caja);
            return;
        }

        System.out.println("Llega " + cliente + " en la caja " + caja);
        cola[caja][ultimo[caja]] = cliente;
        ultimo[caja]++;
    }

    public void verEstado() {
        for (int i = 0; i < cola.length; i++) {
            System.out.print("Caja " + i + ": ");
            for (int j = 0; j < cola[i].length; j++) {
                if (cola[i][j] != null) {
                    System.out.print(cola[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void atenderCliente(int caja) {
        if (caja < 0 || caja >= cola.length) {
            System.out.println("invalido");
            return;
        }

        if (ultimo[caja] == 0) {
            System.out.println("No hay clientes en caja " + caja);
            return;
        }

        System.out.println(cola[caja][0] + " atendido en caja " + caja);
        for (int i = 1; i < cola[caja].length; i++) {
            cola[caja][i - 1] = cola[caja][i];
        }
        ultimo[caja]--;
    }

    public void abandonaCola(int caja, String cliente) {
        if (caja < 0 || caja >= cola.length) {
            System.out.println("invalido");
            return;
        }

        if (ultimo[caja] == 0) {
            System.out.println("No hay clientes en caja " + caja);
            return;
        }
        int posicion = -1;
        for (int i = 0; i < cola[caja].length; i++) {
            if (cliente == cola[caja][i]) {
                posicion = i;
            }
        }
        if (posicion == -1) {
            System.out.println("No se encuentra a " + cliente + " en la caja " + caja);
        }

        System.out.println(cola[caja][posicion] + " se va de la caja " + caja);
        for (int i = posicion + 1; i < cola[caja].length; i++) {
            cola[caja][i - 1] = cola[caja][i];
        }
        ultimo[caja]--;
    }

    public void llegaAcompañante(int caja, String cliente, String acompañante) {
        if (caja < 0 || caja >= cola.length) {
            System.out.println("invalido");
            return;
        }

        if (ultimo[caja] == cola[caja].length) {
            System.out.println("Esta llena la caja " + caja);
            return;
        }

        int posicion = -1;
        for (int i = 0; i < cola[caja].length; i++) {
            if (cola[caja][i] == cliente) {
                posicion = i;
            }
        }
        if (posicion == -1) {
            System.out.println("No se encuentra a " + cliente + " en la caja " + caja);
            return;
        }

        System.out.println("Llega " + acompañante + " acompañando a " + cliente + " en la caja " + caja);

        for (int i = ultimo[caja]; i > posicion; i--) {
            cola[caja][i] = cola[caja][i - 1];
        }
        cola[caja][posicion + 1] = acompañante;
        ultimo[caja]++;
    }

    public void seCuelaIlicitamente(int caja, String cliente, int posicion) {
        if (caja < 0 || caja >= cola.length) {
            System.out.println("invalido");
            return;
        }

        if (ultimo[caja] == cola[caja].length) {
            System.out.println("Esta llena la caja " + caja);
            return;
        }

        if (posicion < 0 || posicion >= cola[caja].length) {
            System.out.println("Posición inválida");
            return;
        }

        System.out.println("Llega " + cliente + " y se cuela en la posición " + posicion + " en la caja " + caja);

        for (int i = ultimo[caja]; i > posicion; i--) {
            cola[caja][i] = cola[caja][i - 1];
        }
        cola[caja][posicion] = cliente;
        ultimo[caja]++;
    }

    public void seCuelaLicitamente(int caja, String cliente, int posicion) {
        if (caja < 0 || caja >= cola.length) {
            System.out.println("invalido");
            return;
        }

        if (ultimo[caja] == cola[caja].length) {
            System.out.println("Esta llena la caja " + caja);
            return;
        }

        if (posicion < 0 || posicion >= cola[caja].length) {
            System.out.println("Posición inválida");
            return;
        }

        System.out.println("Llega " + cliente + " y se cuela en la posición " + posicion + " en la caja " + caja);

        for (int i = ultimo[caja]; i > posicion; i--) {
            cola[caja][i] = cola[caja][i - 1];
        }
        cola[caja][posicion] = cliente;
        ultimo[caja]++;
    }

    public static void main(String[] args) {

        CentroComercial carrefour = new CentroComercial(2, 14);
        carrefour.llegaUnCliente(1, "juan");
        carrefour.verEstado();
        carrefour.atenderCliente(1);
        carrefour.llegaUnCliente(0, "jesús");
        carrefour.llegaUnCliente(1, "jesús");
        carrefour.llegaUnCliente(1, "josé");
        carrefour.llegaUnCliente(1, "javier");
        carrefour.llegaUnCliente(1, "jaime");
        carrefour.llegaUnCliente(1, "jimena");
        carrefour.verEstado();
        carrefour.abandonaCola(1, "jaime");
        carrefour.verEstado();
        carrefour.llegaAcompañante(1, "josé", "felipe");
        carrefour.verEstado();
        carrefour.seCuelaIlicitamente(1, "julio", 2);
        carrefour.verEstado();
        carrefour.seCuelaLicitamente(1, "adrian", 2);
        carrefour.verEstado();
        carrefour.llegaUnCliente(1, "julio");
        carrefour.llegaUnCliente(1, "adrian");
    }

}
