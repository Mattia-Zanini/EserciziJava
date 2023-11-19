
/*
 * Scrivere il programma EuclideMCD che calcoli il massimo comun divisore (MCD)
 * di due numeri interi positivi m e n acquisiti da standard input e lo visualizzi
 * sul flusso di uscita standard.
 * 
 * Si usi il noto Algoritmo di Euclide per il calcolo del MCD di due numeri interi
 * positivi m ed n (con m > n):
 * Finchè il resto della divisione di m per n è diverso da zero
 * 
 * il nuovo valore di m è uguale al precedente valore di n
 * 
 * il nuovo valore di n è uguale al resto della divisione del precedente valore di m
 * per il precedente valore di n
 * 
 * Il MCD è l'attuale valore di n
 */
import java.util.Scanner;

public class EuclideMCD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = 0, n = 0, mcd = 0, max = 0, min = 0, tmp;

        do {
            System.out.println("Inserisci il primo numero:");
            m = Integer.parseInt(input.nextLine());

            if (m <= 0)
                System.out.println("Il numero deve essere maggiore di 0.");
        } while (m <= 0);
        do {
            System.out.println("Inserisci il secondo numero:");
            n = Integer.parseInt(input.nextLine());

            if (n <= 0)
                System.out.println("Il numero deve essere maggiore di 0.");
        } while (n <= 0);
        input.close();

        System.out.println("M: " + m);
        System.out.println("N: " + n);

        // Trovo chi è numero più grande e quello più piccolo
        if (m > n) {
            max = m;
            min = n;
        } else if (m < n) {
            max = n;
            min = m;
        }
        // se i due numeri sono uguali non ha senso calcolare l'MCD
        else
            mcd = m;

        if (mcd != m) {
            while (true) {
                tmp = max % min;
                System.out.printf("modulo di: (%d,%d) = %d\n", max, min, tmp);

                max = min;
                mcd = min;
                min = tmp;

                // se il modulo diventa 0 significa che non ci sono più denominatori comuni
                if (tmp == 0)
                    break;
            }
        }

        System.out.println("MCD dei due numeri: " + mcd);
    }
}