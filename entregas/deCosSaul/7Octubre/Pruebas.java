public class Pruebas {
    public static void main(String[] args) {
        List alumnos = new List();
        alumnos.insertEnd("prueba");
        alumnos.insertEnd("asdf");
        alumnos.insertEnd("asdf");
        alumnos.insertEnd("asdf");
        alumnos.insertEnd("asdf");
        alumnos.mostrar();
        System.out.println("=".repeat(40));
        FoundList alumnosEncontrados = alumnos.find("asdf");
        alumnosEncontrados.mostrar();
        System.out.println("=".repeat(40));
        alumnos.mostrar();
    }
}
