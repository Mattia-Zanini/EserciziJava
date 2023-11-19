
/*
 * Scrivere un programma che:
 * Chiede all'utente di introdurre due stringhe (una per riga), s1 e s2; ciascuna
 * stringa è costituita da tutti i caratteri presenti sulla riga, compresi eventuali
 * spazi iniziali, finali e/o intermedi
 * verifica se la seconda stringa, s2, è una sottostringa di s1, ossia se esiste una
 * coppia di numeri interi, x e y, per cui s1.substring(x, y) restituisce una stringa
 * uguale a s2 (al termine della verifica viene visualizzato un messaggio opportuno)
 * 
 * Soluzione 1: Il programma puo' usare solo i metodi length(), substring(...) ed equals(...) della classe String.
 * Soluzione 2: Il programma puo' usare solo i metodi charAt() e length() della classe String.
 * 
 * Verificare che il programma gestisca correttamente la situazione in cui s2 è la stringa vuota (che, in base alla definizione precedente, è sottostringa di qualsiasi stringa).
 */
import java.util.Scanner;

public class SubstringManipulation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1, s2;
        boolean isSubstring = false;

        System.out.print("Inserisci la prima stringa: ");
        s1 = input.nextLine();
        System.out.print("Inserisci la seconda stringa: ");
        s2 = input.nextLine();
        input.close();

        int dimS1 = s1.length();
        int dimS2 = s2.length();

        if (dimS2 > dimS1) {
            System.out.println("La seconda stringa non può essere contenuta nella" +
                    " prima in quanto è più grande di essa");
            System.exit(1);
        } else if (dimS1 == dimS2) {
            if (s1.compareTo(s2) == 0) {
                System.out.println("La seconda stringa è substringa della prima," +
                        " per la precisione sono uguali");
                System.exit(0);
            } else {
                System.out.println("La seconda stringa NON è substringa della prima");
                System.exit(0);
            }
        } else {
            for (int i = 0; i < dimS1 - dimS2; i++) {
                String diffStr = s1.substring(i, i + dimS2);
                System.out.println("Ciclo [" + i + "], Stringa di differenza: [" + diffStr + "]");
                
                if (diffStr.compareTo(s2) == 0) {
                    System.out.println("La seconda stringa è una substringa della prima");
                    isSubstring = true;
                    break;
                }
            }

            if (isSubstring == false) {
                System.out.println("La seconda stringa NON è una substringa della prima");
            }
        }
    }
}