//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila(10); // Capacidad de la fila
        fila.abrirFila();

        // Personas
        Persona p1 = new Persona("Ana");
        Persona p2 = new Persona("Luis");
        Persona p3 = new Persona("María");

        // Agregar personas a la fila
        fila.agregarPersona(p1);
        fila.agregarPersona(p2);
        fila.mostrarFila();

        // Atender a la primera persona
        fila.atenderPersona();
        fila.mostrarFila();

        // Añadir más personas y colarse
        fila.agregarPersona(p3);
        fila.mostrarFila();
        fila.colarLicita(new Persona("Pedro"));
        fila.mostrarFila();

        // Alguien se va de la fila
        fila.irseDeFila(1);  // Luis se va
        fila.mostrarFila();

        // Alguien trae cosas
        fila.traerCosasA(0); // Ana recibe cosas

        // Alguien se cuela ilícitamente
        fila.colarIlicita(new Persona("Carlos"), 1);
        fila.mostrarFila();

        // Anunciar cuando la fila tiene más de la mitad de capacidad
        fila.anunciar();
    }
}