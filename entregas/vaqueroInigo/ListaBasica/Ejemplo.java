package entregas.vaqueroInigo.ListaBasica;

public class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("¿Está vacía? " + nephews.isEmpty());

        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");

        System.out.println("¿Está vacía? " + nephews.isEmpty());

        viewLine(nephews);

        nephews.insertEnd("Luisito");

        System.out.println("Tamaño: " + nephews.size());

        nephews.deleteEnd();
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);

        // Ejemplo de uso del método search
        Node found = nephews.search("Pepito");
        if (found != null) {
            System.out.println("Se encontró: " + found.getValue());
        } else {
            System.out.println("No se encontró el valor");
        }
    }

    static void viewLine(List filaDeSobrinos) {
        
        String[] larray = filaDeSobrinos.listAll();
        System.out.println("LA FILA" + "-".repeat(18));
        for (String sobrino : larray) {
            System.out.println(sobrino);
        }
        System.out.println("-".repeat(25));
    }
}


