import java.util.Scanner;

public class Stringa {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Inserisci una stringa");
        String str = console.nextLine();
        console.close();

        String[] strArray = str.split(" ");
        for (int i = 0; i < strArray.length; i++)
            System.out.println(strArray[i]);
    }
}