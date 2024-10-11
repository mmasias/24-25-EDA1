public class Pruebas {
    public static void main(String[] args) {
        List alumnos = new List();
        alumnos.insertEnd("prueba");
        alumnos.insertEnd("prueba");
        alumnos.insertEnd("prueba");
        alumnos.insertEnd("pr2ueba");
        alumnos.insertEnd("pr2ueba");
        alumnos.insertEnd("asdf");
        alumnos.insertEnd("asdf");
        alumnos.insertEnd("asdf");
        alumnos.insertEnd("pr2ueba");
        alumnos.insertEnd("asdf");
        FoundList alumnosEncontrados = alumnos.find("asdf");
        alumnosEncontrados.mostrar();
    }
}
