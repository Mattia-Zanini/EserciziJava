import java.util.Scanner;

public class NumberLister {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.println("Inserisci un numero intero non negativo");
        n = input.nextInt();
        input.close();

        if (n < 0) {
            System.out.println("Ingresso non ammesso");
            System.exit(1);
        }

        for (int i = 0; i < 200; i++) {
            System.out.print(n + i + " ");
        }
        System.out.println();
    }
}