package entregas.grizoniManuela.reto002;

class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("Esta vacia? " + nephews.isEmpty());

        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");

        System.out.println("Esta vacia? " + nephews.isEmpty());
        viewLine(nephews);

        nephews.insertEnd("Luisito");

        System.out.println("Tamaño: " + nephews.size());
        viewLine(nephews);

        nephews.deleteFront();
        nephews.deleteEnd();

        System.out.println("Tamaño: " + nephews.size());
        viewLine(nephews);
      
        System.out.println("Buscando nodos con valor 'Pepito':");
        FoundNodeList foundNodes = nephews.find("Pepito");
        
        if (foundNodes.isEmpty()) {
            System.out.println("No se encontraron nodos con el valor 'Pepito'.");
        } else {
            System.out.println("Se encontraron " + foundNodes.size() + " nodo(s) con el valor 'Pepito':");
            viewLine(foundNodes);
        }

        nephews.clear();
        System.out.println("Tamaño: " + nephews.size());
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

    static void viewLine(FoundNodeList foundNodes) {
        String[] larray = foundNodes.listAll();
        System.out.println("LA FILA" + "-".repeat(18));
        for (String sobrino : larray) {
            System.out.println(sobrino);
        }
        System.out.println("-".repeat(25));
    }
}
