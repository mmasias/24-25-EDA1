public class Document {
    private String[] lines;
    private int activeLine;

    public Document(String[] initialLines) {
        this.lines = initialLines;
        this.activeLine = 0;
    }

    public void print() {
        clearScreen();
        printHorizontalLine();
        for (int i = 0; i < lines.length; i++) {
            System.out.println(i + separator(i) + lines[i]);
        }
        printHorizontalLine();
    }

    public void setActiveLine(int lineIndex) {
        if (isValidLine(lineIndex)) {
            activeLine = lineIndex;
        }
    }

    public void editLine(String newContent) {
        lines[activeLine] = newContent;
    }

    public void exchangeLines(int line1, int line2) {
        if (isValidLine(line1) && isValidLine(line2)) {
            String temp = lines[line1];
            lines[line1] = lines[line2];
            lines[line2] = temp;
        }
    }

    public void deleteLine() {
        lines[activeLine] = "";
    }

    public int getActiveLineIndex() {
        return activeLine;
    }

    public String getActiveLineContent() {
        return lines[activeLine];
    }

    private boolean isValidLine(int lineIndex) {
        return lineIndex >= 0 && lineIndex < lines.length;
    }

    private String separator(int lineIndex) {
        return lineIndex == activeLine ? ":*| " : ": | ";
    }

    private void printHorizontalLine() {
        System.out.println("-".repeat(50));
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}