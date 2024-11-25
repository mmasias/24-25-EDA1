public class NodoVersion {
    private int cantidadArchivos;
    private NodoVersion padre;
    private NodoVersion hermanoAnterior;
    private NodoVersion hermanoSiguiente;
    private NodoVersion primerHijo;

    public NodoVersion(int cantidadArchivos, NodoVersion padre) {
        this.cantidadArchivos = cantidadArchivos;
        this.padre = padre;
        this.hermanoAnterior = null;
        this.hermanoSiguiente = null;
        this.primerHijo = null;
    }

    public int getCantidadArchivos() {
        return cantidadArchivos;
    }

    public NodoVersion getPadre() {
        return padre;
    }

    public NodoVersion getHermanoAnterior() {
        return hermanoAnterior;
    }

    public NodoVersion getHermanoSiguiente() {
        return hermanoSiguiente;
    }

    public NodoVersion getPrimerHijo() {
        return primerHijo;
    }

    public void setHermanoSiguiente(NodoVersion hermanoSiguiente) {
        this.hermanoSiguiente = hermanoSiguiente;
    }

    public void setHermanoAnterior(NodoVersion hermanoAnterior) {
        this.hermanoAnterior = hermanoAnterior;
    }

    public void agregarHijo(NodoVersion hijo) {
        if (primerHijo == null) {
            primerHijo = hijo;
        } else {
            NodoVersion actual = primerHijo;
            while (actual.hermanoSiguiente != null) {
                actual = actual.hermanoSiguiente;
            }
            actual.hermanoSiguiente = hijo;
            hijo.hermanoAnterior = actual;
        }
    }

    public String mostrar() {
        return cantidadArchivos + " archivos";
    }
}
