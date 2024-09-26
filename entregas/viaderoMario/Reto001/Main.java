public class Main {
    public static void main(String[] args) {
        Fila fila1 = new Fila(15);

        fila1.entraPersona();
        fila1.entraPersona();
        fila1.entraPersona();

        fila1.aburrimientoPersona(0);

        fila1.entraPersona();

        fila1.atender();

        fila1.personaSeCuela(1);

        fila1.personaTraeCosas(1);

        fila1.entraPersona();

        fila1.atender();

    }
}

