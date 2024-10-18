import java.util.Scanner;

class Main {
   private static final double PROBABILIDAD_NUEVO_CLIENTE = 0.9;
   private static final double PROBABILIDAD_MOVER_CLIENTE = 0.3;
   private static final double PROBABILIDAD_AGREGAR_ITEMS = 0.2;
   private static final double PROBABILIDAD_CLIENTE_ABURRIDO = 0.2;
   private static final int TAMANO_MAX_COLA = 20;

   private static Cliente[] cola = new Cliente[TAMANO_MAX_COLA];
   private static Cliente[] otraCola = new Cliente[TAMANO_MAX_COLA];

   private static int colaUltimo = 0;
   private static int otraColaUltimo = 0;

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Presiona Enter para simular");
      while (scanner.nextLine().isEmpty()) {
         simular();
      }

      scanner.close();
   }

   private static void simular() {
      if (eventoOcurre(PROBABILIDAD_NUEVO_CLIENTE)) {
         agregarNuevoCliente();
      }

      if (eventoOcurre(PROBABILIDAD_MOVER_CLIENTE)) {
         moverClienteDeLaCola();
      }

      if (eventoOcurre(PROBABILIDAD_CLIENTE_ABURRIDO)) {
         clienteSeAburre();
      }

      if (colaUltimo > 0 && eventoOcurre(PROBABILIDAD_AGREGAR_ITEMS)) {
         agregarItemsAleatoriosACliente();
      }

      imprimirCola();
   }

   private static boolean eventoOcurre(double probabilidad) {
      return Math.random() < probabilidad;
   }

   private static void agregarNuevoCliente() {
      if (colaUltimo >= 10 && otraColaUltimo < TAMANO_MAX_COLA) {
         System.out.println("Pasen por esta caja en orden de fila");
         desplazarOtraCola(0);
         return;
      }

      if (colaUltimo < TAMANO_MAX_COLA) {
         cola[colaUltimo] = new Cliente();
         colaUltimo++;
         System.out.println("Nuevo cliente agregado.");
      } else {
         System.out.println("La cola está llena. No se puede agregar un nuevo cliente.");
      }
   }

   private static void moverClienteDeLaCola() {
      if (colaUltimo > 0) {
         desplazarColaIzquierda(0);
         colaUltimo--;
         System.out.println("Cliente movido de la cola.");
      }
   }

   private static void clienteSeAburre() {
      int indiceClienteAleatorio = (int) (Math.random() * colaUltimo);

      if (colaUltimo > 0) {
         System.out.println("Cliente " + (indiceClienteAleatorio + 1) + " se aburrió y se fue.");
         desplazarColaIzquierda(indiceClienteAleatorio);
         colaUltimo--;
      }
   }

   private static void desplazarColaIzquierda(int indiceCliente) {
      for (int i = indiceCliente; i < colaUltimo - 1; i++) {
         cola[i] = cola[i + 1];
      }
   }

   private static void desplazarOtraCola(int indiceCliente) {
      int longitud = colaUltimo + 1;
      for (int i = indiceCliente; i < (longitud / 2); i++) {
         otraCola[otraColaUltimo] = cola[i];
         moverClienteDeLaCola();
         otraColaUltimo++;
      }
   }

   private static void agregarItemsAleatoriosACliente() {
      int indiceClienteAleatorio = (int) (Math.random() * colaUltimo);
      cola[indiceClienteAleatorio].agregarItems(3, indiceClienteAleatorio + 1);
   }

   private static void imprimirCola() {
      System.out.println("\nCola");
      System.out.println("-".repeat(50));
      for (int i = 0; i < colaUltimo; i++) {
         System.out.print("(" + (i + 1) + ")");
         cola[i].imprimirCliente();
      }
      System.out.println("\nTotal de clientes en la cola: " + colaUltimo);
      System.out.println("-".repeat(50));

      if (otraColaUltimo > 0) {
         System.out.println("\nOtra cola");
         System.out.println("-".repeat(50));
         for (int i = 0; i < otraColaUltimo; i++) {
            System.out.print("(" + (i + 1) + ")");
            otraCola[i].imprimirCliente();
         }
         System.out.println("\nTotal de clientes en la cola: " + otraColaUltimo);
         System.out.println("-".repeat(50));
      }
   }
}
