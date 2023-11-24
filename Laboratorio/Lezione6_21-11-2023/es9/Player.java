import java.util.Random;

/*
 * In particolare, la classe Player dovra' tener conto del nome del giocatore,
 * dei tre lanci di dado (facciamo che siano sempre tre) e del punteggio
 * (numero di tiri vincenti).
 */
public class Player {
    private Random rnd;
    private String name;
    private int score;
    private int[] lanci;
    private final int N_LANCI = 3;

    // costruttore: il punteggio iniziale è 0 così come i valori
    // dei tiri dei tre dadi
    public Player(String aName) {
        this.name = aName;
        this.score = 0;
        this.rnd = new Random();
        this.lanci = new int[N_LANCI];
    }

    // metodi di accesso
    public String getName() {
        return name;
    }

    public String getScore() {
        return Integer.toString(score);
    }

    // simula un turno di lancio di dadi attribuendo a ciascun
    // lancio un valore casuale tra 1 e 6
    //
    // Il metodo turno() della classe Player fa uso della classe java.util.Random
    // che rende disponibili metodi per generare numeri pseudo-casuali, ovvero quasi
    // casuali. Consultare l'interfaccia pubblica della classe Random, in
    // particolare il metodo int nextInt(int n).
    public void turno() {
        for (int i = 0; i < N_LANCI; i++)
            lanci[i] = rnd.nextInt(7);
    }

    // restituisce un riferimento a un nuovo array di interi in
    // cui i valori ottenuti nei tre lanci sono ordinati
    public int[] sortDice() {
        int n = N_LANCI;
        for (int i = 1; i < n; ++i) {
            int key = lanci[i];
            int j = i - 1;

            /*
             * Move elements of lanci[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            while (j >= 0 && lanci[j] > key) {
                lanci[j + 1] = lanci[j];
                j = j - 1;
            }
            lanci[j + 1] = key;
        }

        return lanci;
    }

    // aggiorna il punteggio incrementandolo di una unita'
    public void addPoint() {
        score++;
    }

    // resetta il punteggio
    public void resetScore() {
        score = 0;
    }

    // restituisce una stringa con il nome del giocatore e
    // i valori dei lanci dei dadi
    public String toString() {
        String tmp = new String();
        for (int i = 0; i < N_LANCI; i++) {
            tmp += Integer.toString(lanci[i]) + " ";
        }
        return tmp + name;
    }
}