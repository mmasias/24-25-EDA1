package entregas.reto11_10;

class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("¿Está vacía? " + nephews.isEmpty());

        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");
        nephews.insertEnd("Pepito");

        System.out.println("¿Está vacía? " + nephews.isEmpty());

        viewLine(nephews);

        FoundNodeList foundNephews = nephews.find("Pepito");
        System.out.println("Encontrados: " + foundNephews.size());
        viewFoundNodes(foundNephews);

        System.out.println("Lista original después de find:");
        viewLine(nephews);
    }

    static void viewLine(List filaDeSobrinos) {
        String[] larray = filaDeSobrinos.listAll();
        System.out.println("LA FILA" + "-".repeat(18));
        for (String sobrino : larray) {
            System.out.println(sobrino);
        }
        System.out.println("-".repeat(25));
    }

    static void viewFoundNodes(FoundNodeList foundList) {
        String[] larray = foundList.listAll();
        System.out.println("NODOS ENCONTRADOS" + "-".repeat(10));
        for (String nodeValue : larray) {
            System.out.println(nodeValue);
        }
        System.out.println("-".repeat(25));
    }
}
