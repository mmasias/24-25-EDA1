public class Pila {
    private Object[] elementos;
    private int tope;

    public Pila() {
        this.elementos = new Object[10];
        this.tope = -1; 
    }

    public boolean isEmpty() {
        return tope == -1; 
    }

    public void push(Object elemento) {
        if (tope + 1 < elementos.length) {
            elementos[++tope] = elemento; 
        } else {
            System.out.println("Pila llena, no se puede agregar el elemento.");
        }
    }

    public Object pop() {
        if (!isEmpty()) {
            Object elemento = elementos[tope];
            elementos[tope--] = null; 
            return elemento;
        } else {
            System.out.println("Pila vacía, no se puede sacar un elemento.");
            return null;
        }
    }

    public Object peek() {
        if (!isEmpty()) {
            return elementos[tope]; 
        } else {
            System.out.println("Pila vacía, no hay elementos.");
            return null;
        }
    }
}
