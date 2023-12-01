import java.util.*;
import java.io.*;

public class CapsCopier {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Inserisci il nome del file da modificare: ");
        String inputFile = console.next();
        System.out.print("Inserisci il nome del file in cui verranno scritte le modifiche: ");
        String outputFile = console.next();
        console.close();

        try (FileReader r = new FileReader(inputFile); Scanner scanR = new Scanner(r).useDelimiter("[\n'\\s]+")) {
            try (PrintWriter w = new PrintWriter(outputFile)) {
                String formattedText = new String();
                while (true) {
                    String token = scanR.next();
                    // System.out.println(token);
                    formattedText += token.substring(0, 1).toUpperCase() + token.substring(1).toLowerCase() + " ";

                    if (!scanR.hasNext())
                        break;
                }
                // System.out.println(formattedText);
                w.print(formattedText);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Errore file non trovato");
        } catch (IOException e) {
            System.out.println("Errore nell'apertura del file");
        }
    }
}