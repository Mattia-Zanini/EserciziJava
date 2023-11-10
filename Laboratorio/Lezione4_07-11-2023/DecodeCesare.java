import java.util.Scanner;

public class DecodeCesare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str, decodedStr = "";

        System.out.print("Inserisci la stringa cifrata: ");
        str = input.nextLine().toUpperCase(); // La stringa viene convertita in maiuscolo per uniformità

        System.out.print("Inserisci un numero tra 1 e 25: ");
        int n = input.nextInt();
        input.close();

        // Verifica se il numero inserito è valido
        if (n > 25 || n < 1) {
            System.out.println("Numero valido solo tra 1 e 25");
            System.exit(0);
        }

        for (int i = 0; i < str.length(); i++) {
            // Se il carattere non è uno spazio
            if (str.charAt(i) != ' ') {
                String decoded = Character.toString(str.charAt(i) - n);

                if (decoded.charAt(0) < 'A') {
                    decoded = Character.toString(decoded.charAt(0) % 26 + 78);
                }

                // Aggiunta del carattere codificato alla stringa risultante
                decodedStr += decoded;
            } else {
                // Se il carattere è uno spazio lo aggiunge senza modificarlo
                decodedStr += " ";
            }
        }
        System.out.println(decodedStr);
    }
}