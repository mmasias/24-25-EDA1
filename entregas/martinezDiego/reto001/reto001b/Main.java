package reto001b;

public class Main {

    public static void main(String[] args) {
        Orden orden = new Orden(25);
        Orden orden2 = new Orden();
     
      

        orden.insertar('A');
        orden.insertar('B');
        orden.insertar('C');
        orden.mostrar();
   
        int []indices={1,3,2};
        orden.mostrar(indices);

     
        int[]indices2={2,3,1};
        orden.mostrar(indices2);
       
        orden.eliminar('B');
        orden.mostrar();

        orden.insertar('D');
        orden.insertar('E');
        orden.mostrar();

        orden.eliminar('C');
        orden.mostrar();
    }
}