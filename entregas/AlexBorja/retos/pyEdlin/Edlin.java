import java.util.Scanner;

class Edlin {
   Document document;

   public Edlin() {
      this.document = new Document();
   }

   public void run() {
      int activeLine[] = { 1 };

      do {
         print(document, activeLine);
      } while (processActions(document, activeLine));
   }

   private void print(Document document, int[] activeLine) {
      clearScreen();
      printHorizontalLine();
      for (int line = 0; line < document.getLength(); line++) {
         System.out.println(line + separator(line, activeLine[0]) + document.getActiveLine(line));
      }
      printHorizontalLine();
   }

   private String separator(int line, int activeLine) {
      return line == activeLine ? ":*| " : ": | ";
   }

   private void printHorizontalLine() {
      System.out.println("-".repeat(50));
   }

   private void clearScreen() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
   }

   private boolean processActions(Document document, int[] activeLine) {
      System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");

      switch (askChar()) {
         case 'S':
         case 's':
            return false;
         case 'L':
         case 'l':
            setActiveLine(document, activeLine);
            break;
         case 'Z':
         case 'z':
            unDoAction(document, activeLine);
            break;
         case 'C':
         case 'c':
            copy(document);
            break;
         case 'V':
         case 'v':
            paste(document);
            break;
         case 'E':
         case 'e':
            edit(document, activeLine);
            break;
         case 'I':
         case 'i':
            exchangeLines(document);
            break;
         case 'B':
         case 'b':
            delete(document, activeLine);
            break;
      }
      return true;
   }

   private char askChar() {
      Scanner input = new Scanner(System.in);
      return input.next().charAt(0);
   }

   private void delete(Document document, int[] activeLine) {
      System.out.println(
            "Esta acción es irreversible: indique el número de línea activa para confirmarlo [" + activeLine[0] + "]");
      if (askInt() == activeLine[0]) {
         document.delete(activeLine[0]);
      }
   }

   private void exchangeLines(Document document) {
      int originLine, destinationLine;
      String temporaryLine;
      boolean validLine = true;

      do {
         System.out.print("Indique primera línea a intercambiar: ");
         originLine = askInt();
         validLine = originLine >= 0 && originLine < document.getLength();
      } while (!validLine);

      do {
         System.out.print("Indique segunda línea a intercambiar: ");
         destinationLine = askInt();
         validLine = destinationLine >= 0 && destinationLine < document.getLength();
      } while (!validLine);

     temporaryLine = document.getActiveLine(destinationLine);
      document.edit(destinationLine, document.getActiveLine(originLine));
      document.edit(originLine, temporaryLine);
   }

   private void copy(Document document) {
      int copyLine;
      boolean validLine = true;

      do {
         System.out.print("Indique la linea a copiar: ");
         copyLine = askInt();
         validLine = copyLine >= 0 && copyLine < document.getLength();
      } while (!validLine);


      System.out.print("Linea " + copyLine + " copiada");
      document.copy(copyLine);
   }

   private void paste(Document document) {
      int pasteLine;
      boolean validLine = true;

      do {
         System.out.print("Indique en que linea pegar: ");
         pasteLine = askInt();
         validLine = pasteLine >= 0 && pasteLine < document.getLength();
      } while (!validLine);


      System.out.print("Linea " + pasteLine + " pegaga");
      document.paste(pasteLine);
   }

   private void unDoAction(Document document, int[] activeLine) {
      document.undo();
   }

   private void edit(Document document, int[] activeLine) {
      System.out.println("EDITANDO> " + document.getActiveLine(activeLine[0]));
      document.edit(activeLine[0], askString());
   }

   private String askString() {
      Scanner input = new Scanner(System.in);
      return input.nextLine();
   }

   private void setActiveLine(Document document, int[] activeLine) {
      boolean validLine = true;
      do {
         System.out.print("Indique la nueva línea activa: ");
         activeLine[0] = askInt();
         validLine = activeLine[0] >= 0 && activeLine[0] < document.getLength();
      } while (!validLine);
   }

   private int askInt() {
      Scanner input = new Scanner(System.in);
      return input.nextInt();
   }
}
