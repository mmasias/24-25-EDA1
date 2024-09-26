import java.util.LinkedList;
import java.util.Queue;

public class Cola {
    
    private Queue<String> fila;

    public Cola() {
        fila = new LinkedList<>();
    }

    
    public void llegaPersona(String nombre) {
        fila.add(nombre);
        System.out.println(nombre + " ha llegado a la fila.");
        mostrarCola();
        mensajeCaja();
    }

    
    public void atenderPersona() {
        if (!fila.isEmpty()) {
            String personaAtendida = fila.poll();
            System.out.println(personaAtendida + " está siendo atendido.");
        } else {
            System.out.println("No hay nadie en la fila para atender.");
        }
        mostrarCola();
    }

    
    public void personaSeVa(String nombre) {
        if (fila.contains(nombre)) {
            fila.remove(nombre);
            System.out.println(nombre + " se ha ido de la fila.");
        } else {
            System.out.println(nombre + " no está en la fila.");
        }
        mostrarCola();
    }

   
    public void traeCosas(String nombre) {
        if (fila.contains(nombre)) {
            System.out.println("A " + nombre + " le han traído las cosas mientras está en la fila.");
        } else {
            System.out.println(nombre + " no está en la fila.");
        }
        mostrarCola();
    }

    
    public void colarseLicitamente(String nombre) {
        if (!fila.isEmpty()) {
            ((LinkedList<String>) fila).addFirst(nombre);
            System.out.println(nombre + " se ha colado lícitamente al frente de la fila.");
        } else {
            llegaPersona(nombre); 
        }
        mostrarCola();
    }

    
    public void colarseIlicitamente(String nombre) {
        if (!fila.isEmpty()) {
            ((LinkedList<String>) fila).add(1, nombre);  
            System.out.println(nombre + " se ha colado ilícitamente en la fila.");
        } else {
            llegaPersona(nombre); 
        }
        mostrarCola();
    }

    
    public void mensajeCaja() {
        if (fila.size() > 5) { 
            System.out.println("Desde el centro comercial se oye: 'Pasen por esta caja en orden de fila...'");
        }
    }

   
    public void mostrarCola() {
        System.out.println("Personas en la fila: " + fila);
    }

    public static void main(String[] args) {
        Cola cola = new Cola();

        
        cola.llegaPersona("Juan");
        cola.llegaPersona("Ana");
        cola.llegaPersona("Luis");
        cola.llegaPersona("Marta");
        cola.llegaPersona("Pedro");

        cola.colarseIlicitamente("Carlos");

      
        cola.atenderPersona();

        
        cola.personaSeVa("Marta");

        
        cola.traeCosas("Pedro");

      
        cola.colarseLicitamente("Sara");

        
        cola.atenderPersona();

        
        cola.llegaPersona("Elena");
        cola.llegaPersona("José");

        
        cola.mensajeCaja();

       
    }
}
