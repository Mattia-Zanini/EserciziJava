
/*
 * Formula deviazione standardi: D = Math.sqrt((A - B*B/n)/(n-1))
 * 
 * dove n è il numero di valori, B è la somma di tutti i valori e A è la somma dei
 * quadrati di tutti i valori. La formula è valida soltanto per n > 1
 * (per n = 1 la deviazione standard vale 0, per definizione).
 */
import java.util.Scanner;

public class StandardDeviation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num, n = 0;
        double A = 0, B = 0, dev = 0;

        System.out.print("Inserisci un numero: ");
        while (input.hasNextInt()) {
            num = input.nextInt();
            n++;

            B += num;
            A += num * num;

            System.out.print("Inserisci un numero: ");
        }
        input.close();

        if (n < 2) {
            System.out.println("Devi inserire almeno 2 numeri");
            System.exit(1);
        }

        System.out.println("Somma dei quadrati di tutti i valori: " + A);
        System.out.println("Somma di tutti i valori: " + B);
        System.out.println("Numero di valori: " + n);

        dev = Math.sqrt((A - B * B / n) / (n - 1));
        System.out.println("Deviazione standard: " + dev);
    }
}