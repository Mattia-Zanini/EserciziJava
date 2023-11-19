
/*
 * Scrivere in Java un programma che chieda all'utente la base
 * b, l'altezza h di un rettangolo, controllando che siano non negative
 * mediante un ciclo do...while e quindi calcoli il perimetro e l'area
 */
import java.util.Scanner;

public class RettangoloWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double b, h, p, A;
        do {
            System.out.println("base: ");
            b = input.nextDouble();
            if (b < 0)
                System.out.println("base inserita errata");
        } while (b < 0);

        do {
            System.out.println("base: ");
            h = input.nextDouble();
            if (h < 0)
                System.out.println("base inserita errata");
        } while (h < 0);
        input.close();

        p = 2 * (b + h);
        A = b * h;

        System.out.println("perimetro: " + p);
        System.out.println("area: " + A);
    }
}