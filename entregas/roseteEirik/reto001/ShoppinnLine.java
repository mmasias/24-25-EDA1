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
        this.persons = new Person[(int) (Math.random() * 10 + 10)];
        for (int customerNumber = 0; customerNumber < persons.length; customerNumber++) {
            persons[customerNumber] = new Person();
        }
    }

    public Person[] showShoppingLine() {
        for (int customerNumber = 0; customerNumber < persons.length; customerNumber++) {
            System.out.print("[Cliente: " + customerNumber + " - Items: " + persons[customerNumber].getQuantityOfItems()
                    + "] \n");
        }
        return persons;
    }

    public void popPerson() {
        int numberOfPersons = persons.length;
        Person[] newPersons = new Person[numberOfPersons - 1];
        for (int customerNumber = 0; customerNumber < numberOfPersons - 1; customerNumber++) {
            newPersons[customerNumber] = persons[customerNumber + 1];
        }
        persons = newPersons;
    }

    public void popRandomPerson() {
        int numberOfPersons = persons.length;
        int randomPerson = (int) (Math.random() * numberOfPersons);
        Person[] newPersons = new Person[numberOfPersons - 1];
        for (int customerNumber = 0; customerNumber < randomPerson; customerNumber++) {
            newPersons[customerNumber] = persons[customerNumber];
        }
        for (int customerNumber = randomPerson; customerNumber < numberOfPersons - 1; customerNumber++) {
            newPersons[customerNumber] = persons[customerNumber + 1];
        }
        persons = newPersons;
    }

    public void setItemsToRandomPerson() {
        int numberOfPersons = persons.length;
        int randomPerson = (int) (Math.random() * numberOfPersons);
        persons[randomPerson].addMoreItems();
    }

    public void newRandomPerson() {
        int numberOfPersons = persons.length;
        Person[] newPersons = new Person[numberOfPersons + 1];
        int randomPosition = (int) (Math.random() * numberOfPersons + 1);
        boolean newPersonAdded = false;
        for (int customerNumber = 0; customerNumber < numberOfPersons; customerNumber++) {
            if (randomPosition == customerNumber) {
                newPersons[customerNumber] = new Person();
                newPersonAdded = true;
            }
            if (newPersonAdded) {
                newPersons[customerNumber + 1] = persons[customerNumber];
            } else {
                newPersons[customerNumber] = persons[customerNumber];
            }
        }
        persons = newPersons;
    }

    public void newPerson(){
        int numberOfPersons = persons.length;
        Person[] newPersons = new Person[numberOfPersons + 1];
        for (int customerNumber = 0; customerNumber < numberOfPersons; customerNumber++) {
            newPersons[customerNumber] = persons[customerNumber];
        }
        newPersons[numberOfPersons] = new Person();
        persons = newPersons;
    }
}