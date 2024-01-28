/*
 * Scrivere in Java un programma che chieda all'utente le lunghezze a,b,c 
 * dei lati di un triangolo e calcoli l'area S con la foermula di Erone.
 */

import java.util.Scanner;

public class Piastrelle {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        double wall = 250, tile = 12.5;

        int nTileCoppie = (int) ((wall - tile) / (tile * 2));
        int nTiles = nTileCoppie * 2 + 1;
        double gapRimanente = (wall - (nTiles * tile)) / 2.0;

        System.out.println("Numero di piastrelle: " + nTiles);
        System.out.println("Il gap rimanente è di: " + gapRimanente);
        input.close();
    }
}
