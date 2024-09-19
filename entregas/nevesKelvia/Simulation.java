package entregas.nevesKelvia;

public class Simulation {
    public static void main(String[] args) {
        Wordl wordl = new Wordl(10, 25);
        VacuumCleaner vacuum = new VacuumCleaner(wordl);
        wordl.contaminate();
    }
}