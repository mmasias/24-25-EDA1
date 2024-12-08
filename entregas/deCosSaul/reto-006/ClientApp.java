import java.util.Scanner;

public class ClientApp {
  public static void main(String[] args) {
    FileManager manager = new FileManager("ejemplo.txt");
    int activeLine[] = { 1 };
    System.out.println("=== CREACIÓN DE ARCHIVO ===");
    String contenidoInicial = "Bienvenidos al editor EDLIN\n" +
        "Utilice el menu inferior para editar el texto\n" +
        "------\n" +
        "[L] permite definir la linea activa\n" +
        "[E] permite editar la linea activa\n" +
        "[I] permite intercambiar dos lineas\n" +
        "[D] borra el contenido de la linea activa\n" +
        "[S] sale del programa\n" +
        "[Y] copiar\n" +
        "[U] deshacer\n" +
        "[W] guardar\n";
    boolean creado = manager.createFile(contenidoInicial);
    if (creado) {
      System.out.println("Archivo creado con éxito");
    } else {
      System.out.println("Error al crear el archivo");
    }

    do {
      System.out.println(manager.readFile(activeLine));
    } while (processActions(manager, activeLine));
  }

  static boolean processActions(FileManager manager, int[] activeLine) {
    System.out.println(
        "Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [D]Borrar | [Y]Copiar | [U]Deshacer | [S]alir");

    switch (askChar()) {
      case 'S':
      case 's':
        return false;
      case 'L':
      case 'l':
        setActiveLine(activeLine);
        break;
      case 'E':
      case 'e':
        edit(manager, activeLine);
        break;
      case 'I':
      case 'i':
        exchangeLines(manager);
        break;
      case 'D':
      case 'd':
        delete(manager, activeLine);
        break;
      case 'Y':
      case 'y':
        copy(manager);
        break;
      case 'U':
      case 'u':
        // undo(manager, previous);
        break;
    }
    return true;
  }

  static char askChar() {
    Scanner input = new Scanner(System.in);
    return input.next().charAt(0);
  }

  static int askInt() {
    Scanner input = new Scanner(System.in);
    return input.nextInt();
  }

  static void setActiveLine(int[] activeLine) {
    System.out.print("Indique la nueva línea activa: ");
    activeLine[0] = askInt();
  }

  static void delete(FileManager manager, int[] activeLine) {
    manager.deleteLine(activeLine[0]);
  }

  static void edit(FileManager manager, int[] activeLine) {
    System.out.print("Introduce el texto modificado: ");
    Scanner scanner = new Scanner(System.in);
    String newLine = scanner.nextLine();
    manager.updateLine(activeLine[0], newLine);
  }

  static void copy(FileManager manager) {
    int originLine;
    int destinationLine;
    String originText;

    System.out.print("Indique la linea que desea copiar: ");
    originLine = askInt();
    originText = manager.readLine(originLine);

    System.out.print("Indique la linea en la que desea pegar: ");
    destinationLine = askInt();

    manager.updateLine(destinationLine, originText);
  }

  static void exchangeLines(FileManager manager) {
    int originLine;
    int destinationLine;
    String originText;
    String destinationText;

    System.out.print("Indique primera línea a intercambiar: ");
    originLine = askInt();
    originText = manager.readLine(originLine);

    System.out.print("Indique segunda línea a intercambiar: ");
    destinationLine = askInt();
    destinationText = manager.readLine(destinationLine);

    manager.updateLine(destinationLine, originText);
    manager.updateLine(originLine, destinationText);
  }
}
