
class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("Esta vacia? " + nephews.isEmpty());

        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");
        nephews.insertEnd("Pepito");
        System.out.println("Esta vacia? " + nephews.isEmpty());

        viewLine(nephews);

        nephews.insertEnd("Luisito");
        nephews.insertFront("María");
        System.out.println("Tamaño: " + nephews.size());

        nephews.deleteEnd();
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);
        FoundNodeList foundNodes = nephews.find("Pepito");
        System.out.println("Nodos encontrados con valor 'Pepito': " + foundNodes.size);
        viewLine(foundNodes);
        nephews.clear();
        System.out.println("Tamaño después de limpiar la lista: " + nephews.size());
        viewLine(nephews);
    }

    static void viewLine(FoundNodeList foundList) {
        Node[] larray = foundList.listAll();
        System.out.println("LA FILA" + "-".repeat(18));
        for (Node node : larray) {
            System.out.println(node.getValue());
        }
        System.out.println("-".repeat(25));
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
