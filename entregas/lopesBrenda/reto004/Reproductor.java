package entregas.lopesBrenda.reto004;

public class Reproductor {
        private ColaReproduccion cola;
        private PilaCanciones historial;
        private Cancion cancionActual;
    
        public Reproductor() {
            cola = new ColaReproduccion();
            historial = new PilaCanciones();
            cancionActual = null;
        }

        public Cancion verCancionActual() {
            return cancionActual;
        }
    
        public void reproducirCancion(Cancion cancion) {
            historial.apilar(cancion);
            System.out.println("▶ Reproduciendo: " + cancion);
        }
    
        public void siguienteCancion() {
            Cancion siguiente = cola.desencolar();
            if (siguiente != null) {
                reproducirCancion(siguiente);
            } else {
                System.out.println("No hay más canciones en la cola.");
            }
        }
    
        public void anteriorCancion() {
            Cancion anterior = historial.desapilar();
            if (anterior != null) {
                System.out.println("▶ Reproduciendo anterior: " + anterior);
            } else {
                System.out.println("No hay canciones anteriores en el historial.");
            }
        }
    
        public void agregarACola(Cancion cancion) {
            cola.encolar(cancion);
        }
    
        public void verColaReproduccion() {
            cola.mostrarCola();
        }
    
        public void verHistorial() {
            historial.mostrarHistorial();
        }
}
