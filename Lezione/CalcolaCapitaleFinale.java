import java.util.Scanner;

// Taso di interesse = i (da 0.00 a 1.00, cioè da 0% a 100%)
// Importo = imp
// N. anni = a
// Capitale finale con interesse samplice: capf = imp * (1 + a * i)

public class CalcolaCapitaleFinale {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        double i, imp, a, capf;
        System.out.print("Capitale o importo finale: ");
        imp = tastiera.nextDouble();
        System.out.print("Tasso di interesse (da 0.00 a 1.00): ");
        i = tastiera.nextDouble();
        System.out.print("N. anni: ");
        a = tastiera.nextDouble();
        capf = imp * (1 + a * i);
        System.out.println("Capitale finale: " + capf);
    }
}