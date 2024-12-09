import java.io.*;

public class FileManager {
    private final String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public boolean createFile(String[] document) {
        File archivo = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (String line : document) {
                writer.write(line);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error al crear/escribir el archivo: " + e.getMessage());
            return false;
        }
    }

    public String[] readFile() {
        File archivo = new File(filePath);
        if (!archivo.exists()) {
            System.err.println("El archivo no existe");
            return new String[0];
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            return reader.lines().toArray(String[]::new);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return new String[0];
        }
    }

    public boolean updateLine(int lineNumber, String newLine) {
        String[] document = readFile();
        if (lineNumber < 1 || lineNumber > document.length) {
            System.err.println("Número de línea fuera de rango");
            return false;
        }

        document[lineNumber - 1] = newLine;
        return createFile(document);
    }

    public boolean deleteLine(int lineNumber) {
        String[] document = readFile();
        if (lineNumber < 1 || lineNumber > document.length) {
            System.err.println("Número de línea fuera de rango");
            return false;
        }

        String[] newDocument = new String[document.length - 1];
        for (int i = 0, j = 0; i < document.length; i++) {
            if (i != lineNumber - 1) {
                newDocument[j++] = document[i];
            }
        }
        return createFile(newDocument);
    }

    public boolean deleteFile() {
        File archivo = new File(filePath);
        if (!archivo.exists()) {
            System.err.println("El archivo no existe");
            return false;
        }
        return archivo.delete();
    }
}