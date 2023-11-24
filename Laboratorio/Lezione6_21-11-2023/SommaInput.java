
/*
 * Chiedere all'utente di inserire un numero intero. Leggere due serie di numeri in
 * virgola mobile di lunghezza pari all'intero specificato. Ciacun numero della serie
 * deve essere specificato in una riga di input (= premere invio dopo ogni numero
 * inserito). Restituire in uscita la somma di ciascuna componente corrispondente e
 * la somma totale.
 */
import java.util.Scanner;

public class SommaInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = 0;
        System.out.println("Quanti elementi?");
        size = Integer.parseInt(input.nextLine());

        double[] array = new double[size];
        double[] array2 = new double[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Inserisci il " + (i + 1) + " numero del primo array");
            array[i] = Double.parseDouble(input.nextLine());
        }
        for (int i = 0; i < size; i++) {
            System.out.println("Inserisci il " + (i + 1) + " numero del secondo array");
            array2[i] = Double.parseDouble(input.nextLine());
        }
        input.close();

        double totalSum = 0.0;
        for (int i = 0; i < size; i++) {
            double sum = array[i] + array2[i];
            System.out.println("Somma dei termini [" + i + "]: " + sum);
            totalSum += sum;
        }
        System.out.println("Somma totale: " + totalSum);
    }
}