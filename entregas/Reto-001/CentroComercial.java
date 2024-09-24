public class CentroComercial {

    private String[][] cajas;
    private int tamañoFila;
    private int[] contadores;

    public CentroComercial(int numCajas, int tamañoFila) {
        this.tamañoFila = tamañoFila;
        cajas = new String[numCajas][tamañoFila];
        contadores = new int[numCajas];
    }

    public void llegaGente(String nombre, int numCaja) {
        if (numCaja <= 0 || numCaja >= cajas.length) {
            System.out.println("Número de caja inválido.");
        }

        if (contadores[numCaja] < tamañoFila) {
            cajas[numCaja][contadores[numCaja]] = nombre;
            contadores[numCaja]++;

        } else {
            System.out.println("La fila de la caja " + numCaja + " está llena. Se abre otra caja.");
            for (int i = 1; i < cajas.length; i++) {
                if (contadores[i] < tamañoFila) {
                    cajas[i][contadores[i]] = nombre;
                    contadores[i]++;

                }
            }
            
        }
    }

    public void mostrarFila() {
        for (int i = 1; i < cajas.length; i++) {
            System.out.print("Caja " + i + ": ");
            for (int j = 0; j < contadores[i]; j++) {
                System.out.print(cajas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void atenderGente(int numCaja) {
        if (numCaja <= 0 || numCaja >= cajas.length) {
            System.out.println("Número de caja inválido.");
            return;
        }

        if (contadores[numCaja] > 0) {
            System.out.println(cajas[numCaja][0] + " está siendo atendido en la caja " + numCaja);
            for (int i = 1; i < contadores[numCaja]; i++) {
                cajas[numCaja][i - 1] = cajas[numCaja][i];
            }
            cajas[numCaja][contadores[numCaja] - 1] = null;
            contadores[numCaja]--;
        } else {
            System.out.println("No hay nadie en la fila de la caja " + numCaja + " para atender.");
        }
    }

    public void irseGente(String nombre, int numCaja) {
        if (numCaja <= 0 || numCaja >= cajas.length) {
            System.out.println("Número de caja inválido.");

        }

        int index = -1;
        for (int i = 0; i < contadores[numCaja]; i++) {
            if (cajas[numCaja][i].equals(nombre)) {
                index = i;

            }
        }

        if (index != -1) {
            System.out.println(nombre + " se ha ido de la fila de la caja " + numCaja);

            for (int i = index + 1; i < contadores[numCaja]; i++) {
                cajas[numCaja][i - 1] = cajas[numCaja][i];
            }
            cajas[numCaja][contadores[numCaja] - 1] = null;
            contadores[numCaja]--;
        } else {
            System.out.println(nombre + " no está en la fila de la caja " + numCaja);
        }
    }

    public void colarseLicitamente(String nombre, int numCaja, int posicion) {
        if (numCaja <= 0 || numCaja >= cajas.length) {
            System.out.println("Número de caja inválido.");
            return;
        }

        if (contadores[numCaja] >= tamañoFila) {
            System.out.println("La fila de la caja " + numCaja + " está llena. No se puede colar.");
            return;
        }

        if (posicion < 1 || posicion > contadores[numCaja]) {
            System.out.println("Posición inválida. No se puede colar.");
            return;
        }

        
        for (int i = contadores[numCaja]; i > posicion; i--) {
            cajas[numCaja][i] = cajas[numCaja][i - 1];
        }

       
        cajas[numCaja][posicion] = nombre;
        contadores[numCaja]++;
        System.out.println(nombre + " se ha colado en la posición " + posicion + " en la caja " + numCaja);
    }

    public static void main(String[] args) {
        CentroComercial cc = new CentroComercial(3, 5);
        cc.llegaGente("Clara", 1);
        cc.llegaGente("Paula", 1);
        cc.llegaGente("Virginia", 1);
        cc.llegaGente("Cecilia", 1);
        cc.mostrarFila();
        cc.atenderGente(1);
        cc.mostrarFila();
        cc.irseGente("Paula", 1);
        cc.llegaGente("Ricardo", 1);
        cc.llegaGente("Pablo", 1);
        cc.llegaGente("Pepe", 1);
        cc.mostrarFila();
        cc.llegaGente("Paco", 1);
        cc.llegaGente("Luis", 2);
        cc.mostrarFila();
        cc.colarseLicitamente("Carlos", 2, 1); 
        
        cc.mostrarFila();

    }

}