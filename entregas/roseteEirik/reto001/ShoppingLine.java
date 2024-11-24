package entregas.roseteEirik.reto001;

public class ShoppingLine {

    public static final ShoppingLine[] activeShoppingLines = new ShoppingLine[Constants.MAX_QUEUE];
    public static int activeLineCount = 0;

    private Person[] persons;

    public ShoppingLine(int numberOfPersons) {
        this.persons = new Person[numberOfPersons];
        for (int customerNumber = 0; customerNumber < numberOfPersons; customerNumber++) {
            persons[customerNumber] = new Person();
        }
        addToActiveShoppingLines();
        validateQueueSize();
        System.out.println("Nueva cola creada con " + numberOfPersons + " personas. (Número de colas: " + activeLineCount + ")");
    }
    public ShoppingLine() {
        this.persons = new Person[(int) (Math.random() * 10 + 10)];
        for (int customerNumber = 0; customerNumber < persons.length; customerNumber++) {
            persons[customerNumber] = new Person();
        }
        addToActiveShoppingLines();
        validateQueueSize();
        System.out.println("Nueva cola creada con " + persons.length + " personas. (Número de colas: " + activeLineCount + ")");
    }
    public ShoppingLine(Person[] persons) {
        this.persons = persons;
        addToActiveShoppingLines();
        validateQueueSize();
        System.out.println("Se creó una nueva cola con " + persons.length + " personas ");
    }

    private void addToActiveShoppingLines() {
        if (activeLineCount >= Constants.MAX_QUEUE) {
            System.out.println("Error: No se pueden crear más colas activas.");
            return;
        }
        activeShoppingLines[activeLineCount++] = this;
    }

    private void validateQueueSize() {
        while (persons.length > Constants.MAX_PERSONS && activeLineCount < Constants.MAX_QUEUE) {
            int remainingPersons = persons.length - Constants.MAX_PERSONS;

            Person[] overflowPersons = new Person[remainingPersons];
            for (int i = 0; i < remainingPersons; i++) {
                overflowPersons[i] = persons[Constants.MAX_PERSONS + i];
            }

            Person[] adjustedPersons = new Person[Constants.MAX_PERSONS];
            for (int i = 0; i < Constants.MAX_PERSONS; i++) {
                adjustedPersons[i] = persons[i];
            }
            this.persons = adjustedPersons;

            System.out.println("Se crearon " + remainingPersons + " personas adicionales en una nueva cola.");

            ShoppingLine newLine = new ShoppingLine(overflowPersons);
        }
    }

    private Person[] showShoppingLine() {
        for (int customerNumber = 0; customerNumber < persons.length; customerNumber++) {
            System.out.print("[Cliente: " + customerNumber + " - Items: " + persons[customerNumber].getQuantityOfItems() + "] \n");
        }
        return persons;
    }

    public static void showAllShoppingLines() {
        for (int i = 0; i < activeLineCount; i++) {
            System.out.println("Cola de compras " + (i + 1) + ":");
            activeShoppingLines[i].showShoppingLine();
            System.out.println();
        }
    }

    private static ShoppingLine getRandomActiveLineWithCondition(boolean forAddition) {
        if (activeLineCount == 0) {
            System.out.println("No hay colas activas.");
            return null;
        }

        int attempts = 0;
        while (attempts < activeLineCount) {
            int randomIndex = (int) (Math.random() * activeLineCount);
            ShoppingLine selectedLine = activeShoppingLines[randomIndex];

            if (forAddition && selectedLine.persons.length < Constants.MAX_PERSONS) {
                System.out.println("Se seleccionó la cola " + (randomIndex + 1) + " para la operación solicitada.");
                return selectedLine;
            } else if (!forAddition && selectedLine.persons.length > 1) {
                System.out.println("Se seleccionó la cola " + (randomIndex + 1) + " para la operación solicitada.");
                return selectedLine;
            }
            attempts++;
        }

        System.out.println("No se encontró una cola adecuada para la operación solicitada.");
        return null;
    }

    public static Person popPersonFromAnyLine() {
        ShoppingLine line = getRandomActiveLineWithCondition(false);
        if (line != null) {
            return line.popPerson();
        }
        return null;
    }

    private Person popPerson() {
        if (persons.length <= 1) {
            System.out.println("No se pueden eliminar más personas, la cola está vacía o con un solo elemento.");
            return null;
        }

        Person personRemoved = persons[0];
        int numberOfPersons = persons.length;
        Person[] newPersons = new Person[numberOfPersons - 1];
        for (int customerNumber = 0; customerNumber < numberOfPersons - 1; customerNumber++) {
            newPersons[customerNumber] = persons[customerNumber + 1];
        }
        persons = newPersons;
        
        System.out.println("Se eliminó al cliente en la posición 0 con " + personRemoved.getQuantityOfItems() + " artículos.");
        return personRemoved;
    }

    public static void popRandomPersonFromAnyLine() {
        ShoppingLine line = getRandomActiveLineWithCondition(false);
        if (line != null) {
            line.popRandomPerson();
        }
    }

    private void popRandomPerson() {
        if (persons.length <= 1) {
            System.out.println("No se pueden eliminar más personas, la cola está vacía o con un solo elemento.");
            return;
        }

        int numberOfPersons = persons.length;
        int randomPerson = (int) (Math.random() * numberOfPersons);
        Person personRemoved = persons[randomPerson];
        Person[] newPersons = new Person[numberOfPersons - 1];
        for (int customerNumber = 0; customerNumber < randomPerson; customerNumber++) {
            newPersons[customerNumber] = persons[customerNumber];
        }
        for (int customerNumber = randomPerson; customerNumber < numberOfPersons - 1; customerNumber++) {
            newPersons[customerNumber] = persons[customerNumber + 1];
        }
        persons = newPersons;

        System.out.println("Se eliminó al cliente en la posición " + randomPerson + " con " + personRemoved.getQuantityOfItems() + " artículos.");
    }

    public static void setItemsToRandomPersonInAnyLine() {
        ShoppingLine line = getRandomActiveLineWithCondition(false);
        if (line != null) {
            line.setItemsToRandomPerson();
        }
    }

    private void setItemsToRandomPerson() {
        int numberOfPersons = persons.length;
        int randomPerson = (int) (Math.random() * numberOfPersons);
        persons[randomPerson].addMoreItems();
        System.out.println("Se añadieron más artículos al cliente en la posición " + randomPerson + " ahora tiene " + persons[randomPerson].getQuantityOfItems() + " artículos.");
    }

    public static void addRandomPersonToAnyLine() {
        ShoppingLine line = getRandomActiveLineWithCondition(true);
        if (line != null) {
            line.newRandomPerson();
        }
    }

    private void newRandomPerson() {
        int numberOfPersons = persons.length;
        if (numberOfPersons >= Constants.MAX_PERSONS) {
            validateQueueSize();
            return;
        }
        int randomPosition = (int) (Math.random() * (numberOfPersons));
        Person newPerson = new Person();
        Person[] newPersons = new Person[numberOfPersons + 1];

        for (int customerNumber = 0; customerNumber < randomPosition; customerNumber++) {
            newPersons[customerNumber] = persons[customerNumber];
        }
        newPersons[randomPosition] = newPerson;
        for (int customerNumber = randomPosition; customerNumber < numberOfPersons; customerNumber++) {
            newPersons[customerNumber + 1] = persons[customerNumber];
        }
        persons = newPersons;
        System.out.println("Se agregó un nuevo cliente en la posición " + randomPosition + " con " + newPerson.getQuantityOfItems() + " artículos.");
        validateQueueSize();
    }

    public static void addNewPersonToAnyLine() {
        ShoppingLine line = getRandomActiveLineWithCondition(true);
        if (line != null) {
            line.newPerson();
        }
    }

    private void newPerson() {
        int numberOfPersons = persons.length;
        if (numberOfPersons >= Constants.MAX_PERSONS) {
            validateQueueSize();
            return;
        }

        Person[] newPersons = new Person[numberOfPersons + 1];
        for (int customerNumber = 0; customerNumber < numberOfPersons; customerNumber++) {
            newPersons[customerNumber] = persons[customerNumber];
        }
        newPersons[numberOfPersons] = new Person();
        persons = newPersons;
        System.out.println("Se agregó un nuevo cliente al final de la cola con " + newPersons[numberOfPersons].getQuantityOfItems() + " artículos.");
        validateQueueSize();
    }
}