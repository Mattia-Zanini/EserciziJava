import java.util.Scanner;
import java.time.Month;

public class MonthFromNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci il numero del mese");
        int monthNumber = input.nextInt();

        String monthString = Month.of(monthNumber).toString();
        String capitalLetter = monthString.substring(0, 1);
        monthString = capitalLetter + monthString.substring(1).toLowerCase();
        System.out.println(monthString);
    }
}
