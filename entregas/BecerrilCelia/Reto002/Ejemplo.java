package Reto002;
public class Ejemplo {
    public static void main(String[] args) {
        List list = new List();
        
        list.insertFront("Anita");
        list.insertFront("Pepito");
        list.insertFront("Juanito");
        list.insertFront("Pepito");

        FoundNodeList foundNodes = list.find("Pepito");

        System.out.println("Nodos encontrados:");
        FoundNodeWrapper iterator = foundNodes.getFirst();
        while (iterator != null) {
            System.out.println(iterator.getNode().getValue());
            iterator = iterator.getNext();
        }
    }
}