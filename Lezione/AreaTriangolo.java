/*
 * Scrivere in Java un programma che chieda all'utente le lunghezze a,b,c 
 * dei lati di un triangolo e calcoli l'area S con la foermula di Erone.
 */

import java.util.Scanner;

public class AreaTriangolo {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        double a, b, c, p, S;
        System.out.println("Inserisci il valore del lato a");
        a = input.nextDouble();
        System.out.println("Inserisci il valore del lato b");
        b = input.nextDouble();
        System.out.println("Inserisci il valore del lato c");
        c = input.nextDouble();

        if (a < 0 || b < 0 || c < 0) {
            System.out.println("Un lato che hai inserito è minore di 0");
            System.exit(1);
        }
        if (a > b + c || b > a + c || c > a + b) {
            System.out.println("Un lato che hai inserito è maggiore della somma degli altri due");
            System.exit(1);
        }
        if (a < Math.abs(b - c) || b < Math.abs(a - c) || c < Math.abs(a - b)) {
            System.out
                    .println("Un lato che hai inserito è minore del valore assoluto della differenza degli altri due");
            System.exit(1);
        }

        p = (a + b + c) / 2;
        S = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.println("Il perimetro vale: " + p);
        System.out.println("L'area vale: " + S);
        input.close();
    }
}
