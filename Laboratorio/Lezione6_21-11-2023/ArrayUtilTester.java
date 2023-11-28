import java.util.Scanner;

public class ArrayUtilTester {
    public static void main(String[] args) {
        int arrSize = 10, intSize = arrSize, doubleSize = arrSize;
        int[] arr = new int[arrSize];
        double[] arrDouble = new double[arrSize];

        int min = 0, max = 100;

        for (int i = 0; i < arrSize; i++) {
            arr[i] = (int) (min + (1 + max - min) * Math.random());
            arrDouble[i] = (double) (min + (1 + max - min) * Math.random());
        }

        System.out.println(ArrayUtilClass.printArray(arr, arr.length));
        System.out.println(ArrayUtilClass.printArray(arrDouble, arrDouble.length));

        System.out.println("\nChiamo resize:\n");
        arr = ArrayUtilClass.resize(arr, 7);
        intSize = 7;
        arrDouble = ArrayUtilClass.resize(arrDouble, 12);
        doubleSize = 12;

        System.out.println(ArrayUtilClass.printArray(arr, intSize));
        System.out.println(ArrayUtilClass.printArray(arrDouble, doubleSize));

        System.out.println("\nChiamo remove:\n");
        ArrayUtilClass.remove(arr, arr.length, 1);
        intSize--;
        System.out.println(ArrayUtilClass.printArray(arr, intSize));

        System.out.println("\nChiamo removeSorted:\n");
        ArrayUtilClass.removeSorted(arr, arr.length, 2);
        intSize--;
        System.out.println(ArrayUtilClass.printArray(arr, intSize));

        System.out.println("\nChiamo insert:\n");
        arr = ArrayUtilClass.insert(arr, arr.length, 3, 77);
        intSize++;
        System.out.println(ArrayUtilClass.printArray(arr, intSize));

        System.out.println("Il numero minimo è: " + ArrayUtilClass.findMin(arr, intSize));
        System.out.println("Il numero massimo è: " + ArrayUtilClass.findMax(arr, intSize));

        int num = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Che numero vuoi cercare?");
        num = Integer.parseInt(input.nextLine());
        input.close();

        System.out.println("Il numero " + num + " si trova in posizione: " + ArrayUtilClass.find(arr, intSize, num));
    }
}