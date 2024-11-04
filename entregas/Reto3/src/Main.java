public class Main {

    public static void main(String[] args) {

        String cadena = "abababcbdc";
        CompresorLZ compresor = new CompresorLZ();

        System.out.println(compresor.comprime(cadena));

    }

}