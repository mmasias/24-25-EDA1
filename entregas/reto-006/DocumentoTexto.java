public class DocumentoTexto {
    private ColeccionLineas lineas;
    private InterfazUsuario interfaz;

    public DocumentoTexto() {
        this.lineas = new ColeccionLineas();
        this.interfaz = new InterfazUsuario(lineas);
    }

    public void ejecutar() {
        interfaz.iniciar();
    }
}