public class ArbolVersiones {
    private NodoVersion raiz;
    private NodoVersion versionActual;

    public ArbolVersiones() {
        this.raiz = null;
        this.versionActual = null;
    }

    public void agregarVersion(int cantidadArchivos) {
        NodoVersion nuevoNodo = new NodoVersion(cantidadArchivos, versionActual);
        if (raiz == null) {
            raiz = nuevoNodo;
            versionActual = raiz;
        } else {
            versionActual.agregarHijo(nuevoNodo);
            versionActual = nuevoNodo;
        }
    }

    public String obtenerVersionActual() {
        return (versionActual == null) ? "No hay versiones aún." : versionActual.mostrar();
    }

    public void moverAPadre() {
        if (versionActual == null || versionActual.getPadre() == null) {
            System.out.println("Estás en la versión raíz.");
        } else {
            versionActual = versionActual.getPadre();
        }
    }

    public void moverAPrimerHijo() {
        if (versionActual == null || versionActual.getPrimerHijo() == null) {
            System.out.println("No hay versiones hijas disponibles.");
        } else {
            versionActual = versionActual.getPrimerHijo();
        }
    }

    public void moverASiguienteHermano() {
        if (versionActual == null || versionActual.getHermanoSiguiente() == null) {
            System.out.println("No hay un hermano siguiente disponible.");
        } else {
            versionActual = versionActual.getHermanoSiguiente();
        }
    }

    public void moverAAnteriorHermano() {
        if (versionActual == null || versionActual.getHermanoAnterior() == null) {
            System.out.println("No hay un hermano anterior disponible.");
        } else {
            versionActual = versionActual.getHermanoAnterior();
        }
    }

    public void mostrarArbol() {
        if (raiz == null) {
            System.out.println("No hay versiones en el sistema.");
        } else {
            mostrarArbolRecursivo(raiz, "", true);
        }
    }

    private void mostrarArbolRecursivo(NodoVersion nodo, String prefijo, boolean esUltimo) {
        String representacionNodo = (nodo == versionActual) ? "[" + nodo.mostrar() + "]" : nodo.mostrar();
        System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + representacionNodo);

        NodoVersion hijo = nodo.getPrimerHijo();
        while (hijo != null) {
            mostrarArbolRecursivo(hijo, prefijo + (esUltimo ? "    " : "│   "), hijo.getHermanoSiguiente() == null);
            hijo = hijo.getHermanoSiguiente();
        }
    }
}
