public class ArrayTable100 implements Table {
    private final int MAX_SIZE = 100;
    private Object[] v;
    private int count; // count rende isEmpty O(1)

    public ArrayTable100() {
        v = new Object[MAX_SIZE];
        makeEmpty();
    }

    public void makeEmpty() {
        count = 0;
        for (int i = 0; i < v.length; i++)
            v[i] = null;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int count() {
        return count;
    }

    private void check(int key) {
        if (key < 0 || key >= v.length)
            throw new InvalidPositionTableException();
    }

    public void insert(int key, Object value) {
        check(key);
        if (v[key] == null) {
            count++;
            v[key] = value;
        } else
            v[key] = value;
    }

    public void remove(int key) {
        check(key);
        if (v[key] != null) {
            count--;
            v[key] = null;
        } else
            v[key] = null;
    }

    public Object find(int key) {
        check(key);
        return v[key];
    }
}

class InvalidPositionTableException extends RuntimeException {
}