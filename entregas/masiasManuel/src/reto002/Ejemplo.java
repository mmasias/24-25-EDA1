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

        FoundNodeList theAList = new FoundNodeList();
        theAList = nephews.find("A");

        theAList.showInConsole();
        nephews.showInConsole();
    }
}
