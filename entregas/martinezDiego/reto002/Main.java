package entregas.martinezDiego.reto002;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.agregar("Apple");
        lista.agregar("Banana");
        lista.agregar("Avocado");
        lista.agregar("Orange");
        lista.agregar("Apple");  
        lista.agregar("Orange");
        lista.agregar("Orange");
        lista.agregar("Apple"); 

        System.out.println("Lista original:");
        lista.mostrar();

        
        String valorBuscado = "Apple";
        FoundNodeList foundList = FoundNodeList.find(lista, valorBuscado);

        System.out.println("Lista de nodos encontrados que son '" + valorBuscado + "':");
        foundList.mostrar();
    }
}


