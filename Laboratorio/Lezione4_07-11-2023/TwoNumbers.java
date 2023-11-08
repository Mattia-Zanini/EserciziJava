import java.util.Scanner;

public class TwoNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x, y;

        System.out.println("Inserisci il primo numero reale");
        x = input.nextDouble();
        System.out.println("Inserisci il secondo numero reale");
        y = input.nextDouble();

        input.close();

        double somma, prodotto, valoreMedio, valoreAssoluto;

        somma = x + y;
        prodotto = x * y;
        valoreMedio = (x + y) / 2;

        System.out.println("Somma: " + somma);
        System.out.println("Prodotto: " + prodotto);
        System.out.println("Valore Medio: " + valoreMedio);

        if (x > y)
            System.out.println("x è il valore massimo, mentre y è il valore minimo");
        else if (x < y)
            System.out.println("y è il valore massimo, mentre x è il valore minimo");
        else
            System.out.println("x e y sono uguali");

        valoreAssoluto = x - y;
        if (valoreAssoluto < 0)
            valoreAssoluto *= -1;

        System.out.println("Valore Assoluto della differenza: " + valoreAssoluto);
    }
}