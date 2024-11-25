public class SistemaControlVersiones {
    public static void main(String[] args) {
        ArbolVersiones arbolVersiones = new ArbolVersiones();
        new InterfazUsuario(arbolVersiones).iniciar();
    }
}
