public class ArrayTable100 implements Table {
    private Object[] v;
    private final int TABLE_SIZE = 100;
    private int count;

    public ArrayTable100() {
        v = new Object[TABLE_SIZE];
        makeEmpty();
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void makeEmpty() {
        count = 0;
    }

    // Controlla che il valore della chiave sia valido
    private void check(int key) {
        if (key < 0 || key >= v.length)
            throw new InvalidPositionTableException();
    }

    public void insert(int key, Object value) {
        check(key);
        // controllo se non ci sia già un valore alla posizione desiderata in caso
        // non ci sia aumento count, sennò vado a sostituire il valore e basta
        if (v[key] == null) {
            v[key] = value;
            count++;
        } else
            v[key] = value;
    }

    public void remove(int key) {
        check(key);
        // decremento il valore di count solo se c'è un valore all'interno
        // della posizione desiderata
        if (v[key] != null) {
            v[key] = null;
            count--;
        }
    }

    public Object find(int key) {
        check(key);
        return v[key];
    }
}

class InvalidPositionTableException extends RuntimeException {
}