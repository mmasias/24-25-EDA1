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
            return;
        }

        if (contadores[numCaja] < tamañoFila) {
            cajas[numCaja][contadores[numCaja]] = nombre;
            contadores[numCaja]++;
            System.out.println(nombre + " está en la caja " + numCaja);
        } else {
            System.out.println("La fila de la caja " + numCaja + " está llena. Se abre otra caja.");
            for (int i = 0; i < cajas.length; i++) {
                if (contadores[i] < tamañoFila) {
                    cajas[i][contadores[i]] = nombre;
                    contadores[i]++;
                    System.out.println(nombre + " está en la caja" + i);
                    return;
                }
            }
            System.out.println("Todas las cajas están llenas. No se puede agregar a " + nombre);
        }
    }


    public static void main(String[] args) {
        CentroComercial cc = new CentroComercial(3, 5); 
        cc.llegaGente("Clara", 1);

    }

}
