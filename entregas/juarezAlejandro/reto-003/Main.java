public class Main {
     public static void main(String[] args) {
        Diccionario diccionario = new Diccionario();
        Compresor compresor = new Compresor(diccionario);

        String texto = "abababcbdc";
        String textoComprimido = compresor.imprimir(texto);
        System.out.println("Secuencia de codigo y caracteres:");
        compresor.imprimirSecuencia();
        System.out.println("-".repeat(80));
        System.out.println("Diccionario:");
        diccionario.imprimirDiccionario();
     }
}