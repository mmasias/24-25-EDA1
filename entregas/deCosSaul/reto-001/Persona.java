public class Persona {
    public int items;

    public Persona(){
        items = (int)(Math.random() * 9 + 1);
    }

    public Persona(int items){
        this.items = items;
    }

    public void recibe(int items){
        this.items += items;
    }

    public void mostrar(){
        System.out.print("[" + items + "]");
    }
}
