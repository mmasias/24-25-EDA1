public class Ejemplo {
    public static void main(String[] args) {
        List nephews = new List();

        viewLine(nephews);
        System.out.println("Está vacía? " + nephews.isEmpty());

        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");

        System.out.println("Está vacía? " + nephews.isEmpty());

        viewLine(nephews);

        nephews.insertEnd("Luisito");

        System.out.println("Tamaño: " + nephews.size());

        nephews.deleteEnd();
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);
    }

    static void viewLine(List lista) {
        String[] array = lista.listAll();
        System.out.println("LA FILA" + "-".repeat(18));
        for (String sobrino : array) {
            System.out.println(sobrino);
        }
        System.out.println("-".repeat(25));
    }
}
