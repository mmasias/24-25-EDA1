package entregas.roseteEirik.reto001;

public class Person {

    private int quantityOfItems;

    public Person(int quantityOfItems) {
    }
    
    public Person() {
        this.quantityOfItems = (int)((Math.random())*15) + 1;
    }

    public int getQuantityOfItems() {
        return quantityOfItems;
    }
}
