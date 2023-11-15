import java.util.Scanner;

public class NewLineNumberLister {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int MAX_COLUMN_WIDTH = 3;
        int n;

        System.out.println("Inserisci un numero intero");
        n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            String numberStr = String.valueOf(i);
            String tmp = "";
            for (int j = 0; j < (MAX_COLUMN_WIDTH - numberStr.length()); j++) {
                tmp += " ";
            }
            System.out.print(" " + tmp + numberStr);

            if (i % 10 == 0)
                System.out.print("\n");
        }
        System.out.println();
    }
}