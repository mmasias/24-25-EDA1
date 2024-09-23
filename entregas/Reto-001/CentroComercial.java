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
            System.out.println("Todas las cajas están llenas. No se puede agregar a " + nombre);
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

    public static void main(String[] args) {
        CentroComercial cc = new CentroComercial(3, 5);
        cc.llegaGente("Clara", 1);
        cc.llegaGente("Paula", 1);
        cc.llegaGente("Virginia", 1);
        cc.llegaGente("Cecilia", 1);
        cc.mostrarFila();
        cc.atenderGente(1); 
        cc.mostrarFila();

    }

}
