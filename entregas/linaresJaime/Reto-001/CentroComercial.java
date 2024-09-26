
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

    public void removerPersonaDeFila(String persona, int numeroCaja) {
        if (numeroCaja <= 0 || numeroCaja >= filasCajas.length) {
            System.out.println("Número de caja inválido.");
            return;
        }

        int indicePersona = -1;
        for (int i = 0; i < cantidadPersonasEnCaja[numeroCaja]; i++) {
            if (filasCajas[numeroCaja][i].equals(persona)) {
                indicePersona = i;
                break;
            }
        }

        if (indicePersona != -1) {
            System.out.println(persona + " ha salido de la fila de la caja " + numeroCaja);
            for (int i = indicePersona + 1; i < cantidadPersonasEnCaja[numeroCaja]; i++) {
                filasCajas[numeroCaja][i - 1] = filasCajas[numeroCaja][i];
            }
            filasCajas[numeroCaja][cantidadPersonasEnCaja[numeroCaja] - 1] = null;
            cantidadPersonasEnCaja[numeroCaja]--;
        } else {
            System.out.println(persona + " no está en la fila de la caja " + numeroCaja);
        }
    }

    public void colarsePersonaLicitamente(String persona, int numeroCaja, int posicion) {
        if (numeroCaja <= 0 || numeroCaja >= filasCajas.length) {
            System.out.println("Número de caja inválido.");
            return;
        }

        if (cantidadPersonasEnCaja[numeroCaja] >= maxPersonasPorFila) {
            System.out.println("No hay espacio en la fila de la caja " + numeroCaja + ". No se puede colar.");
            return;
        }

        if (posicion < 1 || posicion > cantidadPersonasEnCaja[numeroCaja]) {
            System.out.println("Posición inválida.");
            return;
        }

        for (int i = cantidadPersonasEnCaja[numeroCaja]; i > posicion; i--) {
            filasCajas[numeroCaja][i] = filasCajas[numeroCaja][i - 1];
        }

        filasCajas[numeroCaja][posicion] = persona;
        cantidadPersonasEnCaja[numeroCaja]++;
        System.out.println(persona + " se ha colado lícitamente en la posición " + posicion + " en la caja " + numeroCaja);
    }

    public void colarsePersonaIlicitamente(String persona, int numeroCaja, int posicion) {
        if (numeroCaja < 1 || numeroCaja >= filasCajas.length) {
            System.out.println("Número de caja inválido.");
            return;
        }

        if (posicion < 1 || posicion > maxPersonasPorFila) {
            System.out.println("Posición inválida. No se puede colar.");
            return;
        }

        System.out.println(persona + " se ha colado ilícitamente en la caja " + numeroCaja + " en la posición " + posicion);

        for (int i = Math.min(cantidadPersonasEnCaja[numeroCaja], maxPersonasPorFila - 1); i > posicion; i--) {
            filasCajas[numeroCaja][i] = filasCajas[numeroCaja][i - 1];
        }

        filasCajas[numeroCaja][posicion] = persona;

        if (cantidadPersonasEnCaja[numeroCaja] < maxPersonasPorFila) {
            cantidadPersonasEnCaja[numeroCaja]++;
        }
    }

}
