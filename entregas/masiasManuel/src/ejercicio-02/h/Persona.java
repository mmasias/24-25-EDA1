package h;
public class Persona {
    private String nombre;
    private String dni;

    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Persona(Persona persona){
        this.nombre = persona.nombre;
        this.dni = persona.dni;
    }

    public void muestrate() {
        System.out.println(this.nombre);
    }

    public void presentate(Persona persona) {
        System.out.println("Hola [" + persona.nombre + "], me llamo [" + this.nombre + "]");
    }

    public boolean equals(Persona persona) {
		return this.dni == persona.dni;
	}   
}
