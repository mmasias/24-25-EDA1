import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        Repositorio repo = new Repositorio("MiProyecto");
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear rama");
            System.out.println("2. Agregar commit a una rama");
            System.out.println("3. Mostrar ramas");
            System.out.println("4. Mostrar historial de una rama");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre de la nueva rama: ");
                    String nombreRama = scanner.nextLine();
                    repo.crearRama(nombreRama);
                    break;

                case 2:
                    System.out.print("Introduce el nombre de la rama: ");
                    String ramaCommit = scanner.nextLine();
                    Rama rama = repo.obtenerRama(ramaCommit);
                    if (rama != null) {
                        System.out.print("Introduce el hash del commit: ");
                        String hash = scanner.nextLine();
                        System.out.print("Introduce el mensaje del commit: ");
                        String mensaje = scanner.nextLine();
                        rama.agregarCommit(hash, mensaje);
                        System.out.println("Commit añadido a la rama '" + ramaCommit + "'.");
                    } else {
                        System.out.println("La rama '" + ramaCommit + "' no existe.");
                    }
                    break;

                case 3:
                    repo.mostrarRamas();
                    break;

                case 4:
                    System.out.print("Introduce el nombre de la rama: ");
                    String ramaHistorial = scanner.nextLine();
                    Rama ramaParaHistorial = repo.obtenerRama(ramaHistorial);
                    if (ramaParaHistorial != null) {
                        ramaParaHistorial.mostrarHistorial();
                    } else {
                        System.out.println("La rama '" + ramaHistorial + "' no existe.");
                    }
                    break;

                case 5:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
