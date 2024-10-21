import java.io.DataInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //DataInputStream in=new DataInputStream(System.in);
        Scanner s= new Scanner(System.in);
        String i= "abababc";

        System.out.println("Ingrese la cadena a comprimir:");
        String cadena=s.next();

        Resultado r=comprime(cadena);

        r.getComprimidoList().show();
        r.getDiccionarioList().show();





    }


    public static Resultado comprime(String cadena){
        DiccionarioList listaD=new DiccionarioList();
        ComprimidoList listaC=new ComprimidoList();
        Resultado resultado=new Resultado(listaC,listaD);
        String cadenaActual;
        Comprimido nuevo=new Comprimido(1,"ababbacb");
        int end=1;
        int begin=0;
        boolean busqueda=true;
        int puntoDiccionario=0;
        while(begin<cadena.length()){
            while(busqueda) {
            cadenaActual=cadena.substring(begin,end);
                if (!listaD.search(cadenaActual)){
                    listaD.insertEnd(cadenaActual);

                    listaC.insertEnd(puntoDiccionario,cadena.substring(end-1,end));

                    busqueda=false;

                }
                end++;

                if(end>cadena.length()){
                    begin=end;
                    busqueda=false;
                }

                puntoDiccionario=listaD.searchNumber(cadenaActual); //obtener

            }


            puntoDiccionario=0;
            begin=end-1;
            busqueda=true;


        }

        return resultado;

    }
}