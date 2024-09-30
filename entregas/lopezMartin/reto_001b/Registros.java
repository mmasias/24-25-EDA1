package entregas.lopezMartin.reto_001b;

public class Registros {

    private Dato[] datos;
    private int ultimaPosicion;
    private int contadorID;
    
    public Registros(){

        datos = new Dato[27];
        ultimaPosicion = 0;
        contadorID = 1;

    }

    public void añadir(String valor){

        datos[ultimaPosicion] = new Dato(valor, contadorID);
        ultimaPosicion++;
        contadorID++;

    }

    public void mostrar(){

        System.out.println("+------------------+------------------+");
        System.out.println("|       ID         |      VALOR       |");
        System.out.println("+------------------+------------------+");

        for (int i = 0; i < ultimaPosicion; i++) {
            if (datos[i].isActivo()) {
                System.out.printf("| %-16d | %-16s |\n", datos[i].getId(), datos[i].getValor());  
            }
        }

        System.out.println("+------------------+------------------+\n");

    }

    public void mostrarEnOrden(String primerValor, String segundoValor, String tercerValor) {

        Dato[] datosOrdenados = new Dato[ultimaPosicion];

        for(int i=0; i<ultimaPosicion; i++){
            if (datos[i].getValor().equals(primerValor) && datos[i].isActivo()) {
                datosOrdenados[0] = datos[i];
            }
        }

        for(int i=0; i<ultimaPosicion; i++){
            if (datos[i].getValor().equals(segundoValor) && datos[i].isActivo()) {
                datosOrdenados[1] = datos[i];
            }
        }

        for(int i=0; i<ultimaPosicion; i++){
            if (datos[i].getValor().equals(tercerValor) && datos[i].isActivo()) {
                datosOrdenados[2] = datos[i];
            }
        }

        System.out.println("+------------------+------------------+");
        System.out.println("|       ID         |      VALOR       |");
        System.out.println("+------------------+------------------+");

        for (int i = 0; i < ultimaPosicion; i++) {
            System.out.printf("| %-16d | %-16s |\n", datosOrdenados[i].getId(), datosOrdenados[i].getValor());
        }

        System.out.println("+------------------+------------------+\n");

    }

    public void eliminar(String valorAEliminar) {

        for (int i = 0; i < ultimaPosicion; i++) {
            if (datos[i].getValor().equals(valorAEliminar) && datos[i].isActivo()) {
                datos[i].eliminar();
                break;
            }
        }
    }

}