public class SortedArrayMultiMap implements MultiMap {
    private Pair[] dictionarySortedArray;
    private int size;

    public SortedArrayMultiMap() {
        dictionarySortedArray = new Pair[1];
        makeEmpty();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void makeEmpty() {
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(Object key, Object value) {
        if (key == null || value == null)
            throw new IllegalArgumentException();

        if (size == 0) {
            dictionarySortedArray[size++] = new Pair((Comparable) key, value);
            return;
        }

        if (dictionarySortedArray.length == size)
            dictionarySortedArray = resize(dictionarySortedArray, 2 * size);
        int i = size - 1;
        while (i >= 0 && ((Comparable) key).compareTo(dictionarySortedArray[i].getKey()) < 0) {
            dictionarySortedArray[i + 1] = dictionarySortedArray[i];
            i--;
        }
        dictionarySortedArray[i + 1] = new Pair((Comparable) key, value);
        size++;
    }

    public Object remove(Object key) {
        if (key == null)
            return null;

        int pos = search(key);
        if (pos == -1)
            return null;
        Object old = dictionarySortedArray[pos];
        for (int i = pos; i < size - 1; i++)
            dictionarySortedArray[i] = dictionarySortedArray[i + 1];
        size--;
        return old;
    }

    public Object[] removeAll(Object key) {
        Object[] olds = new Object[0];
        int n = 0;

        if (key == null)
            return olds;

        int pos = search(key);
        if (pos == -1)
            return olds;

        for (int i = 0; i < size; i++) {
            int posToRemove = search(key);
            if (posToRemove == -1)
                break;
            if (i == 0)
                olds = new Object[1];

            if (n == olds.length)
                olds = resize(olds, 2 * n);
            olds[n] = remove(key);
            n++;
        }
        return olds;
    }

    private int search(Object key) {
        if (key == null || !(key instanceof Comparable))
            return -1;

        return binarySearch(0, size - 1, (Comparable) key);
    }

    public Object find(Object key) {
        if (key == null)
            return null;

        for (int i = 0; i < size; i++) {
            if (dictionarySortedArray[i].getKey().equals(key))
                return dictionarySortedArray[i].getValue();
        }
        return null;
    }

    public Object[] findAll(Object key) {
        if (key == null)
            return new Object[0];

        Object[] objects = new Object[0];
        int n = 0;
        for (int i = 0; i < size; i++) {
            if (dictionarySortedArray[i].getKey().equals(key)) {
                if (n == 0)
                    objects = new Object[1];
                if (n == objects.length)
                    objects = resize(objects, 2 * n);
                objects[n] = dictionarySortedArray[i].getValue();
                n++;
            }
        }
        return objects;
    }

    public Object[] keys() {
        Object[] keys = new Object[size];
        for (int i = 0; i < size; i++)
            keys[i] = dictionarySortedArray[i].getKey();
        return keys;
    }

    /**
     * Ridimensiona la mappa
     * 
     * @param oldMapArray riferimento alla vecchia mappa da ridimensionare
     * @param newSize     nuova dimensione che la mappa deve assumere
     * @return riferimento alla nuova mappa ridimensionata
     */
    private Pair[] resize(Pair[] oldDictionaryArray, int newSize) {
        Pair[] newMapArray = new Pair[newSize];
        System.arraycopy(oldDictionaryArray, 0, newMapArray, 0, oldDictionaryArray.length);
        return newMapArray;
    }

    private Object[] resize(Object[] oldArray, int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        return newArray;
    }

    private int binarySearch(int left, int right, Comparable target) {
        // non è accettabile che il valore di destra sia maggiore di quello di sinistra
        if (right < left)
            return -1;
        // calcolo la posizione centrale della mappa
        int m = (left + right) / 2;
        int compareResult = dictionarySortedArray[m].getKey().compareTo(target);
        // Controlla se il target è proprio l'elemento al centro
        if (compareResult == 0)
            return m;
        else if (compareResult < 0)
            // In questo caso l'elemento è più grande di quello centrale e questo
            // implica che devo cercare nella metà di destra
            return binarySearch(m + 1, right, target);
        else
            // In questo caso l'elemento è più piccolo di quello centrale e questo
            // implica che devo cercare nella metà di sinistra
            return binarySearch(left, m - 1, target);
    }

    /**
     * classe interna privata per definire il singolo dato
     * con una coppia (chiave, valore), solo ArrayMultiMap
     * può vedere questa classe ed utilizzare i suoi metodi.
     */
    private class Pair {
        private Comparable key;// chiave del dato
        private Object value; // valore del dato

        // costruttore
        public Pair(Comparable k, Object v) {
            setKey(k);
            setValue(v);
        }

        // ottiene la chiave del dato
        public Comparable getKey() {
            return key;
        }

        // ottiene il valore del dato
        public Object getValue() {
            return value;
        }

        // imposta la chiave del dato
        public void setKey(Comparable k) {
            key = k;
        }

        // imposta il valore del dato
        public void setValue(Object v) {
            value = v;
        }
    }
}