
//importazioni
import java.util.Scanner;
import java.math.*;

//intestazione classe
public class ConvertiDaLireAdEuro {
    // intestazione metodo principale
    public static void main(String[] args) {
        // dichiarazioni
        double implire, impeuro;
        Scanner in = new Scanner(System.in);

        // operazioni di input
        System.out.println("Importo in lire: ");
        implire = in.nextDouble();

        // elaborazioni
        impeuro = implire / 1936.27;

        // operazioni di input
        System.out.println("Importo in euro: " + impeuro);
    }// chiusura main
}
