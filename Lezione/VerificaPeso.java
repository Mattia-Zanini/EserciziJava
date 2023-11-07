/*
 * Realizzare in Java un programma che chieda all'utente la
 * statura in cm, il peso in kg, e stabliisca se vi è
 */

import java.util.Scanner;

public class VerificaPeso {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double statura, peso, pesoIdeale;
        System.out.println("Inserisci la tua statura in cm");
        statura = input.nextDouble();
        System.out.println("Inserisci il tuo peso in kg");
        peso = input.nextDouble();
        pesoIdeale = statura - 105;

        if (peso > pesoIdeale)
            System.out.println("Sovrappeso");
        if (peso == pesoIdeale)
            System.out.println("Normopeso");
        if (peso < pesoIdeale)
            System.out.println("Sottopeso");
    }
}