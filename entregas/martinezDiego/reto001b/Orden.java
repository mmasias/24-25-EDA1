package reto001b;

public class Orden {

    private final int maximo;
    private int numeroElementos = 0;
    private char[] dato;

    public Orden() {
        this.maximo = 50;
        this.dato = new char[maximo];
    }

    public Orden(int limite) {
        this.maximo = limite;
        this.dato = new char[limite];

    }

    public void insertar(char letra) {
        if (numeroElementos < maximo) {
            dato[numeroElementos] = letra;
            numeroElementos++;
        } else {
            System.out.println("no se pueden añadir mas elementos");
        }
    }

    public void mostrar() {
        System.out.println("-----------------------------");
        for (int i = 0; i < numeroElementos; i++) {
            System.out.println((i + 1) + " " + dato[i]);

        }
        System.out.println("-----------------------------");
    }

    public void mostrar(int indices[]) {
        System.out.println("-----------------------------");
        for (int i = 0; i < indices.length; i++) {
            System.out.println((indices[i]) + " " + dato[indices[i] - 1]);

        }
        System.out.println("-----------------------------");
    }

    public void eliminar(char elemento) {
        for (int i = 0; i < numeroElementos; i++) {
            if (dato[i] == elemento) {
                for (int j = i; j < numeroElementos - 1; j++) {
                    dato[j] = dato[j + 1];
                }
                numeroElementos--;

            }

        }
    }
}
