import java.util.Scanner;

public class Trapezio {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double baseMinore, baseMaggiore, altezza, area;
        System.out.print("Inserisci la grandezza della base minore: ");
        baseMinore = input.nextDouble();
        System.out.print("Inserisci la grandezza della base maggiore: ");
        baseMaggiore = input.nextDouble();
        System.out.print("Inserisci la grandezza l'altezza: ");
        altezza = input.nextDouble();

        area = (baseMinore + baseMaggiore) * altezza / 2;

        System.out.println("Area: " + area);
        input.close();
    }
}