import java.util.ArrayList;
import java.util.List;

public class Rama {
    public String nombre;
    public List<Commit> commits = new ArrayList<>();

    public Commit crearCommit(String mensaje, Directorio directorio) {
        Commit commit = new Commit();
        commit.mensaje = mensaje;
        commit.fecha = new Date();
        return commit;
    }

    public void cambiarCommit(Commit commit) {
    }
}
