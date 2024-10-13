class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        nephews.insertEnd("A");
        nephews.insertEnd("C");
        nephews.insertEnd("D");
        nephews.insertEnd("B");
        nephews.insertEnd("A");
        nephews.insertEnd("B");
        nephews.insertEnd("A");

        nephews.showInConsole();

        List theAList = new List();
        theAList = nephews.find("A");

        theAList.showInConsole();
        nephews.showInConsole();
    }
}
