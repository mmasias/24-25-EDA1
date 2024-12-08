import java.io.*;
import java.util.Scanner;

class Edlin {
  public static void main(String[] args) {
    int activeLine[] = { 1 };
    String document[] = {
        "Bienvenidos al editor EDLIN",
        "Utilice el menu inferior para editar el texto",
        "------",
        "[L] permite definir la linea activa",
        "[E] permite editar la linea activa",
        "[I] permite intercambiar dos lineas",
        "[D] borra el contenido de la linea activa",
        "[S] sale del programa",
        "[Y] copiar",
        "[U] deshacer",
        "[W] guardar",
    };

    String previous[] = document.clone();

    do {
      print(document, activeLine);
    } while (processActions(document, activeLine, previous));
  }

  static void print(String[] document, int[] activeLine) {
    clearScreen();
    printHorizontalLine();
    for (int line = 0; line < document.length; line++) {
      System.out.println(line + separator(line, activeLine[0]) + document[line]);
    }
    printHorizontalLine();
  }

  static String separator(int line, int activeLine) {
    return line == activeLine ? ":*| " : ": | ";
  }

  static void printHorizontalLine() {
    System.out.println("-".repeat(50));
  }

  static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  static boolean processActions(String[] document, int[] activeLine, String[] previous) {
    System.out.println(
        "Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [D]Borrar | [Y]Copiar | [U]Deshacer | [W]Guardar | [S]alir");

    switch (askChar()) {
      case 'S':
      case 's':
        return false;
      case 'L':
      case 'l':
        System.arraycopy(document, 0, previous, 0, document.length);
        setActiveLine(document, activeLine);
        break;
      case 'E':
      case 'e':
        System.arraycopy(document, 0, previous, 0, document.length);
        edit(document, activeLine);
        break;
      case 'I':
      case 'i':
        System.arraycopy(document, 0, previous, 0, document.length);
        exchangeLines(document);
        break;
      case 'D':
      case 'd':
        System.arraycopy(document, 0, previous, 0, document.length);
        delete(document, activeLine);
        break;
      case 'Y':
      case 'y':
        System.arraycopy(document, 0, previous, 0, document.length);
        copy(document);
        break;
      case 'U':
      case 'u':
        undo(document, previous);
        break;
      case 'W':
      case 'w':
        saveToFile(document);
        break;
    }
    return true;
  }

  static char askChar() {
    Scanner input = new Scanner(System.in);
    return input.next().charAt(0);
  }

  static void delete(String[] document, int[] activeLine) {
    System.out.println(
        "Esta acción es irreversible: indique el número de línea activa para confirmarlo [" + activeLine[0] + "]");
    if (askInt() == activeLine[0]) {
      document[activeLine[0]] = "";
    }
  }

  static void copy(String[] document) {
    int originLine, destinationLine;
    boolean validLine;

    do {
      System.out.print("Indique la linea que desea copiar: ");
      originLine = askInt();
      validLine = originLine >= 0 && originLine < document.length;
    } while (!validLine);

    do {
      System.out.print("Indique la linea en la que desea pegar: ");
      destinationLine = askInt();
      validLine = destinationLine >= 0 && destinationLine < document.length;
    } while (!validLine);

    document[destinationLine] = document[originLine];
  }

  static void exchangeLines(String[] document) {
    int originLine, destinationLine;
    String temporaryLine;
    boolean validLine;

    do {
      System.out.print("Indique primera línea a intercambiar: ");
      originLine = askInt();
      validLine = originLine >= 0 && originLine < document.length;
    } while (!validLine);

    do {
      System.out.print("Indique segunda línea a intercambiar: ");
      destinationLine = askInt();
      validLine = destinationLine >= 0 && destinationLine < document.length;
    } while (!validLine);

    temporaryLine = document[destinationLine];
    document[destinationLine] = document[originLine];
    document[originLine] = temporaryLine;
  }

  static void edit(String[] document, int[] activeLine) {
    System.out.println("EDITANDO> " + document[activeLine[0]]);
    document[activeLine[0]] = askString();
  }

  static String askString() {
    Scanner input = new Scanner(System.in);
    return input.nextLine();
  }

  static void undo(String[] document, String[] previous) {
    System.arraycopy(previous, 0, document, 0, document.length);
  }

  static void setActiveLine(String[] document, int[] activeLine) {
    boolean validLine;
    do {
      System.out.print("Indique la nueva línea activa: ");
      activeLine[0] = askInt();
      validLine = activeLine[0] >= 0 && activeLine[0] < document.length;
    } while (!validLine);
  }

  static int askInt() {
    Scanner input = new Scanner(System.in);
    return input.nextInt();
  }

  static void saveToFile(String[] document) {
    try {
      FileWriter writer = new FileWriter("documento.txt");
      for (String line : document) {
        writer.write(line + System.lineSeparator());
      }
      writer.close();
      System.out.println("El documento ha sido guardado en 'documento.txt'.");
    } catch (IOException e) {
      System.out.println("Ocurrió un error al guardar el archivo.");
      e.printStackTrace();
    }
  }
}
