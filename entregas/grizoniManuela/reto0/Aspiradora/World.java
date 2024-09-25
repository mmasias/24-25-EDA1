package Aspiradora;

public class World {
    private Surface surface;
    private Vacuum vacuum; 

    public World(int rows, int columns){
        surface = new Surface(rows, columns);
        vacuum = new Vacuum(0, 0);
    }

    public void startCleaning(){
        while(surface.isDirty()){
            vacuum.move(surface.getTile(0,0).length, surface.getTile(0,0).length);
            vacuum.clean(surface.getTile(vacuum.getX(), vacuum.getY()));
            surface.printSurface(vacuum);
            pause(0.5);
        }
    }

    private void pause(double seconds){
        try{
            Thread.sleep((int)(1000 * seconds));
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
