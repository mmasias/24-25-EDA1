package Aspiradora;

public class Surface {
    private Tile[][] tiles; 

    public Surface(int rows, int columns){
        tiles = new Tile[rows][columns];
        contaminate();
    }

    public void contaminate(){
        for (int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                tiles[i][j] = new Tile((int) (Math.random() * 5));
            }
        }
    }

    boolean isDirty(){
        for (Tile[] row:tiles){
            for(Tile tile:row){
                if(tile.isDirty()){
                    return true;
                }
            }
        }
        return false; 
    }

    public Tile getTile(int x, int y){
        return tiles[x][y];
    }

    public void printSurface(Vacuum vacuum){
        cleanScreen();
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                if(i == vacuum.getX()&& j == vacuum.getY()){
                    System.out.print("(O)");
                }else{
                    System.out.println(mapValueToTile(tiles[i][j].getDirtiness()));
                }
            }
            System.out.println();
        }
    }

    private String mapValueToTile(int value){
        String[] tiles = {" . ", "...", "ooo", "OOO", "***"};
        return tiles[value];
    }

    private void cleanScreen(){
        System.out.println("\033[H\033[2J");
        System.out.println();

    }
    
}
