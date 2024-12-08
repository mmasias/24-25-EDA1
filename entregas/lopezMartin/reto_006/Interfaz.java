package entregas.lopezMartin.reto_006;
import java.util.Scanner;

public class Interfaz {

    private Lista lineasTexto;
    private String portapapeles;
    private Pila versionesAnteriores;
    private Pila versionesPosteriores;
    private FileManager manager;

    public Interfaz(Lista lineasTexto, Pila versionesAnteriores, Pila versionesPosteriores, FileManager manager){

        this.lineasTexto = lineasTexto;
        this.versionesAnteriores = versionesAnteriores;
        this.versionesPosteriores = versionesPosteriores;
        this.portapapeles = null;
        this.manager = manager;

    }

    public void mostrar(){
        Scanner sc = new Scanner(System.in);
        boolean creado = manager.createFile((lineasTexto.obtenerLineaActiva().obtenerContenido() + "\n").repeat(lineasTexto.obtenerNumeroLineas()-1) + lineasTexto.obtenerLineaActiva().obtenerContenido());
        if (creado) {
            System.out.println("Archivo creado con exito");
        }else{
            System.out.println("Error al crear el archivo");
        }
        boolean ejecutando = true;
        System.out.println("Bienvenidos el editor EDLIN");
        while(ejecutando && creado){
            System.out.println(manager.readFile());
            System.out.println("Utilice el menu inferior para editar el texto \n ------ \n [L] Permite definir la linea activa \n [E] Permite editar la linea activa \n [I] Permite intercambiar dos lineas \n [B] Borrar el contenido de la linea activa \n [D] Deshacer cambios \n [R] Rehacer cambios \n [C] Copiar contenido de la linea activa \n [P] Pegar contenido en la linea activa \n[S] Salir del programa \n");
            String input = sc.nextLine();
            switch (input.toUpperCase()) {
                case "L":
                    System.out.println("Introduce el índice de la linea: ");
                    String indiceLinea = sc.nextLine();
                    lineasTexto.cambiarLineaActiva(Integer.parseInt(indiceLinea));
                    break;
    
                case "E":
                    versionesAnteriores.apilar(lineasTexto.obtenerLineaActiva().obtenerIndice(), lineasTexto.obtenerLineaActiva().obtenerContenido());
                    System.out.println("Introduce el contenido nuevo: ");
                    String contenido = sc.nextLine();
                    lineasTexto.editarLinea(contenido);
                    boolean editado = manager.updateLine(lineasTexto.obtenerLineaActiva().obtenerIndice(), lineasTexto.obtenerLineaActiva().obtenerContenido());
                    if (editado) {
                        System.out.println("Línea modificada con éxito");
                    } else {
                        System.out.println("Error al modificar la línea");
                    }
                    break;
    
                case "I": 
                    System.out.println("Introduce los índices de las lineas que deseas intercambiar");
                    String indiceL1= sc.nextLine();
                    String indiceL2= sc.nextLine();
                    lineasTexto.intercambiarLineas(Integer.parseInt(indiceL1), Integer.parseInt(indiceL2), manager);
                    break;
    
                case "B":
                    versionesAnteriores.apilar(lineasTexto.obtenerLineaActiva().obtenerIndice(), lineasTexto.obtenerLineaActiva().obtenerContenido());
                    lineasTexto.borrarLineaActiva();
                    boolean borrado = manager.updateLine(lineasTexto.obtenerLineaActiva().obtenerIndice(), lineasTexto.obtenerLineaActiva().obtenerContenido());
                    if (borrado) {
                       System.out.println("Linea borrada con exito"); 
                    }else{
                        System.out.println("Error al borrar la linea");
                    }
                    break;
    
                case "D":
                    lineasTexto.deshacerCambios(versionesAnteriores, versionesPosteriores);
                    break;
    
                case "R":
                    lineasTexto.rehacerCambios(versionesPosteriores, versionesAnteriores);
                    break;

                case "C":
                    portapapeles = lineasTexto.obtenerLineaActiva().obtenerContenido();
                    break;

                case "P":
                    versionesAnteriores.apilar(lineasTexto.obtenerLineaActiva().obtenerIndice(), lineasTexto.obtenerLineaActiva().obtenerContenido());
                    lineasTexto.pegar(portapapeles);
                    break;
    
                case "S":
                    ejecutando = false;
                    break;
            
                default:
                    System.out.println(input.toUpperCase());
                    System.out.println("Entrada incorrecta, intente de nuevo");
            }
        }
    }
    
}
