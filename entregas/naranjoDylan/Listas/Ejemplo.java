package entregas.naranjoDylan.Listas;

public class Ejemplo {

    public static void main(String[] args) {

        List lista = new List();

        System.out.println("¿Está vacía la lista? " + lista.isEmpty());

        lista.insertEnd("Elemento 1");
        lista.insertEnd("Elemento 2");
        lista.insertEnd("Elemento 3");
        System.out.println("Tamaño de la lista después de inserciones: " + lista.size());

        lista.insertFront("Elemento 0");
        System.out.println("Tamaño de la lista después de insertar al frente: " + lista.size());

        String[] elementos = lista.listAll();
        System.out.println("Elementos de la lista:");
        for (String elemento : elementos) {
            System.out.println(elemento);
        }

        System.out.println("\nBuscando 'Elemento 2' en la lista:");
        List encontrados = lista.find("Elemento 2");
        String[] elementosEncontrados = encontrados.listAll();
        for (String e : elementosEncontrados) {
            System.out.println(e);
        }

        lista.deleteFront();
        System.out.println("\nTamaño de la lista después de eliminar el primer elemento: " + lista.size());

        lista.deleteEnd();
        System.out.println("Tamaño de la lista después de eliminar el último elemento: " + lista.size());

        elementos = lista.listAll();
        System.out.println("Elementos de la lista después de eliminar:");
        for (String elemento : elementos) {
            System.out.println(elemento);
        }

        lista.clearlist();
        System.out.println("\nTamaño de la lista después de borrar toda la lista: " + lista.size());
        System.out.println("¿Está vacía la lista? " + lista.isEmpty());
    }
}
