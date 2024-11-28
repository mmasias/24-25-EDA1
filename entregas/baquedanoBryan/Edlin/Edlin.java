import java.util.Scanner;

public class Edlin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Editor editor = new Editor(10); 

        boolean continuar = true;

        while (continuar) {
            editor.mostrarDocumento(); 
            continuar = procesarComando(scanner, editor); 
        }

        System.out.println("Programa terminado.");
    }

    public static boolean procesarComando(Scanner scanner, Editor editor) {
        System.out.println("Comandos disponibles:");
        System.out.println("[L]ínea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [R]ehacer | [C]opiar | [P]egar | [S]alir");
        char comando = scanner.next().charAt(0);

        if (comando == 'L' || comando == 'l') {
            System.out.print("Indique nueva línea activa: ");
            int nuevaLinea = scanner.nextInt();
            editor.setLineaActiva(nuevaLinea); 
        } else if (comando == 'E' || comando == 'e') {
            System.out.print("Indique contenido para la línea activa: ");
            scanner.nextLine(); 
            String contenido = scanner.nextLine();
            editor.editar(editor.getLineaActiva(), contenido); 
        } else if (comando == 'I' || comando == 'i') {
            System.out.print("Indique la primera línea a intercambiar: ");
            int linea1 = scanner.nextInt();
            System.out.print("Indique la segunda línea a intercambiar: ");
            int linea2 = scanner.nextInt();
            editor.intercambiar(linea1, linea2);
        } else if (comando == 'B' || comando == 'b') {
            System.out.println("Borrando contenido de la línea activa.");
            editor.borrar(editor.getLineaActiva()); 
        } else if (comando == 'D' || comando == 'd') {
            editor.deshacer();
        } else if (comando == 'R' || comando == 'r') {
            editor.rehacer();
        } else if (comando == 'C' || comando == 'c') {
            editor.copiar();
        } else if (comando == 'P' || comando == 'p') {
            editor.pegar();
        } else if (comando == 'S' || comando == 's') {
            return false; 
        } else {
            System.out.println("Comando no reconocido. Intente nuevamente.");
        }

        return true; 
    }

    public static void mostrarDocumento(Editor editor) {
        editor.mostrarDocumento(); 
    }

    public static String separator(int line, int activeLine) {
        return line == activeLine ? ":*| " : ": | ";
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
