import java.util.Scanner;

public class ReverseDNA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dna, replacedDna = new String();

        System.out.println("Inserisci un carattere (sono validi A,C,G,T):");
        dna = input.nextLine().toUpperCase();

        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) != 'A' && dna.charAt(i) != 'C' &&
                    dna.charAt(i) != 'G' && dna.charAt(i) != 'T') {
                System.out.println("Carattere non valido: " + dna.charAt(i));
                System.exit(1);
            } else {
                switch (dna.charAt(i)) {
                    case 'A':
                        replacedDna += 'T';
                        break;
                    case 'T':
                        replacedDna += 'A';
                        break;
                    case 'C':
                        replacedDna += 'G';
                        break;
                    case 'G':
                        replacedDna += 'C';
                        break;
                }
            }
        }

        for (int i = replacedDna.length() - 1; i >= 0; i--) {
            System.out.print(replacedDna.charAt(i));
        }
        System.out.println();
    }
}