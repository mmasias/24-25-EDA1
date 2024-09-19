package entregas.nevesKelvia;

public class World {
    private Tile[][] surface;

    public World(int rows, int columns) {
        surface = new Tile[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                surface[row][column] = new Tile();
            }
        }
    }

    public boolean isValidPosition(int[] position) {
        return position[0] >= 0 && position[0] < surface.length &&
                position[1] >= 0 && position[1] < surface[0].length;
    }

    public void cleanTile(int[] position) {
        surface[position[0]][position[1]].clean();
    }

    public boolean isDirty() {
        for (Tile[] row : surface) {
            for (Tile tile : row) {
                if (tile.isDirty()) {
                    return ;
                }
            }
        }
    }

    public void contaminate() {
        for (Tile[] row : surface) {
            for (Tile tile : row) {
                tile.randomizeDirtiness();
            }
        }
    }

    public void printWorld(int[] vacuumPosition) {
        cleanScreen();
        System.out.println("---".repeat(surface[0].length));
        for (int row = 0; row < surface.length; row++) {
            for (int column = 0; column < surface[row].length; column++) {
                if (vacuumPosition[0] == row && vacuumPosition[1] == column) {
                    System.out.print("(O)");
                } else {
                    System.out.print(surface[row][column].getTileRepresentation());
                }
            }
            System.out.println();
        }
        System.out.println("---".repeat(surface[0].length));
    }
}
