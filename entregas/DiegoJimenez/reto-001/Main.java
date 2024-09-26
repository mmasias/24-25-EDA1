import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Fila fila = new Fila(10); 
        Random random = new Random();

        
        for (int i = 1; i <= 10; i++) {
            fila.añadirPersona(new Persona("Persona " + i));
            fila.mostrarFila();
            Thread.sleep(1000); 
        }

       
        for (int i = 0; i < 20; i++) { 
            int accion = random.nextInt(4); 
            switch (accion) {
                case 0:
                    fila.atenderPersona();
                    break;
                case 1:
                    fila.quitarPersonaAleatoriamente();
                    break;
                case 2:
                    fila.colarLicitaAleatoria(new Persona("Le dieron chance"));
                    break;
                case 3:
                    fila.colarIlicita(new Persona("Tramposo"));
                    break;
            }
            fila.mostrarFila();
            Thread.sleep(2000); 
        }
    }
}
