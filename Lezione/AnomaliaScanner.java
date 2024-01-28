/*
 * Questa è un anomalia di nextInt, perchè usa il carattere \n come terminatore della
 * lettura di input dal buffer, però lascia il carattere \n nel buffer e quando viene
 * chiamata input.nextLine() che a sua volta volta il carattere \n come terminatore
 * interromperà subito la lettura dall'input e ritornerà una stringa vuota
 */

import java.util.Scanner;

public class AnomaliaScanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s;
        int n;

        System.out.println("Inserisci un numero intero");
        n = input.nextInt();
        // n = Integer.parseInt(input.nextLine()); //Soluzione al problema
        System.out.println("Inserisci una stringa");
        s = input.nextLine();

        System.out.println("numero inserito: " + n);
        System.out.println("stringa inserita: " + s);
        input.close();
    }
}