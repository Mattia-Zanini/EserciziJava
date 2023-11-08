import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n;

        System.out.println("Inserisci un numero intero pari");
        n = input.nextInt();

        double resto = n / 2;

        // System.out.println("Questo è il valore di resto double: " + resto);
        // System.out.println("Questo è il valore di resto int: " + (int) resto);

        if (resto - (int) resto > 0.0) {
            System.out.println("Inserisci un secondo numero intero pari");
            n = input.nextInt();

            resto = n / 2;
            if (resto - (int) resto > 0.0)
                System.out.println("Mmmmmmm! Il numero " + n + " NON è pari");
            else
                System.out.println("Bravo! Il numero " + n + " è pari");
        } else
            System.out.println("Bravo! Il numero " + n + " è pari");

        input.close();
    }
}