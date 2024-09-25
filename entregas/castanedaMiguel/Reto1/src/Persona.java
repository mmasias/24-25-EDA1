public class Persona {
    public int cosas;
    Persona(int lasCosas){
        this.cosas=lasCosas;
    }

    public void darCosas(Persona p){
        p.cosas+=this.cosas;
        this.cosas=0;
    }
}
