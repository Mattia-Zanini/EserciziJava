import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");
        long n = Integer.parseInt(console.nextLine());
        console.close();

        System.out.println("Fibonacci del numero inserito: " + fibonacci(n));
    }

    public static long fibonacci(long n) {
        if (n < 0)
            throw new IllegalArgumentException();
        if (n < 2)
            return n;

        return fibonacci(n - 2) + fibonacci(n - 1);
    }
}