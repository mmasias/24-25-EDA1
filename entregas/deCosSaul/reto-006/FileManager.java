import java.io.*;
import java.util.Scanner;

public class FileManager {
  private final String filePath;
  private String previousState;

  public FileManager(String filePath) {
    this.filePath = filePath;
    previousState = null;
  }

  public void saveState() {
    previousState = readFile();
  }

  public void undo() {
    if (previousState != null) {
      createFile(previousState); // Restaurar el contenido previo
      System.out.println("Se deshizo el último cambio.");
    } else {
      System.err.println("No hay cambios para deshacer.");
    }
  }

  public boolean createFile(String content) {
    File archivo = new File(filePath);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
      writer.write(content);
      return true;
    } catch (IOException e) {
      System.err.println("Error al crear/escribir el archivo: " + e.getMessage());
      return false;
    }
  }

  public String readFile() {
    File archivo = new File(filePath);
    StringBuilder contenido = new StringBuilder();

    if (!archivo.exists()) {
      System.err.println("El archivo no existe");
      return null;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
      String linea;
      while ((linea = reader.readLine()) != null) {
        contenido.append(linea)
            .append(System.lineSeparator());
      }
      return contenido.toString();
    } catch (IOException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
      return null;
    }
  }

  public String readFile(int[] activeLine) {
    File archivo = new File(filePath);
    StringBuilder contenido = new StringBuilder();

    if (!archivo.exists()) {
      System.err.println("El archivo no existe");
      return null;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
      String linea;
      int lineNumber = 1;
      while ((linea = reader.readLine()) != null) {
        contenido.append(lineNumber)
            .append(separator(lineNumber, activeLine[0]))
            .append(linea)
            .append(System.lineSeparator());
        lineNumber++;
      }
      return contenido.toString();
    } catch (IOException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
      return null;
    }
  }

  static String separator(int line, int activeLine) {
    return line == activeLine ? ":*| " : ": | ";
  }

  private int countLines() {
    int count = 0;
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      while (reader.readLine() != null) {
        count++;
      }
    } catch (IOException e) {
      System.err.println("Error al contar líneas: " + e.getMessage());
    }
    return count;
  }

  public boolean updateLine(int lineNumber, String newLine) {
    int totalLines = countLines();
    if (lineNumber < 1 || lineNumber > totalLines) {
      System.err.println("Número de línea fuera de rango");
      return false;
    }

    String[] lines = new String[totalLines];

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      for (int i = 0; i < totalLines; i++) {
        lines[i] = reader.readLine();
      }
    } catch (IOException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
      return false;
    }

    lines[lineNumber - 1] = newLine;

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      for (int i = 0; i < lines.length; i++) {
        writer.write(lines[i]);
        if (i < lines.length - 1) {
          writer.newLine();
        }
      }
      return true;
    } catch (IOException e) {
      System.err.println("Error al escribir el archivo: " + e.getMessage());
      return false;
    }
  }

  public String readLine(int lineNumber) {
    int totalLines = countLines();
    if (lineNumber < 1 || lineNumber > totalLines) {
      System.err.println("Número de línea fuera de rango");
      return "";
    }

    String[] lines = new String[totalLines + 1];

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      for (int i = 0; i < totalLines; i++) {
        lines[(i + 1)] = reader.readLine();
      }
    } catch (IOException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
      return "";
    }

    return lines[lineNumber];
  }

  public boolean deleteFile() {
    File archivo = new File(filePath);
    if (!archivo.exists()) {
      System.err.println("El archivo no existe");
      return false;
    }
    return archivo.delete();
  }

  public boolean deleteLine(int lineNumber) {
    int totalLines = countLines();
    if (lineNumber < 1 || lineNumber > totalLines) {
      System.err.println("Número de línea fuera de rango");
      return false;
    }

    String[] lines = new String[totalLines];

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      for (int i = 0; i < totalLines; i++) {
        lines[i] = reader.readLine();
      }
    } catch (IOException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
      return false;
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      for (int i = 0; i < lines.length; i++) {
        if (i + 1 != lineNumber) {
          writer.write(lines[i]);
          if (i < lines.length - 1) {
            writer.newLine();
          }
        }
      }
      return true;
    } catch (IOException e) {
      System.err.println("Error al escribir el archivo: " + e.getMessage());
      return false;
    }
  }
}
