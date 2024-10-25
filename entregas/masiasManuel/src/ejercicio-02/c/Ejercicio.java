package c;

public class Ejercicio {

    public static void main(String[] args) {
        
        Persona manuel = new Persona("Manuel", "1234");
        manuel.muestrate();
        Persona juan = new Persona("Juan", "8888");
        
        juan.muestrate();

        Lista lista = new Lista();
        lista.insertPrimero(manuel);
        lista.insertPrimero(juan);
        lista.insertPrimero(manuel);
        lista.insertPrimero(manuel);
        lista.insertPrimero(manuel);
        lista.insertPrimero(manuel);
        lista.writeln();

        

    }
}
