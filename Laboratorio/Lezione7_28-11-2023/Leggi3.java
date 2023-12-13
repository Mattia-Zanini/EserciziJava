import java.util.*;
import java.io.*;

public class Leggi3 {
    public static void main(String[] args) {
        String fileName = "input.txt";
        try (FileReader r = new FileReader(fileName); Scanner scan = new Scanner(r).useDelimiter("[,?\\s]+")) {
            // Si usa lo scanner con i suoi metodi hasNext, next, nextInt, nextDouble,
            // nextLine a seconda delle esigenze
            while (true) {
                String line = scan.next();
                System.out.println(line);
                if (!scan.hasNext())
                    break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Errore file non trovato");
        } catch (IOException e) {
            System.out.println("Errore nell'apertura del file");
        }
    }
}