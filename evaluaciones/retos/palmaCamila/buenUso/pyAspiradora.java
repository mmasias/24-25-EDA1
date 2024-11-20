package evaluaciones.retos.palmaCamila.buenUso;

class Vacuum {
    public static void main(String[] args) {

        final int TILE_CLEAN = 0;
        final int TILE_DIRTY = 1;
        final int TILE_DIRTIER = 2;
        final int TILE_VERY_DIRTY = 3;
        final int TILE_EXTREMELY_DIRTY = 4;
        final int X_AXIS = 0;
        final int Y_AXIS = 1;

        int[][] surface = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        int vacuumPosition[] = { 0, 0 };

        contaminate(surface);
        boolean surfaceIsDirty = true;

        while (surfaceIsDirty) {
            moveVacuum(vacuumPosition, surface);
            cleanWorld(surface, vacuumPosition);
            printWorld(surface, vacuumPosition);
            surfaceIsDirty = isDirty(surface);
            pause(0.5);
        }
    }

    static void moveVacuum(int[] vacuumPosition, int[][] surface) {

        int[] previousPosition = new int[] { vacuumPosition[0], vacuumPosition[1] };

        int[][] directions = {
                { -1, 1 }, { 0, 1 }, { 1, 1 },
                { -1, 0 }, { 0, 0 }, { 1, 0 },
                { -1, -1 }, { 0, -1 }, { 1, -1 }
        };

        int[] movement = directions[(int) (Math.random() * directions.length)];
        vacuumPosition[0] = vacuumPosition[0] + movement[0];
        vacuumPosition[1] = vacuumPosition[1] + movement[1];

        if (invalidPosition(vacuumPosition, surface)) {
            vacuumPosition[0] = previousPosition[0];
            vacuumPosition[1] = previousPosition[1];
        }
    }

    static boolean invalidPosition(int[] position, int[][] surface) {
        return position[0] < 0 || position[0] >= surface.length ||
                position[1] < 0 || position[1] >= surface[0].length;
    }

    static void cleanWorld(int[][] surface, int[] vacuumPosition) {
        if (surface[vacuumPosition[0]][vacuumPosition[1]] > 0) {
            surface[vacuumPosition[0]][vacuumPosition[1]]--;
        }
    }

    static boolean isDirty(int[][] surface) {
        return true;
    }

    static void printWorld(int[][] aMap, int[] vacuumPosition) {
        cleanScreen();
        System.out.println("---".repeat(aMap[0].length));
        for (int row = 0; row < aMap.length; row++) {
            for (int column = 0; column < aMap[row].length; column++) {
                if (vacuumPosition[0] == row && vacuumPosition[1] == column) {
                    System.out.print(mapVacuum());
                } else {
                    System.out.print(mapValueToTile(aMap[row][column]));
                }
            }
            System.out.println();
        }
        System.out.println("---".repeat(aMap[0].length));
    }

    static String mapVacuum() {
        return "(O)";
    }

    static String mapValueToTile(int value) {
        String[] tiles = { " . ", "...", "ooo", "OOO", "***" };
        return tiles[value];
    }

    static void contaminate(int[][] aMap) {
        for (int row = 0; row < aMap.length; row++) {
            for (int column = 0; column < aMap[row].length; column++) {
                aMap[row][column] = (int) (Math.random() * 5);
            }
        }
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pause(double seconds) {
        try {
            Thread.sleep((int) (1000 * seconds));
        } catch (InterruptedException e) {
        }
    }
}