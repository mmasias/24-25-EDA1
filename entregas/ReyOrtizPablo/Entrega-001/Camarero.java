
public class Camarero extends Empleado{

    public void servir() {
       System.out.println(this.hamburguesa.describir());
        this.hamburguesa.mostrar();
        
        
    
        
    }

    public void recibir(Hamburguesa entregar) {
        this.tieneHamburguesa = true;
        this.hamburguesa=entregar;
       
    }

}
