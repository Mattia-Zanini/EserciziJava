public class ArrayDeque implements Deque {
    private Object[] v;
    private int front, back;

    public ArrayDeque() {
        v = new Object[1];
        front = back = 0;
    }

    public boolean isEmpty() {
        return back == front;
    }

    public void makeEmpty() {
        front = back = 0;
    }

    public void addFirst(Object element) {
        if (increment(back) == front)
            resizeDeque();

        for (int i = increment(back); i > front; i = decrement(i)) {
            v[i] = v[decrement(i)];
        }
        v[front] = element;
        back = increment(back);
    }

    public void addLast(Object element) {
        if (increment(back) == front)
            resizeDeque();

        v[back] = element;
        back = increment(back);
    }

    public Object getFirst() {
        return v[front];
    }

    public Object getLast() {
        return v[back];
    }

    public Object removeFirst() {
        Object o = v[front];
        front = increment(front);
        return o;
    }

    public Object removeLast() {
        Object o = v[decrement(back)];
        back = decrement(back);
        return o;
    }

    public void printDeque() {
        for (int i = front; i < back; i = increment(i)) {
            System.out.printf("[%d] => %d\n", i, v[i]);
        }
    }

    public void printReverseDeque() {
        for (int i = decrement(back); i >= front; i = decrement(i)) {
            System.out.printf("[%d] => %d\n", i, v[i]);
        }
    }

    public int getLength() {
        return v.length;
    }

    // il metodo increment fa avanzare un indice di una
    // posizione, tornando all’inizio dell’array se si supera la fine
    private int increment(int index) {
        return (index + 1) % v.length;
    }

    private int decrement(int index) {
        // return (index - 1) % v.length;
        return increment(index - 2);
    }

    private Object[] resize(Object[] oldArray, int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        return newArray;
    }

    private void resizeDeque() {
        v = resize(v, 2 * v.length);
        // se si ridimensiona l’array e la zona utile della coda si trova
        // attorno alla sua fine, la seconda metà del nuovo v rimane vuota
        // e provoca un malfunzionamento della coda, che si risolve
        // spostandovi la parte della coda che si trova all’inizio dell’array
        if (back < front) {
            System.arraycopy(v, 0, v, v.length / 2, back);
            back += v.length / 2;
        }
    }
}