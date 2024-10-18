public class Diccionario {

    private String[] palabras;

    public Diccionario() {
        palabras = new String[20];
        palabras[1] = "a";
        palabras[2] = "b";
        palabras[3] = "ab";
        palabras[4] = "abc";
        palabras[5] = "bd";
        palabras[6] = "c";
    }

    public String obtenerPalabra(int codigo) {
        return palabras[codigo];    
    }

    public void agregarPalabra(int codigo, String palabra) {
        palabras[codigo] = palabra;
    }

    public void imprimirDiccionario() {
        for (int i = 1; i < palabras.length && palabras[i] != null; i++) {
            System.out.print(i + ":" + palabras[i] + " - ");
        }
        System.out.println();
    }
    
}
