package OO;

class Vacuum {
    private Position position;

    public Vacuum() {
        this.position = new Position(0, 0);
    }

    public void move(Surface surface) {
        int[][] directions = {
            {-1, 1}, {0, 1}, {1, 1},
            {-1, 0}, {0, 0}, {1, 0},
            {-1, -1}, {0, -1}, {1, -1}
        };
        int[] movement = directions[(int) (Math.random() * directions.length)];
        Position newPosition = new Position(this.position.getRow() + movement[0], this.position.getCol() + movement[1]);

        if (isValidPosition(newPosition, surface)) {
            position.setPosition(newPosition);
        }
    }

    private boolean isValidPosition(Position position, Surface surface) {
        return position.getRow() >= 0 && position.getRow() < surface.getRows() && position.getCol() >= 0 && position.getCol() < surface.getCols();
    }

    public void clean(Surface surface) {
        surface.clean(position.getRow(), position.getCol());
    }

    public Position getPosition() {
        return position;
    }
}

