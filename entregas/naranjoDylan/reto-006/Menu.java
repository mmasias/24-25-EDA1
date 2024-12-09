
import java.util.Scanner;

class Menu {

    private Editor editor;
    private boolean ejecutando;
    private Scanner entrada;

    public Menu(Editor editor) {
        this.editor = editor;
        this.ejecutando = true;
        this.entrada = new Scanner(System.in);
    }

    public boolean estaEjecutando() {
        return ejecutando;
    }

    public void procesarAccion() {
        System.out.println("Opciones:");
        System.out.println("1. Editar línea actual");
        System.out.println("2. Borrar línea actual");
        System.out.println("3. Copiar línea actual");
        System.out.println("4. Pegar en línea actual");
        System.out.println("5. Cambiar línea activa");
        System.out.println("6. Intercambiar línea actual con otra");
        System.out.println("7. Deshacer");
        System.out.println("8. Rehacer");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");

        int opcion = entrada.nextInt();
        entrada.nextLine();

        switch (opcion) {
            case 1 -> {
                System.out.print("Ingrese el nuevo texto: ");
                String nuevoTexto = entrada.nextLine();
                editor.editar(nuevoTexto);
            }
            case 2 ->
                editor.borrar();
            case 3 ->
                editor.copiar();
            case 4 ->
                editor.pegar();
            case 5 -> {
                System.out.print("Ingrese el número de la nueva línea activa: ");
                int nuevaLinea = entrada.nextInt();
                editor.establecerLineaActiva(nuevaLinea);
            }
            case 6 -> {
                System.out.print("Ingrese el número de la línea con la que desea intercambiar: ");
                int lineaDestino = entrada.nextInt();
                editor.intercambiarLineas(lineaDestino);
            }
            case 7 ->
                editor.deshacer();
            case 8 ->
                editor.rehacer();
            case 9 -> {
                System.out.println("Saliendo...");
                ejecutando = false;
            }
            default ->
                System.out.println("Opción no válida.");
        }
    }
}
