public class Main {
    public static void main(String[] args) {

        System.out.println("Caso 1. Fila añadida");
        Fila fila=new Fila();
        fila.mostrarFila();
        System.out.println("Caso 2. Personas añadidas");
        Persona p1=new Persona(2);
        Persona p2=new Persona(3);
        fila.llegaPersona(p1);
        fila.llegaPersona(p2);
        fila.mostrarFila();
        System.out.println("Caso 3. Persona atendida");
        fila.seAtiendePersona();
        fila.mostrarFila();

        Persona p3=new Persona (1);
        fila.llegaPersona(p3);
        fila.llegaPersona(p1);
        fila.llegaPersona(p1);
        System.out.println("Caso 4. Persona se aburre y se va");
        fila.mostrarFila();
        fila.seAburrePersona(p3);
        fila.mostrarFila();

        Persona p4=new Persona(4);
        fila.llegaPersona(p4);
        System.out.println("Caso 5. Persona da cosas a otra");
        fila.mostrarFila();
        fila.personaDaCosas(p3,p4);
        fila.mostrarFila();

        Persona p5=new Persona (1);
        System.out.println("Caso 6. Persona se cuela lícitamente");
        fila.colarseLicitamente(p5,p2);
        fila.mostrarFila();
        Persona p6=new Persona(9);
        System.out.println("Caso 7. Persona se cuela ilícitamente");
        fila.colarseIlicitamente(p6,3);
        fila.mostrarFila();
        Fila fila2=new Fila();
        System.out.println("Caso 8. Se da parte de una fila a otra");
        fila.darAOtraFila(fila2);
        fila.mostrarFila();
        fila2.mostrarFila();
    }
}