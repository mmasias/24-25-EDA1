public class Main {
    private static String TO_ZIP="abababc";
    public static void main(String[] args) {
        Compressor compressor=new Compressor();
        String zipped=compressor.zip(TO_ZIP);
        String unzipped=compressor.unzip(zipped); 
        System.out.println(TO_ZIP);
        System.out.println(zipped);
        System.out.println(unzipped);
    }
}
