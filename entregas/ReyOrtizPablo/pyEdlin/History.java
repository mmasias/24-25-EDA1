package entregas.ReyOrtizPablo.pyEdlin;

class History {
    private String[][] elements;
    private int top;
    private int capacity;

    public History(int capacity, int documentLength) {
        this.capacity = capacity;
        this.top = -1;
        this.elements = new String[capacity][documentLength];
    }

    public void push(String[] state) {
        if (top + 1 < capacity) {
            top++;
        } else {

            for (int i = 1; i < capacity; i++) {
                elements[i - 1] = elements[i];
            }
        }


        elements[top] = new String[state.length];
        System.arraycopy(state, 0, elements[top], 0, state.length);
    }

    public String[] pop() {
        if (top == -1) {
            return null;
        }
        String[] state = elements[top];
        top--;
        return state;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}