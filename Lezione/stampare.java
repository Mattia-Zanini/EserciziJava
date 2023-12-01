import java.util.Scanner;

public class stampare {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Inserisci la parola");
        String word = console.next();
        stampareOmologhi(word);
        console.close();
    }

    public static void stampareOmologhi(String word) {
        if (word.compareTo("") == 0)
            System.out.print(" \n");
        else {
            System.out.println(word.charAt(0) + "\t" + word.charAt(word.length() - 1));
            stampareOmologhi(word.substring(1, word.length() - 1));
        }
    }
}