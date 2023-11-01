
/*
 * Scrivere il programma PrintEasterDayForYear che calcoli la data della 
 * domenica di Pasqua di un anno specifico (dichiarare una variabile di tipo 
 * intero e assegnarle il valore dell'anno che volete utilizzare). La domenica 
 * di Pasqua è la prima domenica dopo la prima luna piena di primavera e la sua 
 * data può essere calcolata con questo algoritmo, individuato da Carl Friedrich 
 * Gauss nel 1800.
 * 
 * Parti dal valore assegnato all'anno y, un numero intero non negativo
 * Dividi y per 19, ottenendo il resto a. Ignora il quoziente.
 * Dividi y per 100, ottenendo quoziente b e resto c.
 * Dividi b per 4, ottenendo quoziente d e resto e.
 * Dividi (8b+13) per 25, ottenendo il quoziente g. Ignora il resto.
 * Dividi (19a+b-d-g+15) per 30, ottenendo il resto h. Ignora il quoziente.
 * Dividi c per 4, ottenendo quoziente j e resto k.
 * Dividi (a+11h) per 319, ottenendo il quoziente m. Ignora il resto.
 * Dividi (2e+2j-k-h+m+32) per 7, ottenendo il resto r. Ignora il quoziente.
 * Dividi (h-m+r+90) per 25, ottenendo il quoziente n. Ignora il resto.
 * Dividi (h-m+r+n+19) per 32, ottenendo il resto p. Ignora il quoziente.
 * Pasqua è il giorno p del mese n dell'anno y.
 * 
 * Dopo aver provato con valori di variabili assegnati direttamente nel codice 
 * sorgente, modificare il programma in modo che l'anno y venga specificato 
 * dall'utente leggendolo da standard input e non fissato nel codice.
 */
import java.util.Scanner;

public class PrintEasterDayForYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int y;
        System.out.println("Inserisci un anno maggiore di 0");
        y = input.nextInt();

        if (y <= 0) {
            System.out.println("L'anno deve essere maggiore di 0");
            System.exit(1);
        }

        // * Dividi y per 19, ottenendo il resto a. Ignora il quoziente.
        int a = y % 19;
        // * Dividi y per 100, ottenendo quoziente b e resto c.
        int b = y / 100;
        int c = y % 100;
        // * Dividi b per 4, ottenendo quoziente d e resto e.
        int d = b / 4;
        int e = b % 4;
        // * Dividi (8b+13) per 25, ottenendo il quoziente g. Ignora il resto.
        int g = (8 * b + 13) / 25;
        // * Dividi (19a+b-d-g+15) per 30, ottenendo il resto h. Ignora il quoziente.
        int h = (19 * a + b - d - g + 15) % 30;
        // * Dividi c per 4, ottenendo quoziente j e resto k.
        int j = c / 4;
        int k = c % 4;
        // * Dividi (a+11h) per 319, ottenendo il quoziente m. Ignora il resto.
        int m = (a + 11 * h) / 319;
        // * Dividi (2e+2j-k-h+m+32) per 7, ottenendo il resto r. Ignora il quoziente.
        int r = (2 * e + 2 * j - k - h + m + 32) % 7;
        // * Dividi (h-m+r+90) per 25, ottenendo il quoziente n. Ignora il resto.
        int n = (h - m + r + 90) / 25;
        // * Dividi (h-m+r+n+19) per 32, ottenendo il resto p. Ignora il quoziente.
        int p = (h - m + r + n + 19) % 32;
        // * Pasqua è il giorno p del mese n dell'anno y.
        //System.out.println("Pasqua è il giorno " + p + " del mese " + n + " dell'anno " + y + ".");
        System.out.println(p + "/" + n + "/" + y);
    }
}
