package Aspiradora;

public class Tile {
    private int dirtiness;
    public int length;
    
    public Tile(int dirtiness){
        this.dirtiness = dirtiness; 
    }

    public void reduceDirtiness(){
        if(dirtiness > 0){
            dirtiness--;
        }
    }

    public int getDirtiness(){
        return dirtiness;
    }

    public boolean isDirty(){
        return dirtiness > 0;
    }
}
