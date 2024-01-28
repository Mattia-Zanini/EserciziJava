public class ArraySet implements Set {
    private final static int INITIAL_CAPACITY = 1;
    private Object[] v;
    private int vSize;

    public ArraySet() {
        v = new Object[INITIAL_CAPACITY];
        makeEmpty();
    }

    public void makeEmpty() {
        vSize = 0;
    }

    public boolean isEmpty() {
        return vSize == 0;
    }

    public int size() {
        return vSize;
    }

    public void add(Object x) {
        if (contains(x))
            return; // fallisce silenziosamente
        if (vSize == v.length)
            v = resize(v, vSize);
        v[vSize++] = x;
    }

    // O(n^2)
    public static Set union(Set s1, Set s2) {
        Set x = new ArraySet();
        // inserisco gli elementi del primo insieme
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++)
            x.add(v[i]);
        // inserisco gli elementi del secondo insieme
        v = s2.toArray();
        for (int i = 0; i < v.length; i++)
            x.add(v[i]);
        return x;
    }

    public static Set intersection(Set s1, Set s2) {
        Set x = new ArraySet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++) {
            if (s2.contains(v[i]))
                x.add(v[i]);
        }
        return x;
    }

    public static Set subtract(Set s1, Set s2) {
        Set x = new ArraySet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++) {
            if (!s2.contains(v[i]))
                x.add(v[i]);
        }
        return x;
    }

    // O(n)
    public boolean contains(Object x) {
        return sequentialSearch(v, x, vSize);
    }

    // O(n)
    public Object[] toArray() {
        Object[] x = new Object[vSize];
        System.arraycopy(v, 0, x, 0, vSize);
        return x;
    }

    private static boolean sequentialSearch(Object[] a, Object target, int size) {
        for (int i = 0; i < size; i++) {
            if (a[i].equals(target))
                return true;
        }
        return false;
    }

    private static Object[] resize(Object[] v, int n) {
        Object[] x = new Object[n * 2];
        System.arraycopy(v, 0, x, 0, v.length);
        return x;
    }
}