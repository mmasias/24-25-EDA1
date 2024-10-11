package OO;

class Surface {
    private int[][] tiles;
    private static final int TILE_CLEAN = 0;
    private static final int TILE_EXTREMELY_DIRTY = 4;

    public Surface(int rows, int cols) {
        tiles = new int[rows][cols];
        contaminate();
    }

    public void contaminate() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = (int) (Math.random() * (TILE_EXTREMELY_DIRTY + 1));
            }
        }
    }

    public boolean isDirty() {
        for (int[] row : tiles) {
            for (int tile : row) {
                if (tile > TILE_CLEAN) return true;
            }
        }
        return false;
    }

    public void clean(int row, int col) {
        if (tiles[row][col] > TILE_CLEAN) {
            tiles[row][col]--;
        }
    }

    public void print(Position vacuumPos) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (i == vacuumPos.getRow() && j == vacuumPos.getCol()) {
                    System.out.print("(O)");
                } else {
                    System.out.print(mapValueToTile(tiles[i][j]));
                }
            }
            System.out.println();
        }
    }

    private String mapValueToTile(int value) {
        String[] tileRepresentations = {" . ", "...", "ooo", "OOO", "***"};
        return tileRepresentations[value];
    }

    public int getRows() {
        return tiles.length;
    }

    public int getCols() {
        return tiles[0].length;
    }
}
