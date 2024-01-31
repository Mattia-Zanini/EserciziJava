import java.util.Scanner;

public class esercizio1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Inserisci una parola");
        String str = console.nextLine();

        int sum = calcola(str, 0);
        System.out.println(sum);
        console.close();
    }

    private static int calcola(String s, int p) {
        String c = new String();
        int n = 0;
        if (p < s.length()) {
            c = s.substring(p, p + 1);
            try {
                n = Integer.parseInt(c);
            } catch (NumberFormatException e) {
                return 0 + calcola(s, p + 1);
            }
            return n + calcola(s, p + 1);
        }
        return 0;
    }
}