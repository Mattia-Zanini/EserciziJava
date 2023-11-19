import java.util.Scanner;

public class SomeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String buffer;
        int somma = 0, sommaAssoluta = 0, prodotto = 1, numCounter = 0;

        while (true) {
            System.out.println("Inserisci un numero");
            buffer = input.nextLine();

            if (buffer.toLowerCase().compareTo("stop") == 0)
                break;

            int num = Integer.parseInt(buffer);
            somma += num;
            sommaAssoluta += Math.abs(num);
            prodotto *= num;
            numCounter++;
        }

        if (numCounter > 2) {
            int media = somma / numCounter;

            System.out.println("Somma: " + somma);
            System.out.println("Somma Assoluta: " + sommaAssoluta);
            System.out.println("Prodotto: " + prodotto);
            System.out.println("Media: " + media);
        } else {
            System.out.println("Errore, devi inserire almeno 2 numeri");
        }

        input.close();
    }
}