public class Main {
    public static void main(String[] args) {

        Fila fila=new Fila();
        Persona p1=new Persona(2);
        Persona p2=new Persona(3);
        fila.llegaPersona(p1);
        fila.llegaPersona(p2);
        fila.seAtiendePersona();

        Persona p3=new Persona (1);
        fila.llegaPersona(p3);
        fila.llegaPersona(p1);
        fila.llegaPersona(p1);

        fila.seAburrePersona(p3);

    }
}