import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");
        int num = Integer.parseInt(console.nextLine());
        console.close();

        System.out.printf("Fattoriale del numero che hai inserito: %d\n", factorial(num));
    }

    public static long factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }
}
