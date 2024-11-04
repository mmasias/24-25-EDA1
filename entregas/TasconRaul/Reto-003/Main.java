public class Main {
    public static void main(String[] args) {
        // Definir la cadena de entrada que queremos comprimir
        String cadena = "abababc";

        // Usar el compresor LZ para comprimir la cadena
        Compresorlz.Resultado resultado = Compresorlz.comprime(cadena);

        // Imprimir el resultado comprimido y el diccionario
        System.out.println("=== Compresión LZ ===");
        System.out.println("Cadena original: " + cadena);
        System.out.println(resultado);

        // Usar la estructura de datos personalizada CustomList
        System.out.println("\n=== Lista personalizada (CustomList) ===");
        List lista = new List();
        lista.insertEnd("a");
        lista.insertEnd("b");
        lista.insertEnd("c");

        System.out.println("Elementos en la lista: ");
        String[] elementos = lista.listAll();
        for (String elemento : elementos) {
            System.out.print(elemento + " ");
        }
        System.out.println();

        // Eliminar el último elemento y mostrar los resultados
        lista.deleteEnd();
        System.out.println("Después de eliminar el último elemento:");
        elementos = lista.listAll();
        for (String elemento : elementos) {
            System.out.print(elemento + " ");
        }
    }
}
