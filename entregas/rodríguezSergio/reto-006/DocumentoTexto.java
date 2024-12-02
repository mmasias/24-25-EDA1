public class DocumentoTexto {

    private ColeccionLineas lineas;
    private PilaHistorial pilaDeshacer;
    private PilaHistorial pilaRehacer;
    private InterfazUsuario interfaz;

    public DocumentoTexto() {
        this.lineas = new ColeccionLineas();
        this.pilaDeshacer = new PilaHistorial();
        this.pilaRehacer = new PilaHistorial();
        this.interfaz = new InterfazUsuario(lineas, pilaDeshacer, pilaRehacer);
    }

    public void ejecutar() {
        interfaz.iniciar();
    }
}