/*
 * Scrivere un programma che converta un numero intero in base 10 in una base 
 * qualsiasi 𝑏>1. Si scelga il numero da convertire nell'intervallo chiuso [0,(𝑏^3)−1]
 * in modo che sia esprimibile con tre cifre nella nuova base. La base 𝑏 e il numero
 * da convertire vanno dichiarati come variabili intere nel codice, dove potete 
 * assegnare loro un valore. Esempio se la base scelta e' 7, si scelga il numero 
 * fra 0 e 342(7^3=343). 

 * Suggerimento per l'algoritmo da usare: algoritmo di conversione da base decimale a 
 * base generica 𝑏 (invece che dividere per 2, come visto in classe per il caso binario,
 * si divide per 𝑏). Verificare il risultato: ad esempio se il numero decimale e' 256 e
 * la base b=7: 256(base 10) = 514(base 7) = 5*7^2 + 1*7^1 + 4*7^0
 * Dopo aver provato con valori di variabili assegnati direttamente nel codice sorgente,
 * modificare il programma in modo che la base e il valore decimale da convertire
 * vengano specificati dall'utente da standard input e non fissati nel codice.
 */

import java.util.Scanner;

public class GeneralBaseNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci una base");
        int base = input.nextInt();

        if (base <= 1) {
            System.out.println("La base deve essere maggiore di 1");
            System.exit(1);
        }
        int maxNumber = (base * base * base);

        System.out.println("Inserisci un numero in base 10 da convertire in base: " + base +
                "\nIl numero deve essere minore di: " + maxNumber);
        int numero = input.nextInt();

        if (numero <= 0 || numero > maxNumber) {
            System.out.println("Il numero deve essere maggiore di 0 e minore di: " + maxNumber);
            System.exit(1);
        }

        // Converte il numero da base 10 alla base desiderata
        // immagine della funzione [0,(𝑏^3)−1]

        int[] genericBaseNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            int resto = numero % base;
            numero = numero / base;

            genericBaseNumber[i] = resto;
        }

        System.out.println("Il tuo numero in base: " + base + " è il seguente: "
                + genericBaseNumber[2] + genericBaseNumber[1] + genericBaseNumber[0]);

    }
}
