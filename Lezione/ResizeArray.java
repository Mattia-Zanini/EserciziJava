import java.util.Arrays;

public class ResizeArray {
    public static void main(String[] args) {
        int[] array = { 1, 4, 5, 6 };
        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "] = " + array[i]);
        }

        int newSize = 10; // resize to 10 elements
        int[] newArray = Arrays.copyOf(array, newSize);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println("newArray[" + i + "] = " + newArray[i]);
        }
    }
}