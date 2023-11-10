import java.util.Scanner;

public class EncodeCesare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str, encodedStr = "";

        System.out.print("Inserisci una stringa: ");
        str = input.nextLine().toUpperCase(); // La stringa viene convertita in maiuscolo per uniformità

        System.out.print("Inserisci un numero tra 1 e 25: ");
        int n = input.nextInt();
        input.close();

        // Verifica se il numero inserito è valido
        if (n > 25 || n < 1) {
            System.out.println("Numero valido solo tra 1 e 25");
            System.exit(0);
        }

        // Ciclo per iterare attraverso ogni carattere della stringa
        for (int i = 0; i < str.length(); i++) {
            // Se il carattere non è uno spazio
            if (str.charAt(i) != ' ') {
                // Codifica del carattere aggiungendo il numero specificato
                String encoded = Character.toString(str.charAt(i) + n);

                // Se il risultato supera 'Z', ritorna indietro all'inizio dell'alfabeto
                if (encoded.charAt(0) > 'Z') {
                    encoded = Character.toString(encoded.charAt(0) % 26 + 52);
                }

                // Aggiunta del carattere codificato alla stringa risultante
                encodedStr += encoded;
            } else {
                // Se il carattere è uno spazio lo aggiunge senza modificarlo
                encodedStr += " ";
            }
        }
        System.out.println(encodedStr);
    }
}
