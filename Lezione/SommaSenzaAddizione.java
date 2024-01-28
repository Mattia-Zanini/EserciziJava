/*
 * Supponiamo di disporre di un sistema di calcolo priva della 
 * addizione, della sottrazione, della moltiplicazione, della
 * divisione, dotato solo delle operazioni di successore
 * (incremento di una unità di predecessore diminuzione di una unità)
 * e dei cicli.
 * In tale contesto, si desidera scrivere un programma in linguaggio Java
 * che chieda in input i due addendi interi non negativi x,y ed esegua l'operazione
 * di addizione producendo in output la somma.
 */

import java.util.Scanner;

public class SommaSenzaAddizione {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x, y;
        System.out.println("Addizione tra interi non negativi");
        do {
            System.out.println("Primo addendo: ");
            x = input.nextInt();
            if (x < 0)
                System.out.println("Primo addendo negativo, errato");
        } while (x < 0);
        do {
            System.out.println("Secondo addendo: ");
            y = input.nextInt();
            if (y < 0)
                System.out.println("Secondo addendo negativo, errato");
        } while (y < 0);

        while (y > 0) {
            x += 1;
            y -= 1;
        }

        System.out.println("la somma è (x): " + x);
        System.out.println("y: " + y);
        input.close();
    }
}