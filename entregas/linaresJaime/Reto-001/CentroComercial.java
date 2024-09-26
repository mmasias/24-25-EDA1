
public class CentroComercial {
    private String[][] filasCajas;
    private int maxPersonasPorFila;
    private int[] cantidadPersonasEnCaja;

    public CentroComercial(int numeroDeCajas, int maxPersonasPorFila) {
        this.maxPersonasPorFila = maxPersonasPorFila;
        filasCajas = new String[numeroDeCajas][maxPersonasPorFila];
        cantidadPersonasEnCaja = new int[numeroDeCajas];
    } 

}
