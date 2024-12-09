
import java.io.File;
import java.util.Scanner;

class Edlin {

    public static void main(String[] args) {
        final String CARPETA_GUARDADO = "C:\\\\Users\\\\Dylan\\\\Desktop\\\\24-25-EDA1\\\\entregas\\\\n"
                + //
                "aranjoDylan\\\\reto-006\\\\guardado";
        final String EXTENSION = ".edin";
        prepararCarpetaGuardado(CARPETA_GUARDADO);

        Editor editor = null;
        Scanner entrada = new Scanner(System.in);

        System.out.print("¿Desea cargar un editor existente? (S/N): ");
        if (entrada.nextLine().equalsIgnoreCase("S")) {
            System.out.print("Ingrese el nombre del archivo (sin extensión): ");
            String nombreArchivo = entrada.nextLine();
            nombreArchivo = asegurarExtension(nombreArchivo, EXTENSION);
            editor = SerializadorEditor.deserializar(CARPETA_GUARDADO + File.separator + nombreArchivo);
        }

        if (editor == null) {
            System.out.println("Creando un nuevo editor...");
            int numLineas = pedirNumeroLineas();
            editor = new Editor(numLineas);
        }

        Menu menu = new Menu(editor);

        do {
            editor.imprimir();
            menu.procesarAccion();
        } while (menu.estaEjecutando());

        System.out.print("¿Desea guardar el editor antes de salir? (S/N): ");
        if (entrada.nextLine().equalsIgnoreCase("S")) {
            System.out.print("Ingrese el nombre del archivo (sin extensión): ");
            String nombreArchivo = entrada.nextLine();
            nombreArchivo = asegurarExtension(nombreArchivo, EXTENSION);
            SerializadorEditor.serializar(editor, CARPETA_GUARDADO + File.separator + nombreArchivo);
        }

        entrada.close();
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

    private static void prepararCarpetaGuardado(String carpeta) {
        File directorio = new File(carpeta);
        if (!directorio.exists()) {
            if (directorio.mkdir()) {
                System.out.println("Carpeta de guardado creada: " + carpeta);
            } else {
                System.out.println("No se pudo crear la carpeta de guardado: " + carpeta);
            }
        }
    }

    private static String asegurarExtension(String nombreArchivo, String extension) {
        if (!nombreArchivo.endsWith(extension)) {
            nombreArchivo += extension;
        }
        return nombreArchivo;
    }
}
