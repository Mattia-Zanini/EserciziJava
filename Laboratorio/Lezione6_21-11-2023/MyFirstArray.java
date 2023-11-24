public class MyFirstArray {
    public static void main(String[] args) {
        int var = 10;// assegnato un numero arbitrario
        int[] array = new int[10];
        // init array
        for (int i = 0; i < array.length; i++)
            array[i] = i;

        // Parte A
        System.out.println("Lunghezza array: " + array.length);
        for (int i = 0; i < array.length; i++)
            System.out.println("[" + i + "] => " + array[i]);
        System.out.println("");// for making some space
        for (int i = array.length - 1; i >= 0; i--)
            System.out.println("[" + i + "] => " + array[i]);
        System.out.println("");// for making some space

        // Parte B
        incrementAll(array);
        System.out.println("Array dopo aver chiamato il metodo incrementAll()");// for making some space
        for (int i = 0; i < array.length; i++)
            System.out.println("[" + i + "] => " + array[i]);

        System.out.println("Numero: " + var);
        incrementVar(var);
        System.out.println("Numero dopo aver chiamato il metodo incrementVar(): " + var);
    }

    public static void incrementAll(int[] a) {
        for (int i = 0; i < a.length; i++)
            a[i]++;
    }

    public static void incrementVar(int value) {
        value = value + 1;
    }
}