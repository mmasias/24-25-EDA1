package entregas.tasconRaul.Reto_006;

public class History {
    private String[][] undoStack;
    private String[][] redoStack;
    private int undoTop = -1;
    private int redoTop = -1;

    public History(int maxSize) {
        this.undoStack = new String[maxSize][];
        this.redoStack = new String[maxSize][];
    }

    public void saveState(Document document) {
        if (undoTop < undoStack.length - 1) {
            undoStack[++undoTop] = document.getLines();
            redoTop = -1; 
        }
    }

    public void undo(Document document) {
        if (canUndo()) {
            redoStack[++redoTop] = document.getLines();
            document.setLines(undoStack[undoTop--]);
        }
    }

    public void redo(Document document) {
        if (canRedo()) {
            undoStack[++undoTop] = document.getLines();
            document.setLines(redoStack[redoTop--]);
        }
    }

    public boolean canUndo() {
        return undoTop >= 0;
    }

    public boolean canRedo() {
        return redoTop >= 0;
    }
}
