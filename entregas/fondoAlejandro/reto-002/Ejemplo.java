class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("Esta vacia? " + nephews.isEmpty());

        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");

        System.out.println("Esta vacia? " + nephews.isEmpty());

        viewLine(nephews);

        nephews.insertEnd("Luisito");
        nephews.insertEnd("Pepito");

        System.out.println("Tamaño: " + nephews.size());
        viewLine(nephews);

        System.out.println("Buscando 'Pepito' en la lista...");
        FoundNodeList foundNodes = nephews.find("Pepito");
        System.out.println("Resultados: " + foundNodes);

        nephews.deleteEnd();
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);

        nephews.deleteFront();
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);

        nephews.deleteAll();
        System.out.println("Tamaño: " + nephews.size());
        
        viewLine(nephews);
        
        System.out.println("Esta vacia? " + nephews.isEmpty());
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