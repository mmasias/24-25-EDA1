import java.util.Scanner;

class Edlin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del documento: ");
        int documentSize = input.nextInt();
        System.out.print("Ingrese el número máximo de deshacer/rehacer: ");
        int maxUndo = input.nextInt();

        DocumentEditor editor = new DocumentEditor(documentSize, maxUndo, input);
        editor.run();
    }
}
