public class Fila {

  private int tamaño;
  private int[] fila;

  public Fila(int capacidad) {
    this.tamaño = 0;
    this.fila = new int[capacidad];
  }

  public void entraPersona() {
    if (tamaño < fila.length) {
      fila[tamaño] = 1;
      tamaño++;
    } else {
      System.out.println("No entra nadie mas, la fila esta llena");
    }
  }

  public void atender() {
    if (tamaño > 0) {
      System.out.println("Atendiendo a la primera persona en la fila.");

      for (int i = 0; i < tamaño; i++) {
        fila[i] = fila[i + 1];
      }
    } else {
      System.out.println("No hay personas en la fila para atender");
    }
  }

  public void aburrimientoPersona(int posicion) {
    if (posicion < tamaño && posicion >= 0) {
      System.out.println(
        "La persona " + (posicion + 1) + " se va de la cola por aburrimiento"
      );
    }

    for (int i = 1; i < tamaño; i++) {
      fila[i - 1] = fila[i];
      tamaño--;
    }
  }

  public void personaTraeCosas(int posicion) {
    if (posicion < tamaño && posicion >= 0) {
      System.out.println(
        "A la persona de la posicion " + (posicion + 1) + " Le han traido cosas"
      );
    }
  }

  public void personaSeCuela(int posicion) {
    if (posicion < tamaño && posicion >= 0 && tamaño < fila.length) {
      for (int i = tamaño; i > posicion; i--) {
        fila[i] = fila[i - 1];
      }
      fila[posicion] = 1;
      tamaño++;
      System.out.println("Una persona se ha colado en la posición " + posicion);
    } else {
      System.out.println("No es posible colarse en esa posición.");
    }
  }
}
