package entregas.nevesKelvia;

public class Tile {
    private int dirtiness;

    private final String[] tiles = { " . ", "...", "ooo", "OOO", "***" };

    public Tile() {
        this.dirtiness = 0;
    }

    public void clean() {
        if (dirtiness > 0) {
            dirtiness--;
        }
    }

    public boolean isDirty() {
        return dirtiness > 0;
    }

    public void randomizeDirtiness() {
        this.dirtiness = (int) (Math.random() * 5);
    }

    public String getTileRepresentation() {
        return tiles[dirtiness];
    }
}
