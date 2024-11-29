public class DocumentState {
    private final String[] lines;
    private final int activeLine;

    public DocumentState(String[] lines, int activeLine) {
        this.lines = lines.clone();
        this.activeLine = activeLine;
    }

    public DocumentState(DocumentState state) {
        this(state.getLines(), state.getActiveLine());
    }

    public String[] getLines() {
        return lines.clone();
    }

    public int getActiveLine() {
        return activeLine;
    }
}