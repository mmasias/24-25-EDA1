package entregas.roseteEirik.reto001;

class Carrefour{
    public static void main(String[] args) {
        ShoppinnLine carrefour = new ShoppinnLine();
        System.out.println("Fila: ");
        carrefour.showShoppingLine();
        System.out.println("\nEliminando primera persona...");
        carrefour.popPerson();
        System.out.println();

        System.out.println("Fila: ");
        carrefour.showShoppingLine();
        System.out.println("\nEliminando persona aleatoria...");
        carrefour.popRandomPerson();
        System.out.println();
        
        System.out.println("Fila: ");
        carrefour.showShoppingLine();
        System.out.println("\nAñadiendo productos a persona aleatoria...");
        carrefour.setItemsToRandomPerson();
        System.out.println();

        System.out.println("Fila: ");
        carrefour.showShoppingLine();
        System.out.println("\nUn cliente se cuela en la fila...");
        carrefour.newRandomPerson();
        System.out.println();

        System.out.println("Fila: ");
        carrefour.showShoppingLine();
    }
}