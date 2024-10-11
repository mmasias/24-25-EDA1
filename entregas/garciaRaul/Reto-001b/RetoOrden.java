public class RetoOrden {
    public static void main(String[] args) {
        // Crear la estructura secuencial y agregar elementos iniciales
        EstructuraSecuencial estructura = new EstructuraSecuencial();
        estructura.agregarElemento("A");
        estructura.agregarElemento("B");
        estructura.agregarElemento("C");

        // Mostrar la estructura inicial
        System.out.println("Estado inicial:");
        estructura.mostrarEstructuraFisica();

        // Reto 1: Establecer el orden A -> C -> B
        estructura.establecerOrden("A", "C", "B");
        System.out.println("\nReto 1 - Orden A -> C -> B:");
        estructura.mostrarOrdenLogico();

        // Reto 2: Cambiar el orden a B -> C -> A
        estructura.establecerOrden("B", "C", "A");
        System.out.println("\nReto 2 - Orden B -> C -> A:");
        estructura.mostrarOrdenLogico();

        // Reto 3: Eliminar el elemento B y mostrar A -> C
        estructura.eliminarElemento("B");
        System.out.println("\nReto 3 - Eliminado B, Orden A -> C:");
        estructura.mostrarOrdenLogico();

        // Reto 4: Agregar D y E, luego eliminar C y mostrar A -> D -> E
        estructura.agregarElemento("D");
        estructura.agregarElemento("E");
        estructura.eliminarElemento("C");
        estructura.establecerOrden("A", "D", "E");
        System.out.println("\nReto 4 - Agregado D, E y Eliminado C, Orden A -> D -> E:");
        estructura.mostrarOrdenLogico();
    }
}

