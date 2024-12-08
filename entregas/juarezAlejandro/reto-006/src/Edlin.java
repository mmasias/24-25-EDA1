package src;

class Edlin {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor("Edlin.txt");
        editor.initialize();

        do {
            editor.print();
        } while (editor.processActions());
    }
}