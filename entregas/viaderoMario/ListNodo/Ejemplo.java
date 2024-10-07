package ListNodo;

class Ejemplo {
    public static void main(String[] args) {
        List nephews = new List();

       
        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");
        nephews.insertEnd("Luisito");

       
        viewList(nephews);
        System.out.println("PRIMERO: " + nephews.first.getValue());
        System.out.println("ULTIMO: " + getLastValue(nephews));

        
        List numbers = new List();
        numbers.insertEnd("5");
        numbers.insertEnd("6");
        numbers.insertEnd("7");
        numbers.insertEnd("8");

      
        viewList(numbers);
        System.out.println("PRIMERO: " + numbers.first.getValue());
        System.out.println("ULTIMO: " + getLastValue(numbers));
    }

    static void viewList(List list) {
        String[] larray = list.listAll();
        System.out.println("LA LISTA" + "-".repeat(18));
        for (String item : larray) {
            System.out.println(item);
        }
        System.out.println("-".repeat(25));
    }

    static String getLastValue(List list) {
        if (list.first == null) return null;
        Node iterator = list.first;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        return iterator.getValue(); 
    }
}