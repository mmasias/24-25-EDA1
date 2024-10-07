package entregas.baquedanoBryan.implementacionLista;


public class Main {
    public static void main(String[] args) {
        List list = new List();
        
        System.out.println("Lista vacía: " + list.isEmpty()); 
        System.out.println("Tamaño actual: " + list.size);   
        
        list.insertEnd("A");
        System.out.println("Se insertó 'A' al final");
        System.out.println("Tamaño actual: " + list.size);   
        
        list.insertFront("B");
        System.out.println("Se insertó 'B' al frente");
        System.out.println("Tamaño actual: " + list.size);   
        
        list.insertEnd("C");
        System.out.println("Se insertó 'C' al final");
        System.out.println("Tamaño actual: " + list.size);  

        list.insertEnd("C");
        System.out.println("Se insertó 'C' al final");
        System.out.println("Tamaño actual: " + list.size); 

        list.insertEnd("C");
        System.out.println("Se insertó 'C' al final");
        System.out.println("Tamaño actual: " + list.size); 
        
        list.insertEnd("C");
        System.out.println("Se insertó 'C' al final");
        System.out.println("Tamaño actual: " + list.size); 

        list.insertFront("B");
        System.out.println("Se insertó 'B' al frente");
        System.out.println("Tamaño actual: " + list.size);   
        
        list.find("C");
        list.listAll();
        

    }
}
