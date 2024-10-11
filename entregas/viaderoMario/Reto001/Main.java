public class Main{
    public static void main(String[] args) {
        Fila centroComercial = new Fila(10);
    
        centroComercial.agregarPersona("Alice");
        centroComercial.agregarPersona("Bob");
        centroComercial.agregarPersona("Charlie");
        centroComercial.mostrarFila();
    
        centroComercial.atenderPersona();
        centroComercial.mostrarFila();
    
        centroComercial.agregarPersona("David");
        centroComercial.mostrarFila();
    
        centroComercial.colarse("Eve");
        centroComercial.mostrarFila();
    
        centroComercial.irse("Charlie");
        centroComercial.mostrarFila();
    
        centroComercial.traerCosas("Bob", "David");
        centroComercial.traerCosas("Alice", "Eve");
    
        centroComercial.atenderPersona();
        centroComercial.atenderPersona();
        centroComercial.atenderPersona(); 
    
        centroComercial.mostrarFila();
     }
    }