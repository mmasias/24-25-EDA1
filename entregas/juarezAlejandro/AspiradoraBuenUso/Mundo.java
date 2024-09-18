import java.util.Scanner;

class Mundo {

    private Scanner entrada = new Scanner(System.in);
    private Habitacion habitacion;
    private Gato gato;
    private Aspiradora aspiradora;

    public Mundo() {
        habitacion = new Habitacion(10, 20);
        gato = new Gato(habitacion);
        aspiradora = new Aspiradora(habitacion);
    }

    public void empezar() {
        while (true) {
            this.gato.mover(this.habitacion);
            this.gato.ensuciar(this.habitacion);
            this.aspiradora.mover(this.habitacion);
            this.aspiradora.limpiar(this.habitacion);
            this.habitacion.imprimir(this.gato, this.aspiradora);
            System.out.println("Cantidad de suciedad: " + this.habitacion.obtenerCantidadDeSuciedad());
            if (entrada.nextLine().equals("f")) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Mundo mundo = new Mundo();
        mundo.empezar();
    }

}