package Aspiradora;

public class Vacuum {
    private int x;
    private int y; 

    public Vacuum(int startX, int startY){
        this.x = startX;
        this.y = startY; 
    }


    public void move(int maxX, int maxY){
        int[][] directions = {
            {-1, 1}, {0, 1}, {1, 1},
            {-1, 0}, {0, 0}, {1, 0},
            {-1, -1}, {0, -1}, {1, -1} 
        };
        
        int[] movement = directions[(int) (Math.random()*directions.length)];
        int newX = x + movement[0];
        int newY = y + movement[1];

        if(newX >= 0 && newX < maxX && newY >= 0 && newY < maxY){
            x = newX;
            y = newY;
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y; 
    }

    public void clean (Tile tile){
        tile.reduceDirtiness();
    }

    
}
