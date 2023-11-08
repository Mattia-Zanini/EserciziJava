import java.util.Scanner;

public class IsLeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double year;
        System.out.println("Inserisci un anno intero positivo");
        year = input.nextInt();

        input.close();

        if (year < 0)
            System.exit(1);

        double resto4 = year / 4;
        double resto100 = year / 100;
        double resto400 = year / 400;

        double diffResto4 = resto4 - (int) resto4;
        double diffResto100 = resto100 - (int) resto100;
        double diffResto400 = resto400 - (int) resto400;

        if (diffResto4 != 0.0 && diffResto100 != 0.0 && diffResto400 != 0.0)
            System.out.println("L'anno: " + year + " NON è bisestile");
        else {
            if (diffResto4 == 0.0 || diffResto400 == 0.0) {
                if (diffResto100 != 0.0)
                    System.out.println("L'anno: " + year + " è bisestile");
                else
                    System.out.println("L'anno: " + year + " NON è bisestile");
            }
        }
    }
}