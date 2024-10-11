package entregas.lopesBrenda.reto002;

class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");
        nephews.insertEnd("Pepito");

        System.out.println("Tamaño: " + nephews.size());
        viewLine(nephews);
    
        FoundNodeList foundNodes = nephews.find("Pepito");

        System.out.println("Nodos encontrados: " + foundNodes.size());
        viewLine(foundNodes); 

        viewLine(nephews);
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