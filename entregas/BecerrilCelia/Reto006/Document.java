package Reto006;

import java.util.Stack;
import java.util.Arrays;

public class Document {
    private static final int MAX_LINES = 10;
    private String[] lines;
    private Stack<String[]> undoStack;
    private Stack<String[]> redoStack;
    private String[] savedDocument = null;
    private String savedDocumentName = null;

    public Document() {
        this.lines = new String[MAX_LINES];
        for (int i = 0; i < MAX_LINES; i++) {
            lines[i] = ""; 
        }
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    private void saveStateForUndo() {
        undoStack.push(Arrays.copyOf(lines, lines.length));
        redoStack.clear(); 
    }
    public void saveDocument() {
        if (savedDocument == null) {
            savedDocument = Arrays.copyOf(lines, lines.length);
            savedDocumentName = "documento_actual";
            System.out.println("Documento guardado en memoria con nombre: " + savedDocumentName);
        } else {
            System.out.println("El documento ya está guardado en memoria.");
        }
    }

    public void loadDocument() {
        if (savedDocument != null) {
            saveStateForUndo();
            lines = Arrays.copyOf(savedDocument, savedDocument.length);
            System.out.println("Documento '" + savedDocumentName + "' cargado.");
        } else {
            System.out.println("No hay documentos guardados en memoria.");
        }
    }
    
    public void saveAsDocument() {
        System.out.print("Ingrese un nombre para guardar el documento en memoria: ");
        String documentName = UserInput.askString();
        
        savedDocument = Arrays.copyOf(lines, lines.length);
        savedDocumentName = documentName;
        
        System.out.println("Documento guardado en memoria con nombre: " + savedDocumentName);
    }



    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(Arrays.copyOf(lines, lines.length));
            lines = undoStack.pop();
            System.out.println("Deshacer realizado.");
        } else {
            System.out.println("No hay nada que deshacer.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(Arrays.copyOf(lines, lines.length));
            lines = redoStack.pop();
            System.out.println("Rehacer realizado.");
        } else {
            System.out.println("No hay nada que rehacer.");
        }
    }

    public void setActiveLine(int activeLine) {
        if (activeLine >= 0 && activeLine < lines.length) {
            System.out.println("Línea activa: " + lines[activeLine]);
        } else {
            System.out.println("Número de línea inválido.");
        }
    }

    public void edit(int lineNumber) {
        if (lineNumber >= 0 && lineNumber < lines.length) {
            saveStateForUndo();
            System.out.println("Editar línea [" + lineNumber + "]: " + lines[lineNumber]);
            System.out.print("Nueva línea: ");
            lines[lineNumber] = UserInput.askString();
        } else {
            System.out.println("Número de línea inválido.");
        }
    }

    public void delete(int activeLine) {
        saveStateForUndo();
        System.out.println("Esta acción es irreversible: indique el número de línea activa para confirmarlo [" + activeLine + "]");
        if (UserInput.askInt() == activeLine) {
            lines[activeLine] = "";
            System.out.println("Línea " + activeLine + " eliminada.");
        } else {
            System.out.println("Número de línea incorrecto. No se eliminó la línea.");
        }
    }

    public void exchangeLines() {
        saveStateForUndo();
        System.out.print("Ingrese el número de la primera línea a intercambiar: ");
        int line1 = UserInput.askInt();
        System.out.print("Ingrese el número de la segunda línea a intercambiar: ");
        int line2 = UserInput.askInt();

        if (line1 >= 0 && line1 < lines.length && line2 >= 0 && line2 < lines.length) {
            String temp = lines[line1];
            lines[line1] = lines[line2];
            lines[line2] = temp;
            System.out.println("Líneas " + line1 + " y " + line2 + " intercambiadas.");
        } else {
            System.out.println("Número de línea inválido.");
        }
    }

    public String getLine(int lineNumber) {
        if (lineNumber >= 0 && lineNumber < lines.length) {
            return lines[lineNumber];
        } else {
            return "Número de línea inválido.";
        }
    }

    public void setLine(int lineNumber, String text) {
        if (lineNumber >= 0 && lineNumber < lines.length) {
            saveStateForUndo();
            lines[lineNumber] = text;
        } else {
            System.out.println("Número de línea inválido.");
        }
    }

    public void printDocument() {
        System.out.println("Contenido del documento:");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(i + ": " + lines[i]);
        }
    }
}