package entregas.nevesKelvia.Reto_002;

class Ejemplo {
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

        System.out.println("Buscando elementos que contengan 'ito'...");
        FoundNodeList found = nephews.find("ito");
        for (String value : found.listAll()) {
            System.out.println("Encontrado: " + value);
        }

        System.out.println("Limpiando toda la lista...");
        nephews.clear();
        viewLine(nephews);
        System.out.println("¿Está vacía? " + nephews.isEmpty());
    }

    static void viewLine(List filaDeSobrinos) {
        String[] larray = filaDeSobrinos.listAll();
        System.out.println("LA FILA" + "-".repeat(18));
        for (String sobrino : larray){
            System.out.println(sobrino);
        }
        System.out.println("-".repeat(25));
    }
}
