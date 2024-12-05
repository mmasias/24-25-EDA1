package entregas.tasconRaul.Reto_006;
import java.util.Scanner;

public class Edlin {
    public static void main(String[] args) {
        Document document = new Document(10); 
        History history = new History(10);    
        document.initializeDefaultContent();

        int[] activeLine = {1};

        do {
            document.print(activeLine);
        } while (processActions(document, activeLine, history));
    }

    static boolean processActions(Document document, int[] activeLine, History history) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [C]opiar | [P]egar | [Z]Deshacer | [Y]Rehacer | [S]alir");

        switch (Utils.askChar()) {
            case 'S': case 's':
                return false;
            case 'L': case 'l':
                document.setActiveLine(activeLine);
                break;
            case 'E': case 'e':
                history.saveState(document);
                document.edit(activeLine);
                break;
            case 'I': case 'i':
                history.saveState(document);
                document.exchangeLines();
                break;
            case 'B': case 'b':
                history.saveState(document);
                document.delete(activeLine);
                break;
            case 'C': case 'c':
                document.copy(activeLine);
                break;
            case 'P': case 'p':
                history.saveState(document);
                document.paste(activeLine);
                break;
            case 'Z': case 'z':
                if (history.canUndo()) {
                    history.undo(document);
                    System.out.println("Deshacer realizado.");
                } else {
                    System.out.println("No hay acciones para deshacer.");
                }
                break;
            case 'Y': case 'y':
                if (history.canRedo()) {
                    history.redo(document);
                    System.out.println("Rehacer realizado.");
                } else {
                    System.out.println("No hay acciones para rehacer.");
                }
                break;
        }
        return true;
    }
}
