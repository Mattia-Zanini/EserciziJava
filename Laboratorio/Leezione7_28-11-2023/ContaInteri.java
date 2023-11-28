import java.util.*;

public class ContaInteri {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int count = 0;

        while (true) {
            try {
                // Tentativo di leggere un intero dallo standard input
                console.nextInt();
                count++;
            } catch (InputMismatchException e) {// Gestione dell'eccezione se il dato inserito non è un intero
                System.out.println("Il dato inserito non è un intero. Riprova.");
                // Pulizia del flusso di input da dati non validi
                console.next();
            }

            // Se viene inserita una riga vuota, termina il ciclo
            if (!console.hasNext()) {
                break;
            }
        }
        console.close();
        System.out.println("\nInteri inseriti: " + count);
    }
}