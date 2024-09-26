
public class CentroComercial {
    private String[][] filasCajas;
    private int maxPersonasPorFila;
    private int[] cantidadPersonasEnCaja;

    public CentroComercial(int numeroDeCajas, int maxPersonasPorFila) {
        this.maxPersonasPorFila = maxPersonasPorFila;
        filasCajas = new String[numeroDeCajas][maxPersonasPorFila];
        cantidadPersonasEnCaja = new int[numeroDeCajas];
    } 

    public void agregarPersonaAFila(String persona, int numeroCaja) {
        if (numeroCaja <= 0 || numeroCaja >= filasCajas.length) {
            System.out.println("Número de caja inválido.");
            return;
        }

        if (cantidadPersonasEnCaja[numeroCaja] < maxPersonasPorFila) {
            filasCajas[numeroCaja][cantidadPersonasEnCaja[numeroCaja]] = persona;
            cantidadPersonasEnCaja[numeroCaja]++;
        } else {
            System.out.println("La fila en caja " + numeroCaja + " está llena. Buscando otra caja.");
            for (int i = 1; i < filasCajas.length; i++) {
                if (cantidadPersonasEnCaja[i] < maxPersonasPorFila) {
                    filasCajas[i][cantidadPersonasEnCaja[i]] = persona;
                    cantidadPersonasEnCaja[i]++;
                    return;
                }
            }
            System.out.println("Todas las cajas están llenas.");
        }
    }

    public void mostrarFilas() {
        for (int i = 1; i < filasCajas.length; i++) {
            System.out.print("Caja " + i + ": ");
            for (int j = 0; j < cantidadPersonasEnCaja[i]; j++) {
                System.out.print(filasCajas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void atenderPrimeraPersona(int numeroCaja) {
        if (numeroCaja <= 0 || numeroCaja >= filasCajas.length) {
            System.out.println("Número de caja inválido.");
            return;
        }

        if (cantidadPersonasEnCaja[numeroCaja] > 0) {
            System.out.println(filasCajas[numeroCaja][0] + " está siendo atendido en la caja " + numeroCaja);
            for (int i = 1; i < cantidadPersonasEnCaja[numeroCaja]; i++) {
                filasCajas[numeroCaja][i - 1] = filasCajas[numeroCaja][i];
            }
            filasCajas[numeroCaja][cantidadPersonasEnCaja[numeroCaja] - 1] = null;
            cantidadPersonasEnCaja[numeroCaja]--;
        } else {
            System.out.println("No hay personas en la fila de la caja " + numeroCaja);
        }
    }

}
