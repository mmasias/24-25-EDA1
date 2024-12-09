class UndoRedoManager {
    private final String[][] undoMatrix;
    private final String[][] redoMatrix;
    private final int maxUndo;
    private int undoIndex = 0;
    private int undoCount = 0;
    private int redoIndex = 0;
    private int redoCount = 0;

    public UndoRedoManager(int maxUndo, int documentSize) {
        this.maxUndo = maxUndo;
        this.undoMatrix = new String[maxUndo][documentSize];
        this.redoMatrix = new String[maxUndo][documentSize];
    }

    public void saveState(String[] document) {
        undoMatrix[undoIndex] = cloneDocument(document);
        undoIndex = (undoIndex + 1) % maxUndo;
        if (undoCount < maxUndo) {
            undoCount++;
        }
        redoCount = 0;
    }

    public boolean undo(String[] document) {
        if (undoCount > 0) {
            undoIndex = (undoIndex - 1 + maxUndo) % maxUndo;
            String[] previousState = undoMatrix[undoIndex];
            redoMatrix[redoIndex] = cloneDocument(document);
            redoIndex = (redoIndex + 1) % maxUndo;
            if (redoCount < maxUndo) {
                redoCount++;
            }
            for (int i = 0; i < document.length; i++) {
                document[i] = previousState[i];
            }
            undoCount--;
            return true;
        }
        return false;
    }

    public boolean redo(String[] document) {
        if (redoCount > 0) {
            redoIndex = (redoIndex - 1 + maxUndo) % maxUndo;
            String[] nextState = redoMatrix[redoIndex];
            undoMatrix[undoIndex] = cloneDocument(document);
            undoIndex = (undoIndex + 1) % maxUndo;
            if (undoCount < maxUndo) {
                undoCount++;
            }
            for (int i = 0; i < document.length; i++) {
                document[i] = nextState[i];
            }
            redoCount--;
            return true;
        }
        return false;
    }

    private String[] cloneDocument(String[] document) {
        String[] clone = new String[document.length];
        System.arraycopy(document, 0, clone, 0, document.length);
        return clone;
    }
}