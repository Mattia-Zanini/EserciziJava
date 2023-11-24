import java.util.InputMismatchException;
import java.util.Scanner;

public class FactorGeneratorTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.println("Inserire un numero intero > 1");
            try {
                n = input.nextInt();
            } catch (InputMismatchException e) {
                n = 0; // un qualsiasi valore minore di 2
                input.nextLine();
            }
        } while (n < 2);
        input.close();
        
        FactorGenerator f = new FactorGenerator(n);
        System.out.println("Fattori primi del numero " + n);
        while (f.hasMoreFactors())
            System.out.println(f.nextFactor());
    }
}