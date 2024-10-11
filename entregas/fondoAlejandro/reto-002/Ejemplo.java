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

        System.out.println("Tamaño: " + nephews.size());

        nephews.deleteEnd();
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);

        nephews.deleteFront();
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);

        String searchValue = "Juanito";
        Node[] finalResults = nephews.find(searchValue);
        for (int i = 0; i < finalResults.length; i++) {
            if (finalResults[i] != null) {
                System.out.println("Sobrinos encontrados con el nombre " + searchValue + ": " + finalResults[i].getValue());
            }
        }

        String searchValue2 = "Anita";
        Node[] finalResults2 = nephews.find(searchValue2);
        for (int i = 0; i < finalResults2.length; i++) {
            if (finalResults2[i] != null) {
                System.out.println("Sobrinos encontrados con el nombre " + searchValue2 + ": " + finalResults2[i].getValue());
            }
        }

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