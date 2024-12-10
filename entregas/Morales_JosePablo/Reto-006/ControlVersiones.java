import java.util.ArrayList;
import java.util.List;

public class ControlVersiones {
    public Rama ramaActual;
    public List<Rama> ramas = new ArrayList<>();
    private String dominio = "mi-dominio";

    public Rama crearRama(String nombre) {
        Rama rama = new Rama();
        rama.nombre = nombre;
        ramas.add(rama);
        return rama;
    }

    public void cambiarRama(String nombre) {
        ramaActual = ramas.stream()
                .filter(rama -> rama.nombre.equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public List<Commit> obtenerHistorialVersiones() {
        return ramaActual != null ? ramaActual.commits : new ArrayList<>();
    }

    public String getDominio() {
        return dominio;
    }
}
