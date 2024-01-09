public class SortedArraySortedMap implements SortedMap {
	private Pair[] mapArray; // contiene i dati ordinati per chiave (sempre ordinato)
	private int size; // indica la dimensione attuale dell'array

	public SortedArraySortedMap() {
		mapArray = new Pair[1];
		makeEmpty();
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void makeEmpty() {
		size = 0;
	}

	public Object get(Object key) {
		int pos = binarySearch(0, size - 1, (Comparable) key);
		if (pos == -1)
			return null;
		return mapArray[pos].getValue();
	}

	public Object remove(Object key) {
		int pos = binarySearch(0, size - 1, (Comparable) key);
		if (pos == -1)
			return null; // non c'è una corrispondenza con la chiave
		Object removed = mapArray[pos];
		// sposto gli elementi a destra del dato da rimuovere verso sinistra
		// (vado a riempire lo spazione che creerebbe il dato rimosso)
		for (int i = pos; i < size - 1; i++)
			mapArray[i] = mapArray[i + 1];
		size--;
		return removed;
	}

	public Object put(Object key, Object value) {
		// lancio un eccezzione se la chiave oppure il valore del dato sono null
		// oppure se la chiave non implementa l'interfaccia `Comparable`
		if (key == null || value == null || !(key instanceof Comparable))
			// lancio un eccezzione
			throw new IllegalArgumentException();
		int pos = binarySearch(0, size - 1, (Comparable) key);
		if (pos != -1) {
			// Significa che il dato è già presente all'interno della mappa
			Object old = mapArray[pos].getValue();
			// nuova associazione
			mapArray[pos] = new Pair((Comparable) key, value);
			// non si incrementa size
			return old; // ritorno l'oggetto sostituito
		}
		// Se non c'è, controllo se la mappa e' piena e nel caso
		// la mappa sia piena la ridimensiono con una dimensione maggiore
		if (size == mapArray.length)
			mapArray = resize(mapArray, 2 * mapArray.length);

		// Inserisco il nuovo dato all'interno dell'array ordinato
		// quindi confronto tutte le chiavi con quelle del dato che devo inserire
		// copiando il riferimento nella posizione [i + 1] quando la chiave
		// da inserire è più piccola di quella nella posizione [i] e quando invece
		// è maggiore di quella nella posizione [i] allora fermo il ciclo while
		// e la inserisco nella posizione [i + 1]. Non mi preoccupo del caso in cui
		// la chiave sia uguale ad un altra perhè ho già effettuato un controllo prima
		int i = size - 1;
		while (i >= 0 && ((Comparable) key).compareTo(mapArray[i].getKey()) < 0) {
			mapArray[i + 1] = mapArray[i];
			i--;
		}
		// inserisco nell'array, nella posizione [i + 1] perchè tanto la
		// la posizione [i + 2] contiene lo stesso riferimento all'oggetto che
		// è in posizione [i + 1]
		mapArray[i + 1] = new Pair((Comparable) key, value);
		size++; // incremento la dimensione
		// ritorno null in quanto non ho sostituito nessun oggetto già presente
		return null;
	}

	public Object[] keys() {
		Object[] keys = new Object[size];
		for (int i = 0; i < size; i++)
			keys[i] = mapArray[i].getKey();
		return keys;
	}

	// basta ritornare una lista delle chiavi, visto che vengono ordinate
	// all'inserimento di esse
	public Comparable[] sortedKeys() {
		Comparable[] keys = new Comparable[size];
		for (int i = 0; i < size; i++)
			keys[i] = (Comparable) mapArray[i].getKey();
		return keys;
	}

	private int binarySearch(int left, int right, Comparable target) {
		// non è accettabile che il valore di destra sia maggiore di quello di sinistra
		if (right < left)
			return -1;
		// calcolo la posizione centrale della mappa
		int m = (left + right) / 2;
		int compareResult = mapArray[m].getKey().compareTo(target);
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
	 * Ridimensiona la mappa
	 * 
	 * @param oldMapArray riferimento alla vecchia mappa da ridimensionare
	 * @param newSize     nuova dimensione che la mappa deve assumere
	 * @return riferimento alla nuova mappa ridimensionata
	 */
	private Pair[] resize(Pair[] oldMapArray, int newSize) {
		Pair[] newMapArray = new Pair[newSize];
		System.arraycopy(oldMapArray, 0, newMapArray, 0, oldMapArray.length);
		return newMapArray;
	}

	/**
	 * classe interna privata per definire il singolo dato
	 * con una coppia (chiave, valore), solo SortedArraySortedMap
	 * può vedere questa classe ed utilizzare i suoi metodi.
	 * Visto che è una classe che contiene dati con chiavi comparabili
	 * (ovvero si può stabilire una relazione d'ordine) richiedo che
	 * le chiavi siano `Comparable`
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