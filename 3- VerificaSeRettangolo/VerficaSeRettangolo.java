import java.util.Scanner;
import java.math.*;

public class VerficaSeRettangolo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b, c;
        System.out.println("Inserisci il valore di a:");
        a = input.nextDouble();
        System.out.println("Inserisci il valore di b:");
        b = input.nextDouble();
        System.out.println("Inserisci il valore di c:");
        c = input.nextDouble();

        if (a >= 0 && b >= 0 && c >= 0) {
            if ((a * a == b * b + c * c) ||
                    (b * b == a * a + c * c) ||
                    (c * c == b * b + a * a)) {
                System.out.println("è un triangolo rettangolo");
            } else {
                System.out.println("NON è un triangolo rettangolo");
            }
        } else {
            System.out.println("I lati inseriti non sono validi");
        }
    }
}
