class ArrayMultiMap implements MultiMap {
    private Pair[] dictionaryArray;
    private int size;

    public ArrayMultiMap() {
        dictionaryArray = new Pair[1];
        size = 0;
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

        if (dictionaryArray.length == size)
            dictionaryArray = resize(dictionaryArray, 2 * size);
        dictionaryArray[size++] = new Pair(key, value);
        // size++; // l'ho commentato perchè viene già effettuato l'incremento
        // della variabile dopo il suo utilizzo nella riga sopra
        // ritorno null in quanto non ho sostituito nessun oggetto già presente
    }

    public Object remove(Object key) {
        if (key == null)
            return null;

        int pos = search(key);
        if (pos == -1)
            return null;
        Object old = dictionaryArray[pos];
        dictionaryArray[pos] = dictionaryArray[size - 1];
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
        if (key == null)
            return -1;

        for (int i = 0; i < size; i++) {
            if (dictionaryArray[i].getKey().equals(key))
                return i;
        }
        return -1;
    }

    public Object find(Object key) {
        if (key == null)
            return null;

        for (int i = 0; i < size; i++) {
            if (dictionaryArray[i].getKey().equals(key))
                return dictionaryArray[i].getValue();
        }
        return null;
    }

    public Object[] findAll(Object key) {
        if (key == null)
            return new Object[0];

        Object[] objects = new Object[0];
        int n = 0;
        for (int i = 0; i < size; i++) {
            if (dictionaryArray[i].getKey().equals(key)) {
                if (n == 0)
                    objects = new Object[1];
                if (n == objects.length)
                    objects = resize(objects, 2 * n);
                objects[n] = dictionaryArray[i].getValue();
                n++;
            }
        }
        return objects;
    }

    public Object[] keys() {
        Object[] keys = new Object[size];
        for (int i = 0; i < size; i++)
            keys[i] = dictionaryArray[i].getKey();
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

    /**
     * classe interna privata per definire il singolo dato
     * con una coppia (chiave, valore), solo ArrayMultiMap
     * può vedere questa classe ed utilizzare i suoi metodi.
     */
    private class Pair {
        private Object key;// chiave del dato
        private Object value; // valore del dato

        // costruttore
        public Pair(Object k, Object v) {
            setKey(k);
            setValue(v);
        }

        // ottiene la chiave del dato
        public Object getKey() {
            return key;
        }

        // ottiene il valore del dato
        public Object getValue() {
            return value;
        }

        // imposta la chiave del dato
        public void setKey(Object k) {
            key = k;
        }

        // imposta il valore del dato
        public void setValue(Object v) {
            value = v;
        }
    }
}