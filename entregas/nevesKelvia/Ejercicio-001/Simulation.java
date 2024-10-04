package entregas.nevesKelvia;

public class Simulation {
    public static void main(String[] args) {
        World world = new World(10, 25);
        VacuumCleaner vacuum = new VacuumCleaner(world);
        world.contaminate();

        while (world.isDirty()) {
            vacuum.move();
            vacuum.clean();
            world.printWorld(vacuum.getPosition());
            pause(0.5);
        }
    }

    static void pause(double seconds) {
        try {
            Thread.sleep((int) (1000 * seconds));
        } catch (InterruptedException e) {
        }
    }
}
