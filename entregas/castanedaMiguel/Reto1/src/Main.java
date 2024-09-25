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

        Persona p4=new Persona(4);
        fila.llegaPersona(p4);
        fila.personaDaCosas(p3,p4);

        Persona p5=new Persona (1);
        fila.colarseLicitamente(p5,p2);
        Persona p6=new Persona(9);
        fila.colarseIlicitamente(p6,3);

        Fila fila2=new Fila();
        fila.darAOtraFila(fila2);
    }
}