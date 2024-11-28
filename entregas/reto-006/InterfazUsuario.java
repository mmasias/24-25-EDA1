import java.util.Scanner;

public class InterfazUsuario {
    private ColeccionLineas lineas;

    public InterfazUsuario(ColeccionLineas lineas) {
        this.lineas = lineas;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;

        System.out.println("¡Bienvenido al Editor de Texto!");
        while (ejecutando) {
            lineas.mostrar();
        System.out.println("[A] Seleccionar línea activa\n[E] Editar línea activa\n[S] Salir");
        System.out.print("Elige una opción: ");
        String opcion = scanner.nextLine().toUpperCase();

        switch (opcion) {
            case "A":
                System.out.print("Número de línea: ");
                int numeroLinea = Integer.parseInt(scanner.nextLine());
                lineas.seleccionarLineaActiva(numeroLinea);
                break;
            case "E":
                System.out.print("Número de línea: ");
                int linea = Integer.parseInt(scanner.nextLine());
                System.out.print("Nuevo contenido: ");
                String contenido = scanner.nextLine();
                lineas.editarLineaActiva(linea, contenido);
                break;
            case "S":
                ejecutando = false;
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Comando no válido.");
        }
    }
    scanner.close();
}
}