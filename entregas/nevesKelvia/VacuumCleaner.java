package entregas.nevesKelvia;

public class VacuumCleaner {
    private int[] position;
    private World world;

    public VacuumCleaner(World world) {
        this.world = world;
        this.position = new int[]{0, 0};
    }

    public void move() {
        int[] previousPosition = position.clone();
        int[][] directions = {
                { -1, 1 }, { 0, 1 }, { 1, 1 },
                { -1, 0 }, { 0, 0 }, { 1, 0 },
                { -1, -1 }, { 0, -1 }, { 1, -1 }
        };

        int[] movement = directions[(int) (Math.random() * directions.length)];
        position[0] = position[0] + movement[0];
        position[1] = position[1] + movement[1];

        if (!world.isValidPosition(position)) {
            position = previousPosition;
        }
    }

    public void clean() {
        world.cleanTile(position);
    }

    public int[] getPosition() {
        return position;
    }
}

