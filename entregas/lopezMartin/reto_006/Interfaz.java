package entregas.lopezMartin.reto_006;
import java.util.Scanner;

public class Interfaz {

    private Lista lineasTexto;
    private String portapapeles;
    private Pila versionesAnteriores;
    private Pila versionesPosteriores;

    public Interfaz(Lista lineasTexto, Pila versionesAnteriores, Pila versionesPosteriores){

        this.lineasTexto = lineasTexto;
        this.versionesAnteriores = versionesAnteriores;
        this.versionesPosteriores = versionesPosteriores;
        this.portapapeles = null;

    }

    public void mostrar(){
        Scanner sc = new Scanner(System.in);
        boolean ejecutando = true;
        System.out.println("Bienvenidos el editor EDLIN");
        while(ejecutando){
            lineasTexto.print();
            System.out.println("Utilice el menu inferior para editar el texto \n ------ \n [L] Permite definir la linea activa \n [E] Permite editar la linea activa \n [I] Permite intercambiar dos lineas \n [B] Borrar el contenido de la linea activa \n [D] Deshacer cambios \n [R] Rehacer cambios \n [C] Copiar contenido de la linea activa \n [P] Pegar contenido en la linea activa \n[S] Salir del programa \n");
            String input = sc.nextLine();
            switch (input.toUpperCase()) {
                case "L":
                    System.out.println("Introduce el índice de la linea: ");
                    int indiceLinea = sc.nextInt();
                    lineasTexto.cambiarLineaActiva(indiceLinea);
                    break;
    
                case "E":
                    System.out.println("Introduce el contenido nuevo: ");
                    String contenido = sc.nextLine();
                    versionesAnteriores.apilar(lineasTexto.obtenerLineaActiva().obtenerIndice(), lineasTexto.obtenerLineaActiva().obtenerContenido());
                    lineasTexto.editarLinea(contenido);
                    break;
    
                case "I": 
                    System.out.println("Introduce los índices de las lineas que deseas intercambiar");
                    int indiceL1= sc.nextInt();
                    int indiceL2= sc.nextInt();
                    lineasTexto.intercambiarLineas(indiceL1, indiceL2);
                    break;
    
                case "B":
                    versionesAnteriores.apilar(lineasTexto.obtenerLineaActiva().obtenerIndice(), lineasTexto.obtenerLineaActiva().obtenerContenido());
                    lineasTexto.borrarLineaActiva();
                    break;
    
                case "D":
                    String contenidoAnterior = versionesAnteriores.desapilar();
                    lineasTexto.editarLinea(contenidoAnterior);
                    versionesPosteriores.apilarVersion(versionesAnteriores.obtenerCima());
                    versionesAnteriores.reordenarCima();
                    break;
    
                case "R":
                    String contenidoPosterior = versionesPosteriores.desapilar();
                    lineasTexto.editarLinea(contenidoPosterior);
                    versionesAnteriores.apilarVersion(versionesPosteriores.obtenerCima());
                    versionesPosteriores.reordenarCima();
                    break;

                case "C":
                    portapapeles = lineasTexto.obtenerLineaActiva().obtenerContenido();
                    break;

                case "P":
                    versionesAnteriores.apilar(lineasTexto.obtenerLineaActiva().obtenerIndice(), lineasTexto.obtenerLineaActiva().obtenerContenido());
                    lineasTexto.editarLinea(portapapeles);
                    break;
    
                case "S":
                    ejecutando = false;
                    break;
            
                default:
                    System.out.println("Entrada incorrecta, intente de nuevo");
            }
        }
    }
    
}
