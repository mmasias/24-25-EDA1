import java.util.ArrayList;
import java.util.List;

public class Directorio {
    public String nombre;
    public List<Archivo> archivos = new ArrayList<>();
    public List<Directorio> subdirectorios = new ArrayList<>();

    public void agregarArchivo(Archivo archivo) {
        archivos.add(archivo);
    }

    public void eliminarArchivo(String nombre) {
        archivos.removeIf(archivo -> archivo.nombre.equals(nombre));
    }

    public Archivo obtenerArchivo(String nombre) {
        return archivos.stream()
                .filter(archivo -> archivo.nombre.equals(nombre))
                .findFirst()
                .orElse(null);
    }
}
