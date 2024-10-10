package entregas.roseteEirik.reto001;

class Carrefour{
    public static void main(String[] args) {
        new ShoppingLine();
        ShoppingLine.showAllShoppingLines();
        System.out.println("\nEliminando primera persona...");
        ShoppingLine.popPersonFromAnyLine();
        System.out.println();

        ShoppingLine.showAllShoppingLines();
        System.out.println("\nEliminando persona aleatoria...");
        ShoppingLine.popRandomPersonFromAnyLine();
        System.out.println();
        
        ShoppingLine.showAllShoppingLines();
        System.out.println("\nAñadiendo productos a persona aleatoria...");
        ShoppingLine.setItemsToRandomPersonInAnyLine();
        System.out.println();

        ShoppingLine.showAllShoppingLines();
        System.out.println("\nllega un nuevo cliente...");
        ShoppingLine.addNewPersonToAnyLine();
        System.out.println();

        ShoppingLine.showAllShoppingLines();
        System.out.println("\nUn cliente se cuela en la fila...");
        ShoppingLine.addRandomPersonToAnyLine();
        System.out.println();

        ShoppingLine.showAllShoppingLines();
    }
}