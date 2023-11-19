
/*
 * Scrivere in Java un programma che chieda all'utente il dividendo intero non negativo
 * x , il divisore intero positivo y ed esegue la divisione intero con resto,
 * calcolando il quoziente q, il resto r.
 */
import java.util.Scanner;

public class AlgoritmoDivisioneIntera {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x, y, q = 0, r;

        do {
            System.out.println("Dividendo x:");
            x = input.nextInt();
            if (x < 0)
                System.out.println("dividendo negativo, errato");
        } while (x < 0);
        do {
            System.out.println("Divisore x:");
            y = input.nextInt();
            if (y <= 0)
                System.out.println("il divisore deve essere positivo");
        } while (y <= 0);
        input.close();

        while (x >= y) {
            x = x - y;
            q++;
        }
        r = x;
        System.out.println("quoziente: " + q);
        System.out.println("Resto: " + r);
    }
}