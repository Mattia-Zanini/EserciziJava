import java.util.Scanner;

public class Risiko {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String p1Name = new String();
        String p2Name = new String();

        System.out.println("Giocatore 1 inserisci il tuo nome");
        p1Name = input.nextLine();
        System.out.println("Giocatore 2 inserisci il tuo nome");
        p2Name = input.nextLine();
        input.close();

        Player p1 = new Player(p1Name);
        Player p2 = new Player(p2Name);
        p1.turno();
        int[] p1Lanci = p1.sortDice();

        p2.turno();
        int[] p2Lanci = p2.sortDice();

        for (int i = 0; i < p1Lanci.length; i++) {
            if (p1Lanci[i] > p2Lanci[i])
                p1.addPoint();
            else if (p1Lanci[i] < p2Lanci[i])
                p2.addPoint();
        }

        int p1Score = Integer.parseInt(p1.getScore());
        int p2Score = Integer.parseInt(p2.getScore());

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        if (p1Score > p2Score)
            System.out.println("Ha vinto il giocatore 1");
        else if (p2Score > p1Score)
            System.out.println("Ha vinto il giocatore 2");
        else
            System.out.println("Pareggio");
    }
}