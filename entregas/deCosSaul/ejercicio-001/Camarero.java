import javax.sound.midi.Soundbank;

class Camarero extends Empleado {

    public void servir() {
        System.out.println(hamburguesa.nombrarIngredientes());
        System.out.println(hamburguesa.mostrarIngredientes());
    }

    public void recibir(Hamburguesa recibe) {
        this.hamburguesa = recibe;
        this.tieneHamburguesa = true;
    }
    
}