import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1, str2, str3;

        System.out.println("Inserisci la prima stringa");
        str1 = input.nextLine();
        System.out.println("Inserisci la seconda stringa");
        str2 = input.nextLine();
        System.out.println("Inserisci la terza stringa");
        str3 = input.nextLine();

        for (int i = str1.length() - 1; i >= 0; i--) {
            System.out.print(str1.charAt(i));
        }
        System.out.print(" ");
        for (int i = str2.length() - 1; i >= 0; i--) {
            System.out.print(str2.charAt(i));
        }
        System.out.print(" ");
        for (int i = str3.length() - 1; i >= 0; i--) {
            System.out.print(str3.charAt(i));
        }
        System.out.println();
    }
}