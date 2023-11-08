import java.util.Scanner;

public class SortThreeStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstStr, secondStr, thirdStr, maxStr, minStr, medStr = "";

        System.out.print("Inserisci la prima stringa: ");
        firstStr = input.nextLine();
        System.out.print("Inserisci la seconda stringa: ");
        secondStr = input.nextLine();
        System.out.print("Inserisci la terza stringa: ");
        thirdStr = input.nextLine();

        input.close();

        if (firstStr.compareToIgnoreCase(secondStr) > 0) {
            maxStr = firstStr;
            minStr = secondStr;
        } else {
            maxStr = secondStr;
            minStr = firstStr;
        }
        if (minStr.compareToIgnoreCase(thirdStr) > 0)
            minStr = thirdStr;
        if (maxStr.compareToIgnoreCase(thirdStr) < 0)
            maxStr = thirdStr;

        if (maxStr != thirdStr && minStr != thirdStr)
            medStr = thirdStr;
        if (maxStr != firstStr && minStr != firstStr)
            medStr = firstStr;
        if (maxStr != secondStr && minStr != secondStr)
            medStr = secondStr;

        System.out.println("Stampa delle stringhe in ordine alfabetico");
        System.out.println(minStr);
        System.out.println(medStr);
        System.out.println(maxStr);
    }
}