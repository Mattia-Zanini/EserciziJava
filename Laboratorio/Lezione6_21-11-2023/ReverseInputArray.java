
/*
 * Leggere un numero arbitrario di interi da standard input e riportarli in uscita
 * in ordine inverso di inserimento.
 */
import java.util.Scanner;

public class ReverseInputArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Inserisci il " + (i + 1) + " numero");
            array[i] = input.nextInt();
        }
        input.close();
        for (int i = array.length - 1; i >= 0; i--)
            System.out.println("[" + i + "] => " + array[i]);
    }
}