package romeroAngel.reto003b;

public class StringStorage {
    private String[] strings;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public StringStorage() {
        strings = new String[INITIAL_CAPACITY];
        size = 0;
    }

    public void addString(String str) {
        if (size == strings.length) {
            expandCapacity();
        }
        strings[size] = str;
        size++;
    }

    public boolean contains(String str) {
        for (int i = 0; i < size; i++) {
            if (strings[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    public int findString(String str) {
        for (int i = 0; i < size; i++) {
            if (strings[i].equals(str)) {
                return i+1;
            }
        }
        throw new IllegalArgumentException("String no encontrado");
    }

    private void expandCapacity() {
        String[] newArray = new String[strings.length * 2];
        System.arraycopy(strings, 0, newArray, 0, size);
        strings = newArray;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        StringStorage storage = new StringStorage();
        storage.addString("Hola");
        storage.addString("Mundo");

        if (storage.contains("Hola")) {
            int index = storage.findString("Hola");
            System.out.println("'Hola' encontrado: " + index);
        }

        if (storage.contains("Java")) {
            System.out.println("'Java' está en el almacenamiento");
        } else {
            System.out.println("'Java' no está en el almacenamiento");
        }

        storage.showContents();
    }

    public void showContents() {
        System.out.print("DICCIONARIO: ");
        for (int i = 0; i < size; i++) {
            System.out.print("(" + (i+1) + ":[" + strings[i] + "])");
        }
        System.out.println();
    }
}
