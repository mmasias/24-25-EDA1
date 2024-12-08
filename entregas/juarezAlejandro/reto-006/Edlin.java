class Edlin {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(new String[] {
                "Bienvenidos al editor EDLIN",
                "Utilice el menu inferior para editar el texto",
                "------",
                "[L] permite definir la linea activa",
                "[E] permite editar la linea activa",
                "[I] permite intercambiar dos lineas",
                "[B] borra el contenido de la linea activa",
                "[D] deshace la última acción de la activa",
                "[R] rehacer la última acción deshecha",
                "[C] copia el contenido de la linea activa",
                "[P] pega el contenido de la linea activa",
                "[S] sale del programa",
                "",
                ""
        });

        do {
            editor.print();
        } while (editor.processActions());
    }
}