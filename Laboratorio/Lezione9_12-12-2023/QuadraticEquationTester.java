import java.util.Scanner;

public class QuadraticEquationTester {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Inserisci il primo termine (a)");
        double a = Double.parseDouble(console.next());
        System.out.println("Inserisci il secondo termine (b)");
        double b = Double.parseDouble(console.next());
        System.out.println("Inserisci il terzo termine (c)");
        double c = Double.parseDouble(console.next());

        QuadraticEquation q = new QuadraticEquation(a, b, c);
        if (!q.hasSolutions()) {
            System.out.println("L'equazione non ha soluzioni");
            System.out.println("Il discriminante vale: " + QuadraticEquation.getDiscriminante(a, b, c));
            System.exit(0);
        }
        System.out.println("La soluzione x1 e': " + q.getSolution1());
        System.out.println("La soluzione x2 e': " + q.getSolution2());
        System.out.println("Il discriminante vale: " + QuadraticEquation.getDiscriminante(a, b, c));
    }
}