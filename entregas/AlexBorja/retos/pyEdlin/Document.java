class Document {
   String[] content = new String[10];
   String[][] history = new String[10][10];
   String[][] redohistory = new String[10][10];
   String copyBuffer = "";
   int historyIndex = 0;
   int redoIndex = 0;

   public Document() {
      this.content = new String[] {
            "Bienvenidos al editor EDLIN",
            "Utilice el menu inferior para editar el texto",
            "------",
            "[L] permite definir la linea activa",
            "[Z] permite retroceder al ultimo cambio",
            "[C] permite copiar una linea",
            "[V] permite pegar a una linea",
            "[E] permite editar la linea activa",
            "[I] permite intercambiar dos lineas",
            "[B] borra el contenido de la linea activa",
            "[S] sale del programa",
            "",
            ""
      };
   }

   public void saveHistory() {
      if (historyIndex < history.length) {
         history[historyIndex] = content.clone();
         historyIndex++;
      }
   }


   public void edit(int activeLine, String newContent) {
      this.saveHistory();
      this.content[activeLine] = newContent;
   }

   public String getActiveLine(int activeLine) {
      return this.content[activeLine];
   }

   public void copy(int lineToCopy) {
      this.saveHistory();
      this.copyBuffer = this.content[lineToCopy];
   }

   public void paste(int lineToPaste) {
      if (this.copyBuffer.length() > 0) {
         this.saveHistory();
         this.content[lineToPaste] = this.copyBuffer;
      }
   }

   public void undo() {
      if (historyIndex > 0) {
         historyIndex--;
         content = history[historyIndex];
      } else {
         System.out.println("No hay cambios para deshacer.");
      }
   }

   public void delete(int activeLine) {
      this.saveHistory();
      this.content[activeLine] = "";
   }

   public int getLength() {
      return this.content.length;
   }
}
