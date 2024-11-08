package entregas.naranjoDylan.reto003;

public class Imprime {

    public static void main(String[] args) {
        ArchivoGet archivoGet = new ArchivoGet();
        archivoGet.agregarCadena();
        String cadena = archivoGet.getCadena();

        Compresor compresor = new Compresor(cadena.length() * 2);
        String resultadoComprimido = compresor.comprime(cadena);

        System.out.println("El resultado comprimido es:");
        System.out.println(resultadoComprimido);

        System.out.println("El diccionario es:");
        compresor.imprimirDiccionario();
    }
}
