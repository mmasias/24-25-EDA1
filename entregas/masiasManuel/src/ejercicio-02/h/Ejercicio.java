package h;
public class Ejercicio {

    public static void main(String[] args) {
        
        Persona manuel = new Persona("Manuel", "1234");
        manuel.muestrate();
        Persona juan = new Persona("Juan", "8888");
        juan.muestrate();
        manuel.presentate(juan);

        List lista = new List();
        lista.insertPrimero(manuel);
        lista.insertPrimero(juan);
        lista.insertPrimero(manuel);
        lista.insertPrimero(manuel);
        lista.insertPrimero(manuel);
        lista.insertPrimero(manuel);
        lista.writeln();
        
        Persona persona = juan;
        
        System.out.println("Aqui hay alguien que dice que es:");
        persona.muestrate();
        System.out.println("¿Está en la lista?" + lista.incluye(persona));

        persona = new Persona("Manuel", "1234");
        System.out.println("Aqui hay alguien que dice que es:");
        persona.muestrate();
        System.out.println("¿Está en la lista?" + lista.incluye(persona));
    }
}
