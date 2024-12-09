public class History {
    private DocumentState currentState;
    private DocumentState undoState;
    private DocumentState redoState;

    public History(Document document) {
        this.currentState = new DocumentState(document.getLines(), document.getActiveLineIndex());
        this.undoState = null;
        this.redoState = null;
    }

    public void save(Document document) {
        undoState = new DocumentState(currentState);
        currentState = new DocumentState(document.getLines(), document.getActiveLineIndex());
        redoState = null;
    }

    public void undo(Document document) {
        if (undoState != null) {
            redoState = new DocumentState(currentState);
            currentState = new DocumentState(undoState);
            undoState = null;
            applyState(document);
        }
    }

    public void redo(Document document) {
        if (redoState != null) {
            undoState = new DocumentState(currentState);
            currentState = new DocumentState(redoState);
            redoState = null;
            applyState(document);
        }
    }

    private void applyState(Document document) {
        document.setLines(currentState.getLines());
        document.setActiveLine(currentState.getActiveLine());
    }
}