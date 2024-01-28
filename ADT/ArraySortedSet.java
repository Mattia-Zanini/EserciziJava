public class ArraySortedSet implements SortedSet {
    private final static int INITIAL_CAPACITY = 1;
    private Comparable[] v;
    private int vSize;

    public ArraySortedSet() {
        v = new Comparable[INITIAL_CAPACITY];
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
        throw new IllegalArgumentException();
    }

    public void add(Comparable x) {
        if (contains(x))
            return; // fallisce silenziosamente
        if (vSize == v.length)
            v = resize(v, vSize);
        v[vSize++] = x;
        sort();
    }

    // O(n^2)
    public static SortedSet union2(SortedSet s1, SortedSet s2) {
        SortedSet x = new ArraySortedSet();
        // inserisco gli elementi del primo insieme
        Comparable[] v = s1.toSortedArray();
        for (int i = 0; i < v.length; i++)
            x.add(v[i]);
        // inserisco gli elementi del secondo insieme
        v = s2.toSortedArray();
        for (int i = 0; i < v.length; i++)
            x.add(v[i]);

        ((ArraySortedSet) x).sort();
        return x;
    }

    public static SortedSet union(SortedSet s1, SortedSet s2) {
        SortedSet x = new ArraySortedSet();
        Comparable[] v1 = s1.toSortedArray();
        Comparable[] v2 = s2.toSortedArray();
        int i = 0, j = 0;
        while (i < v1.length && j < v2.length) {
            if (v1[i].compareTo(v2[j]) < 0)
                x.add(v1[i++]);
            // contains:O(log n); ins:O(1)
            else if (v1[i].compareTo(v2[j]) > 0)
                x.add(v2[j++]);
            else // sono uguali: avanzo entrambi gli indici
            {
                x.add(v1[i++]);
                j++;
            }
        }
        while (i < v1.length)
            x.add(v1[i++]);
        while (j < v2.length)
            x.add(v2[j++]);
        return x;
    }

    public static SortedSet intersection2(SortedSet s1, SortedSet s2) {
        SortedSet x = new ArraySortedSet();
        Comparable[] v = s1.toSortedArray();
        for (int i = 0; i < v.length; i++) {
            if (s2.contains(v[i]))
                x.add(v[i]);
        }

        ((ArraySortedSet) x).sort();
        return x;
    }

    /**
     * Returns a new sorted set that is the intersection of two sorted sets.
     * 
     * Questo metodo prende come input due set ordinati e restituisce un nuovo set
     * ordinato che è l'intersezione dei due. Il codice inizia creando un nuovo
     * insieme ordinato vuoto x.
     * Dato che, successivamente, verranno convertiti in array i due set di input s1
     * e s2.
     * Il codice quindi utilizza un approccio a due puntatori per iterare sui
     * elementi di v1 e v2. L'idea è di muovere entrambi i puntatori allo stesso
     * tempo, e quando l'elemento alla posizione corrente del primo puntatore
     * (v1[i]) è maggiore dell'elemento alla posizione corrente del secondo
     * puntatore (v2[j]), il secondo puntatore viene spostato avanti di uno.
     * Questo processo continua fino a quando il primo o il secondo puntatore non
     * raggiunge la fine della propria rispettiva matrice. Se l'elemento alla
     * posizione corrente del primo puntatore (v1[i]) è uguale all'elemento alla
     * posizione corrente del secondo puntatore (v2[j]), allora aggiungiamo
     * l'elemento al risultato x e muoviamo entrambi i puntatori avanti di uno.
     * Questo processo continua fino a quando tutti gli elementi sono stati
     * elaborati. Dopo aver elaborato tutti gli elementi, il codice restituisce il
     * SortedSet x. (Generato con Tabnine AI)
     *
     * @param s1 the first sorted set
     * @param s2 the second sorted set
     * @return a new sorted set that is the intersection of the two input sorted
     *         sets
     */
    public static SortedSet intersection(SortedSet s1, SortedSet s2) {
        SortedSet x = new ArraySortedSet();
        Comparable[] v1 = s1.toSortedArray();
        Comparable[] v2 = s2.toSortedArray();
        for (int i = 0, j = 0; i < v1.length; i++) {
            while (j < v2.length && v1[i].compareTo(v2[j]) > 0)
                j++;
            if (j == v2.length)
                break;
            if (v1[i].compareTo(v2[j]) == 0) {
                x.add(v1[i]);
                j++;
            }
        }
        return x;
    }

    public static SortedSet subtract2(SortedSet s1, SortedSet s2) {
        SortedSet x = new ArraySortedSet();
        Comparable[] v = s1.toSortedArray();
        for (int i = 0; i < v.length; i++) {
            if (!s2.contains(v[i]))
                x.add(v[i]);
        }

        ((ArraySortedSet) x).sort();
        return x;
    }

    public static SortedSet subtract(SortedSet s1, SortedSet s2) {
        SortedSet x = new ArraySortedSet();
        Comparable[] v1 = s1.toSortedArray();
        Comparable[] v2 = s2.toSortedArray();
        int i, j;
        for (i = 0, j = 0; i < v1.length; i++) {
            while (j < v2.length && v1[i].compareTo(v2[j]) > 0)
                j++;
            if (j == v2.length)
                break;
            if (v1[i].compareTo(v2[j]) != 0)
                x.add(v1[i]);
        }
        while (i < v1.length)
            x.add(v1[i++]);
        return x;
    }

    // O(log n)
    public boolean contains(Comparable x) {
        int result = binarySearch(x);
        if (result != -1)
            return true;
        else
            return false;
    }

    public boolean contains(Object x) {
        if (x instanceof Comparable)
            return contains((Comparable) x);
        else
            throw new IllegalArgumentException();
    }

    // O(n)
    public Object[] toArray() {
        return toSortedArray();
    }

    public Comparable[] toSortedArray() // O(n)
    {
        Comparable[] x = new Comparable[vSize];
        System.arraycopy(v, 0, x, 0, vSize);
        return x;
    }

    private static boolean sequentialSearch(Comparable[] a, Comparable target, int size) {
        for (int i = 0; i < size; i++) {
            if (a[i].equals(target))
                return true;
        }
        return false;
    }

    private static Comparable[] resize(Comparable[] v, int n) {
        Comparable[] x = new Comparable[n * 2];
        System.arraycopy(v, 0, x, 0, v.length);
        return x;
    }

    private int binarySearch(Comparable target) {
        return binarySearch(v, target, vSize - 1);
    }

    private static int binarySearch(Comparable[] v, Comparable target, int size) {
        return binSearch(v, target, 0, size);
    }

    private static int binSearch(Comparable[] v, Comparable target, int start, int end) {
        if (start > end)
            return -1; // non trovato caso base
        int mid = (start + end) / 2;
        Object middle = v[mid];
        int compare = ((Comparable) middle).compareTo(target);
        if (compare == 0)
            return mid;
        else if (compare < 0) // a destra
            return binSearch(v, target, mid + 1, end);
        else // (compare > 0) a sinistra
            return binSearch(v, target, start, mid - 1);
    }

    public void sort() {
        insertionSort(v, vSize);
    }

    private static void insertionSort(Comparable[] a, int size) {
        // comincio da 1 perche' e' l'unico elemento da non considerare alll'inizio
        for (int i = 1; i < size; i++) {
            // sposto a[i] verso sinistra finché serve:
            // - il primo elemento con cui confrontarlo è a[i-1], quindi parto con j = i-1
            for (int j = i - 1; j >= 0; j--) {
                if (a[j].compareTo(a[j + 1]) > 0)
                    swap(a, j, j + 1); // devo spostare a[j+1] verso sinistra
                else // non devo piu' spostare
                    break;
            }
        }
    }

    private static void swap(Comparable[] v, int a, int b) {
        Comparable tmp = v[b];
        v[b] = v[a];
        v[a] = tmp;
    }
}