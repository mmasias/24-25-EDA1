import java.util.ArrayList;
import java.util.List;

class Commit {
    String hash;
    String mensaje;
    Commit padre;

    public Commit(String hash, String mensaje, Commit padre) {
        this.hash = hash;
        this.mensaje = mensaje;
        this.padre = padre;
    }

    @Override
    public String toString() {
        return "Commit{" +
               "hash='" + hash + '\'' +
               ", mensaje='" + mensaje + '\'' +
               '}';
    }
}

class Rama {
    String nombre;
    Commit cabeza;

    public Rama(String nombre) {
        this.nombre = nombre;
        this.cabeza = null;
    }

    public void agregarCommit(String hash, String mensaje) {
        this.cabeza = new Commit(hash, mensaje, this.cabeza);
    }

    public void mostrarHistorial() {
        System.out.println("Historial de la rama " + nombre + ":");
        Commit actual = cabeza;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.padre;
        }
    }
}

class Repositorio {
    String nombre;
    List<Rama> ramas;

    public Repositorio(String nombre) {
        this.nombre = nombre;
        this.ramas = new ArrayList<>();
        this.ramas.add(new Rama("main"));
    }

    public Rama obtenerRama(String nombre) {
        for (Rama rama : ramas) {
            if (rama.nombre.equals(nombre)) {
                return rama;
            }
        }
        return null;
    }

    public void crearRama(String nombre) {
        if (obtenerRama(nombre) == null) {
            ramas.add(new Rama(nombre));
            System.out.println("Rama '" + nombre + "' creada.");
        } else {
            System.out.println("La rama '" + nombre + "' ya existe.");
        }
    }

    public void mostrarRamas() {
        System.out.println("Ramas en el repositorio '" + nombre + "':");
        for (Rama rama : ramas) {
            System.out.println("- " + rama.nombre);
        }
    }
}

public class GitHubModel {
    public static void main(String[] args) {
        Repositorio repo = new Repositorio("MiProyecto");

        Rama main = repo.obtenerRama("main");
        main.agregarCommit("a1b2c3", "Commit inicial");
        main.agregarCommit("d4e5f6", "Añadida funcionalidad básica");

        repo.crearRama("feature-arboles");
        Rama feature = repo.obtenerRama("feature-arboles");
        feature.agregarCommit("g7h8i9", "Inicio de desarrollo en feature-arboles");

        repo.mostrarRamas();
        main.mostrarHistorial();
        feature.mostrarHistorial();
    }
}
