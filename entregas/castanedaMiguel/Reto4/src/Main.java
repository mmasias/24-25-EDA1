import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cancion c1=new Cancion("Demoliendo Hoteles", "Charly Garcia",258);
        Cancion c2=new Cancion("Rasguña Las Piedras" ,"Sui Generis" ,285);
        Cancion c3=new Cancion("Canción Para Mi Muerte" ,"Sui Generis" ,342);
        Cancion c4=new Cancion("No Soy Un Extraño" ,"Charly García" ,295);

        Cancion[] cc= {c1, c2, c3, c4};

        ColaReproduccion cPrincipal= new ColaReproduccion("Cola principal",cc);

        SistemaReproduccion sistema=new SistemaReproduccion(cPrincipal);

        sistema.menu();

    }
}