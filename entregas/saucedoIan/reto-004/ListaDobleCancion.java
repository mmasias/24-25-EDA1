public class ListaDobleCancion {
  NodoDoble cabeza;

  public void agregar(Cancion cancion) {
    NodoDoble nuevo = new NodoDoble(cancion);
    if (cabeza == null) {
      cabeza = nuevo;
      cabeza.siguiente = cabeza;
      cabeza.anterior = cabeza;
    } else {
      NodoDoble ultimo = cabeza.anterior;
      ultimo.siguiente = nuevo;
      nuevo.anterior = ultimo;
      nuevo.siguiente = cabeza;
      cabeza.anterior = nuevo;
    }
  }

  public Cancion obtenerSiguiente() {
    if (cabeza != null) {
      Cancion cancion = cabeza.cancion;
      cabeza = cabeza.siguiente;
      return cancion;
    }
    return null;
  }

  public Cancion obtenerCancionAleatoria() {
    NodoDoble actual = cabeza;
    int pasos = (int) (Math.random() * obtenerSize());
    while (pasos-- > 0 && actual != null) {
      actual = actual.siguiente;
    }
    return actual.cancion;
  }

  public int obtenerSize() {
    int size = 0;
    NodoDoble actual = cabeza;
    if (actual != null) {
      do {
        size++;
        actual = actual.siguiente;
      } while (actual != cabeza);
    }
    return size;
  }

  public void imprimirLista() {
    NodoDoble actual = cabeza;
    if (actual != null) {
      do {
        System.out.println(actual.cancion);
        actual = actual.siguiente;
      } while (actual != cabeza);
    }
  }
}
