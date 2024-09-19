package OO;

class Simulator {
    private Surface surface;
    private Vacuum vacuum;

    public Simulator(int rows, int cols) {
        this.surface = new Surface(rows, cols);
        this.vacuum = new Vacuum();
    }

    public void run() {
        while (surface.isDirty()) {
            vacuum.move(surface);
            vacuum.clean(surface);
            surface.print(vacuum.getPosition());
            pause(0.25);
        }
    }

    private void pause(double seconds) {
        try {
            Thread.sleep((long) (1000 * seconds));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        new Simulator(5,5).run();
    }
}
