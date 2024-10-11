class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();
        nephews.showInConsole();
        System.out.println("Esta vacia? " + nephews.isEmpty());

        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");
        System.out.println("Esta vacia? " + nephews.isEmpty());

        nephews.showInConsole();
        nephews.insertEnd("Luisito");

        System.out.println("Tamaño: " + nephews.size());

        nephews.deleteEnd();

        System.out.println("Tamaño: " + nephews.size());
        nephews.showInConsole();
        nephews.deleteFront();
        nephews.showInConsole();
    }
}
 