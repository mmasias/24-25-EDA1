package src;

import java.io.*;
import java.util.Scanner;

class TextEditor {
    private final String filePath;
    private int activeLine;
    private String lastContent;
    private String redoContent;
    private String clipboard;

    public TextEditor(String filePath) {
        this.filePath = filePath;
        this.activeLine = 0;
        this.lastContent = "";
        this.redoContent = "";
        this.clipboard = "";
    }

    public void initialize() {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                writeFile(new String[] {
                        "Bienvenidos al editor EDLIN",
                        "Utilice el menu inferior para editar el texto",
                        "------",
                        "[L] permite definir la linea activa",
                        "[E] permite editar la linea activa",
                        "[I] permite intercambiar dos lineas",
                        "[B] borra el contenido de la linea activa",
                        "[D] deshace la última acción de la activa",
                        "[R] rehacer la última acción deshecha",
                        "[C] copia el contenido de la linea activa",
                        "[P] pega el contenido de la linea activa",
                        "[X] elimina el archivo creado",
                        "[S] sale del programa",
                        "",
                        ""
                });
            } catch (IOException e) {
                System.err.println("Error al crear el archivo: " + e.getMessage());
            }
        }
    }

    public void print() {
        clearScreen();
        printHorizontalLine();
        String[] document = readFile();
        if (document == null)
            return;
        for (int i = 0; i < document.length; i++) {
            System.out.println(i + separator(i) + document[i]);
        }
        printHorizontalLine();
    }

    public boolean processActions() {
        System.out.println(
                "Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [D]eshacer | [R]ehacer | [C]opiar | [P]egar | [B]orrar | [X]Eliminar archivo .txt | [S]alir");

        switch (askChar()) {
            case 'S':
            case 's':
                return false;
            case 'X':
            case 'x':
                deleteFile();
                break;
            case 'L':
            case 'l':
                setActiveLine();
                break;
            case 'E':
            case 'e':
                edit();
                break;
            case 'I':
            case 'i':
                exchangeLines();
                break;
            case 'B':
            case 'b':
                delete();
                break;
            case 'D':
            case 'd':
                undo();
                break;
            case 'R':
            case 'r':
                redo();
                break;
            case 'C':
            case 'c':
                copy();
                break;
            case 'P':
            case 'p':
                paste();
                break;
        }
        waitForEnter();
        return true;
    }

    private void deleteFile() {
        System.out.println("¿Está seguro de que desea eliminar el archivo '" + filePath + "'? [S/N]");
        char confirm = askChar();
        if (confirm == 'S' || confirm == 's') {
            File file = new File(filePath);
            if (file.delete()) {
                System.out.println("El archivo '" + filePath + "' ha sido eliminado.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

    private void waitForEnter() {
        System.out.println("Presione Enter para continuar...");
        new Scanner(System.in).nextLine();
    }

    private void edit() {
        String[] document = readFile();
        if (document == null)
            return;

        System.out.println("EDITANDO> " + document[activeLine]);
        redoContent = "";
        lastContent = document[activeLine];
        document[activeLine] = askString();
        writeFile(document);
    }

    private void delete() {
        String[] document = readFile();
        if (document == null)
            return;

        System.out.println("CONFIRME> Indique el número de la línea activa [" + activeLine + "]");
        if (askInt() == activeLine) {
            redoContent = "";
            lastContent = document[activeLine];
            document[activeLine] = "";
            writeFile(document);
        }
    }

    private void exchangeLines() {
        String[] document = readFile();
        if (document == null)
            return;

        System.out.print("Primera línea a intercambiar: ");
        int origin = askInt();
        System.out.print("Segunda línea a intercambiar: ");
        int destination = askInt();
        if (isValidLine(origin, document) && isValidLine(destination, document)) {
            String temp = document[origin];
            document[origin] = document[destination];
            document[destination] = temp;
            writeFile(document);
        } else {
            System.out.println("Líneas fuera de rango.");
        }
    }

    private void undo() {
        String[] document = readFile();
        if (document == null)
            return;

        redoContent = document[activeLine];
        document[activeLine] = lastContent;
        writeFile(document);
    }

    private void redo() {
        if (redoContent.isEmpty()) {
            System.out.println("No hay acción para rehacer.");
            return;
        }
        String[] document = readFile();
        if (document == null)
            return;

        lastContent = document[activeLine];
        document[activeLine] = redoContent;
        writeFile(document);
    }

    private void copy() {
        String[] document = readFile();
        if (document == null)
            return;

        clipboard = document[activeLine];
        System.out.println("Contenido copiado: " + clipboard);
    }

    private void paste() {
        if (clipboard.isEmpty()) {
            System.out.println("El portapapeles está vacío.");
            return;
        }
        String[] document = readFile();
        if (document == null)
            return;

        redoContent = "";
        lastContent = document[activeLine];
        document[activeLine] = clipboard;
        writeFile(document);
    }

    private void setActiveLine() {
        System.out.print("Indique la nueva línea activa: ");
        int line = askInt();
        String[] document = readFile();
        if (document != null && isValidLine(line, document)) {
            activeLine = line;
        } else {
            System.out.println("Línea fuera de rango.");
        }
    }

    private boolean isValidLine(int line, String[] document) {
        return line >= 0 && line < document.length;
    }

    private String[] readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().toArray(String[]::new);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    private void writeFile(String[] document) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : document) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    private char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    private int askInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private String askString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void printHorizontalLine() {
        System.out.println("-".repeat(50));
    }

    private String separator(int line) {
        return line == activeLine ? ":*| " : ": | ";
    }
}