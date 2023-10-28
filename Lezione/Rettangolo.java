import java.util.Scanner;
import java.math.*;

public class Rettangolo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double base, altezza, diagonale, perimetro, area;
        System.out.print("Inserisci la grandezza della base: ");
        base = input.nextDouble();
        System.out.print("Inserisci la grandezza l'altezza: ");
        altezza = input.nextDouble();

        diagonale = Math.sqrt(base * base + altezza * altezza);
        perimetro = (base + altezza) * 2;
        area = base * altezza;

        System.out.println("Perimetro: " + perimetro);
        System.out.println("Diagonale: " + diagonale);
        System.out.println("Area: " + area);
    }
}