
/*
 * Scrivere in Java un programma che chieda all'utente un numero intero positivo x
 * e stabilisca se x è potenza di 2 oppure no.
 */
import java.util.Scanner;

public class PotenzaDiDue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x, p = 1;
        do {
            System.out.print("Inserisci x positivo: ");
            x = input.nextInt();
            if (x <= 0)
                System.out.println("Il numero deve essere positivo != 0");
        } while (x <= 0);
        input.close();

        while (p < x)
            p *= 2;

        if (p == x)
            System.out.println(x + " è una potenza di 2");
        else
            System.out.println(x + " NON è una potenza di 2");
    }
}