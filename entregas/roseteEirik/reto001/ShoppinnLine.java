package entregas.roseteEirik.reto001;

public class ShoppinnLine {
    
    private Person[] persons;

    public ShoppinnLine(int numberOfPersons) {
        this.persons = new Person[numberOfPersons];
        for (int customerNumber = 0; customerNumber < numberOfPersons; customerNumber++) {
        persons[customerNumber] = new Person();
        }
    }
    public ShoppinnLine() {
        this.persons = new Person[(int)(Math.random()*10)];
        for (int customerNumber = 0; customerNumber < persons.length; customerNumber++) {
            persons[customerNumber] = new Person();
        }
    }

    public Person[] showShoppingLine() {
        for (int customerNumber = 0; customerNumber < persons.length; customerNumber++) {
            System.out.print("[" + customerNumber + " - " + persons[customerNumber].getQuantityOfItems() + "] ");
        }
        return persons;
    }

}
