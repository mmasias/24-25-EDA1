import java.util.Scanner;

public class InterfazUsuario {

    private ColeccionLineas lineas;
    private String portapapeles;
    private PilaHistorial pilaDeshacer;
    private PilaHistorial pilaRehacer;

    public InterfazUsuario(ColeccionLineas lineas, PilaHistorial pilaDeshacer, PilaHistorial pilaRehacer) {
        this.lineas = lineas;
        this.pilaDeshacer = pilaDeshacer;
        this.pilaRehacer = pilaRehacer;
        this.portapapeles = "";
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;

        System.out.println("¡Bienvenido al Editor de Texto en Consola!");
        while (ejecutando) {
            lineas.mostrar();
            System.out.println("[A] Seleccionar línea activa\n[E] Editar línea activa\n[I] Intercambiar líneas");
            System.out.println("[C] Copiar línea\n[P] Pegar en línea\n[D] Deshacer\n[R] Rehacer\n[S] Salir");
            System.out.print("Elige una opción: ");

            String comando = scanner.nextLine().toUpperCase();
            switch (comando) {
                case "A":
                    System.out.print("Introduce el número de línea: ");
                    int numeroLinea = Integer.parseInt(scanner.nextLine());
                    lineas.seleccionarLineaActiva(numeroLinea);
                    break;
                case "E":
                    pilaDeshacer.guardar(lineas.obtenerNumeroLineaActiva(), lineas.obtenerContenidoLineaActiva());
                    System.out.print("Introduce el nuevo contenido: ");
                    String contenido = scanner.nextLine();
                    lineas.editarLinea(contenido);
                    pilaRehacer.limpiar();
                    break;
                case "I":
                    System.out.print("Introduce los números de las líneas a intercambiar: ");
                    int primeraLinea = scanner.nextInt();
                    int segundaLinea = scanner.nextInt();
                    scanner.nextLine();
                    lineas.intercambiarLineas(primeraLinea, segundaLinea);
                    break;
                case "C":
                    portapapeles = lineas.obtenerContenidoLineaActiva();
                    break;
                case "P":
                    pilaDeshacer.guardar(lineas.obtenerNumeroLineaActiva(), lineas.obtenerContenidoLineaActiva());
                    lineas.editarLinea(portapapeles);
                    pilaRehacer.limpiar();
                    break;
                case "D":
                    lineas.deshacer(pilaDeshacer, pilaRehacer);
                    break;
                case "R":
                    lineas.rehacer(pilaRehacer, pilaDeshacer);
                    break;
                case "S":
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Comando no válido. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }
}
