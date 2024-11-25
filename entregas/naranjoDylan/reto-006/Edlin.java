
import java.util.Scanner;

class Edlin {

    public static void main(String[] args) {
        int numLineas = pedirNumeroLineas();
        Editor editor = new Editor(numLineas);
        Menu menu = new Menu(editor);

        do {
            editor.imprimir();
            menu.procesarAccion();
        } while (menu.estaEjecutando());
    }

    private static int pedirNumeroLineas() {
        Scanner entrada = new Scanner(System.in);
        int numLineas;

        do {
            System.out.print("Ingrese el número de líneas para el bloc de notas (mínimo 1): ");
            numLineas = entrada.nextInt();
        } while (numLineas < 1);

        return numLineas;
    }
}

class Editor {

    private String[] documento;
    private int lineaActiva;
    private String portapapeles;
    private String[][] pilaDeshacer;
    private String[][] pilaRehacer;
    private int indiceDeshacer;
    private int indiceRehacer;

    public Editor(int numLineas) {
        documento = new String[numLineas];
        for (int i = 0; i < numLineas; i++) {
            documento[i] = "";
        }
        lineaActiva = 0;
        portapapeles = "";
        pilaDeshacer = new String[100][];
        pilaRehacer = new String[100][];
        indiceDeshacer = -1;
        indiceRehacer = -1;
    }

    public void imprimir() {
        limpiarPantalla();
        imprimirLineaHorizontal();
        for (int linea = 0; linea < documento.length; linea++) {
            System.out.println(linea + separador(linea, lineaActiva) + documento[linea]);
        }
        imprimirLineaHorizontal();
    }

    public void establecerLineaActiva(int nuevaLinea) {
        if (nuevaLinea >= 0 && nuevaLinea < documento.length) {
            lineaActiva = nuevaLinea;
        } else {
            System.out.println("Número de línea no válido.");
        }
    }

    public int getLineaActiva() {
        return lineaActiva;
    }

    public void guardarEstadoDeshacer() {
        if (indiceDeshacer < pilaDeshacer.length - 1) {
            pilaDeshacer[++indiceDeshacer] = documento.clone();
            indiceRehacer = -1;
        }
    }

    public void editar(String nuevoTexto) {
        guardarEstadoDeshacer();
        documento[lineaActiva] = nuevoTexto;
    }

    public void borrar() {
        guardarEstadoDeshacer();
        documento[lineaActiva] = "";
    }

    public void copiar() {
        portapapeles = documento[lineaActiva];
    }

    public void pegar() {
        if (!portapapeles.isEmpty()) {
            guardarEstadoDeshacer();
            documento[lineaActiva] = portapapeles;
            System.out.println("Pegado en línea " + lineaActiva);
        } else {
            System.out.println("El portapapeles está vacío.");
        }
    }

    public void intercambiarLineas(int lineaDestino) {
        if (lineaDestino >= 0 && lineaDestino < documento.length) {
            guardarEstadoDeshacer();
            String temporalLinea = documento[lineaDestino];
            documento[lineaDestino] = documento[lineaActiva];
            documento[lineaActiva] = temporalLinea;
        } else {
            System.out.println("Número de línea no válido.");
        }
    }

    public void deshacer() {
        if (indiceDeshacer >= 0) {
            pilaRehacer[++indiceRehacer] = documento.clone();
            documento = pilaDeshacer[indiceDeshacer--];
            System.out.println("Deshecho.");
        } else {
            System.out.println("No hay más acciones para deshacer.");
        }
    }

    public void rehacer() {
        if (indiceRehacer >= 0) {
            pilaDeshacer[++indiceDeshacer] = documento.clone();
            documento = pilaRehacer[indiceRehacer--];
            System.out.println("Rehecho.");
        } else {
            System.out.println("No hay más acciones para rehacer.");
        }
    }

    private String separador(int linea, int lineaActiva) {
        return linea == lineaActiva ? ":*| " : ": | ";
    }

    private void imprimirLineaHorizontal() {
        System.out.println("-".repeat(50));
    }

    private void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

class Menu {

    private boolean ejecutando;
    private Editor editor;

    public Menu(Editor editor) {
        this.editor = editor;
        this.ejecutando = true;
    }

    public void procesarAccion() {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [P]egar | [Z] Deshacer | [Y] Rehacer | [S]alir");

        char accion = pedirCaracter();

        switch (accion) {
            case 'S':
            case 's':
                ejecutando = false;
                break;
            case 'L':
            case 'l':
                establecerLineaActiva();
                break;
            case 'E':
            case 'e':
                editar();
                break;
            case 'I':
            case 'i':
                intercambiarLineas();
                break;
            case 'B':
            case 'b':
                borrar();
                break;
            case 'C':
            case 'c':
                copiar();
                break;
            case 'P':
            case 'p':
                pegar();
                break;
            case 'Z':
            case 'z':
                editor.deshacer();
                break;
            case 'Y':
            case 'y':
                editor.rehacer();
                break;
            default:
                System.out.println("Comando no reconocido.");
                break;
        }
    }

    public boolean estaEjecutando() {
        return ejecutando;
    }

    private char pedirCaracter() {
        Scanner entrada = new Scanner(System.in);
        return entrada.next().charAt(0);
    }

    private void establecerLineaActiva() {
        System.out.print("Indique la nueva línea activa: ");
        int nuevaLinea = pedirEntero();
        editor.establecerLineaActiva(nuevaLinea);
    }

    private void editar() {
        System.out.print("Ingrese nuevo texto: ");
        String nuevoTexto = pedirString();
        editor.editar(nuevoTexto);
    }

    private void borrar() {
        editor.borrar();
        System.out.println("Línea borrada.");
    }

    private void copiar() {
        editor.copiar();
        System.out.println("Texto copiado.");
    }

    private void pegar() {
        editor.pegar();
    }

    private void intercambiarLineas() {
        System.out.print("Indique la línea a intercambiar: ");
        int lineaDestino = pedirEntero();
        editor.intercambiarLineas(lineaDestino);
    }

    private int pedirEntero() {
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }

    private String pedirString() {
        Scanner entrada = new Scanner(System.in);
        return entrada.nextLine();
    }
}
