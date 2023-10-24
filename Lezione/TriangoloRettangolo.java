import java.util.Scanner;
import java.math.*;

public class TriangoloRettangolo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double cateto1, cateto2, ipotenusa;
        System.out.print("Primo cateto: ");
        cateto1 = input.nextDouble();
        System.out.print("Secondo cateto: ");
        cateto2 = input.nextDouble();

        if (cateto1 >= 0 && cateto2 >= 0) {
            ipotenusa = Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
            System.out.println("Ipotenusa: " + ipotenusa);
        } else if (cateto1 < 0 && cateto2 >= 0) {
            System.out.println("Dati in input errati");
            System.out.println("La lunghezza del cateto1 deve essere maggiore di 0");
        } else if (cateto1 >= 0 && cateto2 < 0) {
            System.out.println("Dati in input errati");
            System.out.println("La lunghezza del cateto2 deve essere maggiore di 0");
        } else {
            System.out.println("Dati in input errati");
            System.out.println("La lunghezza di entrambi i cateti deve essere maggiore di 0");
        }
    
    }
}
