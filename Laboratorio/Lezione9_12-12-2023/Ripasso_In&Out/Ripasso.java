import java.util.Scanner;
import java.io.*;

public class Ripasso {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Inserisci il nome di un file di input");
        String inputFile = console.nextLine();
        System.out.println("Inserisci il nome di un file di output");
        String outputFile = console.nextLine();
        console.close();

        // Lettura del file e salvataggio del contenuto in una stringa
        String inputText = new String();
        try (FileReader r = new FileReader(inputFile); Scanner scanR = new Scanner(r).useDelimiter("\n")) {
            while (true) {
                inputText += scanR.next();
                if (!scanR.hasNext())
                    break;
                inputText += "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("Errore file non trovato");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Errore nell'apertura del file");
            System.exit(1);
        }

        // System.out.println(inputText);
        // Scrittua al rovescio del contenuto del file in un file di output
        try (PrintWriter w = new PrintWriter(outputFile)) {
            w.print(Ripasso.reverseString(inputText));
        } catch (FileNotFoundException e) {
            System.out.println("Errore file non trovato");
            System.exit(1);
        }
    }

    public static String reverseString(String str) {
        String[] lines = str.split("\n");
        String result = new String();
        for (int i = lines.length - 1; i >= 0; i--)
            result += lines[i] + "\n";
        return result;
    }
}