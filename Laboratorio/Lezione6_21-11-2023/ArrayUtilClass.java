/*
 * Realizzare la classe ArrayUtil che contiene al suo interno il metodo resize visto
 * in classe, con l'aggiunta della possibilita' che il valore del parametro esplicito
 * newLength sia minore di quella dell'array. In questo caso restituire un array con
 * lo stesso contenuto (fino alla nuova dimensione) e troncato alla dimensione indicata.
 * 
 * Realizzare una versione di resize che ridimensiona un array di int e una che
 * ridimensiona un array di double. Il nome del metodo puo' rimanere invariato.
 * Questa proprieta' si chiama "sovraccarico". Il compilatore e' in grado di distinguere
 * tra le due in base al tipo di parametro passato.
 */
public class ArrayUtilClass {
    public static int[] resize(int[] array, int newSize) {
        int[] newArray;
        if (newSize == array.length)
            return array;
        else if (newSize > array.length) {
            newArray = new int[newSize];
            for (int i = 0; i < array.length; i++)
                newArray[i] = array[i];
            return newArray;
        } else {
            // newSize > array.length
            newArray = new int[newSize];
            for (int i = 0; i < newSize; i++)
                newArray[i] = array[i];
            // return newArray;
        }

        return newArray;
    }

    public static double[] resize(double[] array, int newSize) {
        double[] newArray;
        if (newSize == array.length)
            return array;
        else if (newSize > array.length) {
            newArray = new double[newSize];
            for (int i = 0; i < array.length; i++)
                newArray[i] = array[i];
            return newArray;
        } else {
            // newSize > array.length
            newArray = new double[newSize];
            for (int i = 0; i < newSize; i++)
                newArray[i] = array[i];
            // return newArray;
        }

        return newArray;
    }

    // generazione di un array di interi di numeri casuali (randomIntArray);
    public static int[] randomIntArray(int length, int n) {
        int[] array = new int[length];
        int min = 0, max = n;
        for (int i = 0; i < length; i++)
            array[i] = (int) (min + (1 + max - min) * Math.random());
        return array;
    }

    // INT
    // stampare il contenuto di un array (printArray);
    public static String printArray(int[] v, int vSize) {
        String result = "";
        for (int i = 0; i < vSize; i++)
            result += "[" + i + "] => " + v[i] + "\n";
        return result;
    }

    // DOUBLE
    // stampare il contenuto di un array (printArray);
    public static String printArray(double[] v, int vSize) {
        String result = "";
        for (int i = 0; i < vSize; i++)
            result += "[" + i + "] => " + v[i] + "\n";
        return result;
    }

    // eliminare un elemento (ordine non importante);
    public static void remove(int[] v, int vSize, int index) {
        if (index < vSize && index >= 0) {
            v[index] = v[vSize - 1];
            v[vSize - 1] = 0;
        }
    }

    // eliminare un elemento (ordine importante)
    public static void removeSorted(int[] v, int vSize, int index) {
        if (index < vSize && index >= 0) {
            for (int i = index; i < vSize - 1; i++)
                v[i] = v[i + 1];
            v[vSize - 1] = 0;
        }
    }

    // inserire un elemento
    public static void insert(int[] v, int vSize, int index, int value) {
        if (index < vSize && index >= 0) {
            for (int i = vSize - 2; i >= index; i--)
                v[i + 1] = v[i];

            v[index] = value;
        }
    }

    // ricerca del minimo
    public static int findMin(int[] v, int vSize) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < vSize; i++) {
            if (min > v[i])
                min = v[i];
        }

        return min;
    }

    // ricerca del massimo
    public static int findMax(int[] v, int vSize) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < vSize; i++) {
            if (max < v[i])
                max = v[i];
        }

        return max;
    }

    // ricerca di un valore in modo sequenziale
    public static int find(int[] v, int vSize, int target) {
        int pos = -1;
        for (int i = 0; i < vSize; i++) {
            if (target == v[i]) {
                pos = i;
                break;
            }
        }

        return pos;
    }
}