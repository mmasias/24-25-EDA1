public class Ejercicio {

    public static void main(String[] args) {
        
        Persona manuel = new Persona("Manuel", "1234");
        manuel.muestrate();
        Persona juan = new Persona("Juan", "8888");
        juan.muestrate();
        
        Persona persona;
        persona = manuel;

        manuel.presentate(persona);

        System.out.println("Aqui hay alguien que dice que es:");
        persona.muestrate();
        System.out.println("¿Es verdad? " + juan.equals(persona));

        persona = new Persona("Manuel", "666");
        System.out.println("Aqui hay alguien que dice que es:");
        persona.muestrate();
        System.out.println("¿Es verdad? " + manuel.equals(persona));
    }
}
