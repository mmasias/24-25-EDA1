public class Pruebas {
    public static void main(String[] args) {
        List alumnos = new List();
        alumnos.insertEnd("prueba");
        alumnos.insertEnd("prueba");
        alumnos.insertEnd("prueba");
        alumnos.insertEnd("prueba");
        alumnos.insertEnd("asdf");
        alumnos.insertEnd("asdf");
        alumnos.insertEnd("asdf");
        FoundList alumnosEncontrados = alumnos.find("prueba");
        alumnosEncontrados.mostrar();
    }
}
