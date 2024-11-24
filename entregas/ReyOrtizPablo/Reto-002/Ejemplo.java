package entregas.ReyOrtizPablo.Reto0710;

public class Ejemplo {
    public static void main(String[] args) {
        List nephews = new List();

        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");
        nephews.insertEnd("Juanito");

        // Buscar nodos con el valor "Juanito"
        Node[] foundNodes = nephews.find("Juanito");

        System.out.println("Nodos encontrados con el valor 'Juanito': " + foundNodes.length);
        for (Node node : foundNodes) {
            System.out.println("Nodo encontrado: " + node.getValue());
        }
    }
}
