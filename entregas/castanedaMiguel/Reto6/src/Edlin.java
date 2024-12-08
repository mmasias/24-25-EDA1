import java.io.File;
import java.util.Scanner;

class Edlin {
    static FileManager fl=new FileManager("archivo.txt");
    public static void main(String[] args) {
        int activeLine[] = { 1 };


        fl.createFile("Bienvenidos al editor EDLIN,\nUtilice el menu inferior para editar el texto, \n------, \n[L] permite definir la linea activa, \n[E] permite editar la linea activa, \n[I] permite intercambiar dos lineas, \n[B] borra el contenido de la linea activa, \n[D] deshace el último cambio, \n[R] retira la línea deshecha, \n[S] sale del programa,\n \n ");

        String document[] = {
                "Bienvenidos al editor EDLIN",
                "Utilice el menu inferior para editar el texto",
                "------",
                "[L] permite definir la linea activa",
                "[E] permite editar la linea activa",
                "[I] permite intercambiar dos lineas",
                "[B] borra el contenido de la linea activa",
                "[D] deshace el último cambio",
                "[R] retira la línea deshecha",
                "[S] sale del programa",
                "",
                ""
        };


        String file;
        do {
            //print(document, activeLine);
            file=fl.readFile();
            System.out.println(file);
        } while (processActions(document, activeLine));

        fl.deleteFile();
    }
    //private static ListaNodo listaPrincipal=new ListaNodo();
    private static ListaNodo listaDeshacer=new ListaNodo();
    private static ListaNodo listaRehacer=new ListaNodo();
    static void print(String[] document, int[] activeLine) {
        clearScreen();
        printHorizontalLine();
        for (int line = 0; line < document.length; line++) {
            System.out.println(line + separator(line, activeLine[0]) + document[line]);
        }
        printHorizontalLine();
    }

    static String separator(int line, int activeLine) {
        return line == activeLine ? ":*| " : ": | ";
    }

    static void printHorizontalLine() {
        System.out.println("-".repeat(50));
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static boolean processActions(String[] document, int[] activeLine) {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [R]etirar | [S]alir");

        switch (askChar()) {
            case 'S':   case 's':
                return false;
            case 'L':   case 'l':
                setActiveLine(document, activeLine);
                break;
            case 'E':   case 'e':
                edit(document, activeLine);
                break;
            case 'I':   case 'i':
                exchangeLines(document);
                break;
            case 'B':   case 'b':
                escribeLista(document, activeLine);
                delete(document, activeLine);
                break;
            case 'D': case 'd':
                deshacer(document,activeLine);
                break;
            case 'R': case 'r':
                rehacer(document,activeLine);
                break;
        }
        return true;
    }

    static void setActiveLine(String[] document, int[] activeLine) {
        boolean validLine = true;
        do {
            System.out.print("Indique la nueva línea activa: ");
            activeLine[0] = askInt();
            validLine = activeLine[0] >= 0 && activeLine[0] < document.length;
        } while (!validLine);
    }
    static void edit(String[] document, int[] activeLine) {
        System.out.println("EDITANDO> " + document[activeLine[0]]);
        escribeLista(document, activeLine);
        edit(document, activeLine, askString());

    }

    static void edit(String[] document, int[] activeLine, String nuevaLinea){
        document[activeLine[0]] = nuevaLinea;
        fl.updateLine(activeLine[0], nuevaLinea);
    }

    static void exchangeLines(String[] document){
        int originLine, destinationLine;
        String temporaryLine;
        boolean validLine = true;

        do {
            System.out.print("Indique primera línea a intercambiar: ");
            originLine = askInt();
            validLine = originLine >= 0 && originLine < document.length;
        } while (!validLine);

        do {
            System.out.print("Indique segunda línea a intercambiar: ");
            destinationLine = askInt();
            validLine = destinationLine >= 0 && destinationLine < document.length;
        } while (!validLine);
        //escribeLista(document,);
        listaRehacer.insertarPrimerNodo(new Nodo(0,""));
        listaRehacer.getNodo().setLineas(originLine,destinationLine);
        exchangeLines( document, originLine, destinationLine);

    }

    static void exchangeLines(String[] document, int originLine, int destinationLine) {
        String temporaryLine;
        temporaryLine = document[destinationLine];
        document[destinationLine]=document[originLine];
        document[originLine]=temporaryLine;
    }

    static void delete(String[] document, int[] activeLine) {
            document[activeLine[0]]="";
            fl.deleteLine(activeLine[0]);
    }

    static void deshacer(String[] document, int[] activeLine){
        if(listaDeshacer.getNodo()!=null) {
            String contenido = listaDeshacer.getNodo().getContenido();
            listaRehacer.insertarPrimerNodo(new Nodo(activeLine[0], document[activeLine[0]]));
            listaDeshacer.quitarPrimerNodo();
            if(listaRehacer.getNodo().intercambio){
                exchangeLines(document,listaRehacer.getNodo().lineas[0],listaRehacer.getNodo().lineas[1]);
            }else{edit(document, activeLine, contenido);}

        }else{
            System.out.println("No hay líneas que deshacer");
        }
    }

    static void rehacer(String[] document, int[] activeLine){
        if(listaRehacer.getNodo()!=null) {
            String contenido = listaRehacer.getNodo().getContenido();
            listaDeshacer.insertarPrimerNodo(new Nodo(activeLine[0], document[activeLine[0]]));
            listaRehacer.quitarPrimerNodo();
            if(listaDeshacer.getNodo().intercambio){
                exchangeLines(document,listaDeshacer.getNodo().lineas[0],listaDeshacer.getNodo().lineas[1]);
            }else{edit(document, activeLine, contenido);}
        }else{
            System.out.println("No hay líneas que rehacer");
        }
    }

    static void escribeLista(String[] document, int[] activeLine){
        listaRehacer.clear();
        listaDeshacer.insertarPrimerNodo(new Nodo(activeLine[0], document[activeLine[0]]));
    }

    static char askChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    static String askString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    static int askInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}