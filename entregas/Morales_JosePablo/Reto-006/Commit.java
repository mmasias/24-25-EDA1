import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Commit {
    public String mensaje;
    public Date fecha;
    public Map<String, VersionArchivo> archivosGuardados = new HashMap<>();

    public void mostrarArchivos() {
        archivosGuardados.forEach((nombre, version) -> {
            System.out.println(nombre + ": " + version.contenido);
        }
                                 );
    }
}
