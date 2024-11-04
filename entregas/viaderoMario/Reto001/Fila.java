public class Fila {

  private String[] fila;
  private int maxPersonas;
  private int tamaño;

  public Fila(int maxPersonas) {
    this.maxPersonas = maxPersonas;
    fila = new String[maxPersonas];
    tamaño = 0;
  }

  public void agregarPersona(String nombre) {
    if (tamaño < maxPersonas) {
      fila[tamaño] = nombre;
      tamaño++;
      System.out.println(nombre + " se ha unido a la fila.");
    } else {
      System.out.println(
        "La fila está llena. No se puede agregar más personas."
      );
    }
  }

  public void atenderPersona() {
    if (tamaño > 0) {
      String atendido = fila[0];

      for (int i = 1; i < tamaño; i++) {
        fila[i - 1] = fila[i];
      }
      tamaño--;
      System.out.println(atendido + " ha sido atendido.");
    } else {
      System.out.println("No hay nadie en la fila.");
    }
  }

  public void mostrarFila() {
    if (tamaño == 0) {
      System.out.println("La fila está vacía.");
    } else {
      System.out.print("Personas en la fila:");
      for (int i = 0; i < tamaño; i++) {
        System.out.print("  " + (i + 1) + "-" + fila[i] + "     ");
      }
      System.out.println();
    }
  }

  public void colarse(String nombre) {
    if (tamaño < maxPersonas) {
      for (int i = tamaño; i > 0; i--) {
        fila[i] = fila[i - 1];
      }
      fila[0] = nombre;
      tamaño++;
      System.out.println(nombre + " se ha colado en la fila.");
    } else {
      System.out.println("La fila está llena. No se puede colar más personas.");
    }
  }

  public void irse(String nombre) {
    for (int i = 0; i < tamaño; i++) {
      if (fila[i].equals(nombre)) {
        for (int j = i; j < tamaño - 1; j++) {
          fila[j] = fila[j + 1];
        }
        tamaño--;
        System.out.println(nombre + " se ha ido porque se aburrió.");
        return;
      }
    }
    System.out.println(nombre + " no se encuentra en la fila.");
  }

  public void traerCosas(String deQuien, String paraQuien) {
    boolean encontradoDe = false;
    boolean encontradoPara = false;

    for (int i = 0; i < tamaño; i++) {
      if (fila[i] == deQuien) {
        encontradoDe = true;
      }
      if (fila[i] == paraQuien) {
        encontradoPara = true;
      }
    }

    if (encontradoDe && encontradoPara) {
      System.out.println(deQuien + " le trae cosas a " + paraQuien + ".");
    }
  }
}
