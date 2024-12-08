public class Main {
    public static void main(String[] args) {
        String sequence = "abababcbdc";
        System.out.println("Secuencia original: " + sequence);

        Compressor compressor = new Compressor();
        String compressed = compressor.compress(sequence);
        Dictionary dictionary = compressor.getDictionary();
        System.out.println("Secuencia comprimida: " + compressed);
        System.out.println("Diccionario: " + dictionary);

        Decompressor decompressor = new Decompressor();
        String decompressed = decompressor.decompress(compressed, dictionary);
        System.out.println("Secuencia descomprimida: " + decompressed);
    }
}
