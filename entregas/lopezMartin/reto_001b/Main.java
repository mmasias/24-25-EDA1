package entregas.lopezMartin.reto_001b;

public class Main {

    public static void main(String[] args) {
        
        Registros registros = new Registros();
        registros.añadir("A");
        registros.añadir("B");
        registros.añadir("C");
        registros.mostrar();

        System.out.println("ORDEN: A --> C --> B");
        registros.mostrarEnOrden("A", "C", "B");

        System.out.println("ORDEN: B --> C --> A");
        registros.mostrarEnOrden("B", "C", "A");

        System.out.println("Eliminamos B:");
        registros.eliminar("B");
        registros.mostrar();

        System.out.println("Agregamos D y E y eliminamos C:");
        registros.añadir("D");
        registros.añadir("E");
        registros.eliminar("C");
        registros.mostrar();

    }
    
}
