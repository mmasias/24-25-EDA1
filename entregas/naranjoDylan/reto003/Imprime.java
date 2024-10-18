package entregas.naranjoDylan.reto003;

public class Imprime {
    public static void main(String[] args) {
        ArchivoGet archivoGet = new ArchivoGet();
        archivoGet.agregarCadena();
        String cadena = archivoGet.getCadena();

        Compresor compresor = new Compresor();
        String resultadoComprimido = compresor.comprime(cadena);

        System.out.println("Cadena comprimida: " + resultadoComprimido);
        System.out.println("Diccionario utilizado: " + compresor.getDiccionario().getDiccionario());
    }
}

