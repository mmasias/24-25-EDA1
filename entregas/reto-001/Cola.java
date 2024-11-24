import java.util.ArrayList;

public class Cola {
    
    private ArrayList<String> fila1;
    private ArrayList<String> fila2;

    public Cola() {
        fila1 = new ArrayList<>();
        fila2 = new ArrayList<>();
    }

    public void llegaPersona(String nombre, int numeroFila) {
        if (numeroFila == 1) {
            fila1.add(nombre);
            System.out.println(nombre + " ha llegado a la fila 1.");
        } else if (numeroFila == 2) {
            fila2.add(nombre);
            System.out.println(nombre + " ha llegado a la fila 2.");
        } else {
            System.out.println("Número de fila inválido.");
            return;
        }
        mostrarCola();
        mensajeCaja();
    }

    public void atenderPersona(int numeroFila) {
        if (numeroFila == 1) {
            if (!fila1.isEmpty()) {
                String personaAtendida = fila1.remove(0);
                System.out.println(personaAtendida + " está siendo atendido en la caja 1.");
            } else {
                System.out.println("No hay nadie en la fila 1 para atender.");
            }
        } else if (numeroFila == 2) {
            if (!fila2.isEmpty()) {
                String personaAtendida = fila2.remove(0);
                System.out.println(personaAtendida + " está siendo atendido en la caja 2.");
            } else {
                System.out.println("No hay nadie en la fila 2 para atender.");
            }
        } else {
            System.out.println("Número de fila inválido.");
        }
        mostrarCola();
    }

    public void personaSeVa(String nombre, int numeroFila) {
        if (numeroFila == 1 && fila1.contains(nombre)) {
            fila1.remove(nombre);
            System.out.println(nombre + " se ha ido de la fila 1.");
        } else if (numeroFila == 2 && fila2.contains(nombre)) {
            fila2.remove(nombre);
            System.out.println(nombre + " se ha ido de la fila 2.");
        } else {
            System.out.println(nombre + " no está en la fila especificada.");
        }
        mostrarCola();
    }

    public void traeCosas(String nombre, int numeroFila) {
        if (numeroFila == 1 && fila1.contains(nombre)) {
            System.out.println("A " + nombre + " le han traído las cosas mientras está en la fila 1.");
        } else if (numeroFila == 2 && fila2.contains(nombre)) {
            System.out.println("A " + nombre + " le han traído las cosas mientras está en la fila 2.");
        } else {
            System.out.println(nombre + " no está en la fila especificada.");
        }
        mostrarCola();
    }

    public void colarseLicitamente(String nombre, int numeroFila) {
        if (numeroFila == 1) {
            if (!fila1.isEmpty()) {
                fila1.add(0, nombre);
                System.out.println(nombre + " se ha colado lícitamente al frente de la fila 1.");
            } else {
                llegaPersona(nombre, 1);
            }
        } else if (numeroFila == 2) {
            if (!fila2.isEmpty()) {
                fila2.add(0, nombre);
                System.out.println(nombre + " se ha colado lícitamente al frente de la fila 2.");
            } else {
                llegaPersona(nombre, 2);
            }
        } else {
            System.out.println("Número de fila inválido.");
        }
        mostrarCola();
    }

    public void colarseIlicitamente(String nombre, int numeroFila) {
        if (numeroFila == 1) {
            if (!fila1.isEmpty()) {
                fila1.add(1, nombre);
                System.out.println(nombre + " se ha colado ilícitamente en la fila 1.");
            } else {
                llegaPersona(nombre, 1);
            }
        } else if (numeroFila == 2) {
            if (!fila2.isEmpty()) {
                fila2.add(1, nombre);
                System.out.println(nombre + " se ha colado ilícitamente en la fila 2.");
            } else {
                llegaPersona(nombre, 2);
            }
        } else {
            System.out.println("Número de fila inválido.");
        }
        mostrarCola();
    }

    public void mensajeCaja() {
        if (fila1.size() > 5 || fila2.size() > 5) { 
            System.out.println("Desde el centro comercial se oye: 'Pasen por esta caja en orden de fila...'");
        }
    }

    public void mostrarCola() {
        System.out.println("Personas en la fila 1: " + fila1);
        System.out.println("Personas en la fila 2: " + fila2);
    }

    public static void main(String[] args) {
        Cola cola = new Cola();

        cola.llegaPersona("Juan", 1);
        cola.llegaPersona("Ana", 1);
        cola.llegaPersona("Luis", 1);
        cola.llegaPersona("Marta", 2);
        cola.llegaPersona("Pedro", 2);

        cola.colarseIlicitamente("Carlos", 1);

        cola.atenderPersona(1);

        cola.personaSeVa("Marta", 2);

        cola.traeCosas("Pedro", 2);

        cola.colarseLicitamente("Sara", 1);

        cola.atenderPersona(1);

        cola.llegaPersona("Elena", 2);
        cola.llegaPersona("José", 1);

        cola.mensajeCaja();
    }
}
