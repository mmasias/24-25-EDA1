import java.util.Scanner;

class Main{
    public static void main(String[] args) {

        int tamañoDiccionario = 100;
        Compresor compresor = new Compresor(tamañoDiccionario);

        Scanner scanner = new Scanner(System.in);
        String cadena = leerCadenaDelUsuario();

        if (esCadenaValida(cadena, tamañoDiccionario)) {
            compresor.comprimir(cadena); 
        }

        scanner.close();

    }

    private static String leerCadenaDelUsuario() {
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Ingrese la cadena a comprimir (máximo 100 caracteres): ");
        return scanner.nextLine(); 
    }

    private static boolean esCadenaValida(String cadena, int maxLength) {
        if (cadena.length() > maxLength) {
            System.out.println("Error: La cadena no debe exceder los " + maxLength + " caracteres.");
            return false;
        }
        return true; 
    }


}