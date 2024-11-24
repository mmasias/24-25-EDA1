public class PilaCancion {
  NodoDoble tope;

  public void push(Cancion cancion) {
    NodoDoble nuevoNodo = new NodoDoble(cancion);
    nuevoNodo.siguiente = tope;
    if (tope != null) {
      tope.anterior = nuevoNodo;
    }
    tope = nuevoNodo;
  }

  public Cancion pop() {
    if (tope == null) {
      System.out.println("El historial está vacío.");
      return null;
    }
    Cancion cancion = tope.cancion;
    tope = tope.siguiente;
    if (tope != null) {
      tope.anterior = null;
    }
    return cancion;
  }

  public void imprimirPila() {
    NodoDoble actual = tope;
    while (actual != null) {
      System.out.println(actual.cancion);
      actual = actual.siguiente;
    }
  }

}
