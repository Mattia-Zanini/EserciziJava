import java.util.Scanner;
import java.io.*;

public class DNAProfile {
    // Il programma richiedera' due argomenti da riga di comando: il nome del file
    // che contiene i profili degli indagati e il nome del file che contiene la
    // sequenza di DNA da identificare.

    // La prima riga del file dei profili conterra' la parola "name" e poi le
    // sequenze delle STR considerate. Le righe successive conterranno il nome
    // dell'individuo seguito dalla numerosita' delle STR rilevate nel suo DNA.
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Numero di argomenti insufficiente, servono almeno 2 argomenti");
            System.exit(1);
        }
        String inputFile = args[0];
        String indagati = args[1];

        String DNAString = readFromFile(inputFile);
        String[] Info = getDNAToSearch(indagati);

        int[] counts = new int[3];
        for (int i = 0; i < counts.length; i++) {
            int streak = 0;
            for (int j = 0; j < DNAString.length() - 3; j++) {
                String sub = DNAString.substring(j, j + 4);
                if (sub.compareTo(Info[i]) == 0) {
                    streak++;
                    j += 3;
                } else {
                    if (streak > counts[i])
                        counts[i] = streak;
                    streak = 0;
                }
            }
            if (streak > counts[i])
                counts[i] = streak;
            System.out.printf("%s: %d\n", Info[i], counts[i]);
        }
        String[] suspectInfo1 = getSuspectDNA(indagati, 1);
        String[] suspectInfo2 = getSuspectDNA(indagati, 2);
        String[] suspectInfo3 = getSuspectDNA(indagati, 3);
        String colpevole = "Nessuno";

        if (Integer.parseInt(suspectInfo1[1]) == counts[0] &&
                Integer.parseInt(suspectInfo1[2]) == counts[1] &&
                Integer.parseInt(suspectInfo1[3]) == counts[2])
            colpevole = suspectInfo1[0];
        else if (Integer.parseInt(suspectInfo2[1]) == counts[0] &&
                Integer.parseInt(suspectInfo2[2]) == counts[1] &&
                Integer.parseInt(suspectInfo2[3]) == counts[2])
            colpevole = suspectInfo2[0];
        else if (Integer.parseInt(suspectInfo3[1]) == counts[0] &&
                Integer.parseInt(suspectInfo3[2]) == counts[1] &&
                Integer.parseInt(suspectInfo3[3]) == counts[2])
            colpevole = suspectInfo3[0];

        System.out.println("Il colpevole e': " + colpevole);
    }

    public static String readFromFile(String input) {
        String result = new String();
        try (FileReader r = new FileReader(input); Scanner scan = new Scanner(r).useDelimiter("\n")) {
            while (true) {
                result += scan.next();
                if (!scan.hasNext())
                    break;
                result += " ";
            }
        } catch (FileNotFoundException e) {
            System.out.println("Errore file non trovato");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Errore file non trovato");
            System.exit(1);
        }
        return result;
    }

    public static String[] getDNAToSearch(String input) {
        String inpText = readFromFile(input);
        String[] result = inpText.split(" ");
        // prende solo i 3 casi possibili
        result = new String[] { result[1], result[2], result[3] };
        return result;
    }

    public static String[] getSuspectDNA(String input, int index) {
        String inpText = readFromFile(input);
        String[] result = inpText.split(" ");
        // prende solo i 3 casi possibili
        int suspectIndex = index * 4;
        result = new String[] {
                result[suspectIndex],
                result[suspectIndex + 1],
                result[suspectIndex + 2],
                result[suspectIndex + 3]
        };
        return result;
    }

    public static void stampaArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("[%d]: %s\n", i, array[i]);
        }
    }
}