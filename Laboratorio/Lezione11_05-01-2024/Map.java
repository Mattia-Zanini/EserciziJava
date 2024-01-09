public interface Map extends Container {
    /**
     * restituisce il valore al quale la chiave
     * specificata e’ associata, o null se questa mappa
     * non contiene associazione per la chiave.
     */
    Object get(Object key);

    /**
     * rimuove l’associazione di chiave specificata se
     * questa e’ presente nella mappa. Restituisce il
     * valore associato (o null se non c’era associazione)
     */
    Object remove(Object key);

    /**
     * Inserisce l’associazione di chiave e valore specificati
     * in questa mappa. Se la mappa gia’ conteneva un’asso-
     * ciazione con questa chiave (altrimenti null), il
     * vecchio valore e’ sostituito con il valore specificato
     * e restituito in uscita.
     */
    Object put(Object key, Object value);

    /**
     * restituisce un array contenente le chiavi di tutte le
     * associazioni presenti nella mappa
     */
    Object[] keys();
}