import java.util.Scanner;

public class Tris {
    public static void main(String[] args) {
        final int N_COLUMNS = 3;
        char[][] grid = new char[N_COLUMNS][N_COLUMNS];
        // inizializzo la griglia
        for (int i = 0; i < N_COLUMNS; i++) {
            for (int j = 0; j < N_COLUMNS; j++) {
                grid[i][j] = '.';
            }
        }
        System.out.print(fieldToString(grid, N_COLUMNS));

        Scanner input = new Scanner(System.in);
        int numPlayer = 0, result = 0;
        boolean gameEnd = false, turn = false;
        // turn = false --> player1, turn = true --> player2
        do {
            char action;
            if (!turn) {
                numPlayer = 1;
                action = 'X';// = 88(int)
            } else {
                numPlayer = 2;
                action = 'O';// = 79(int)
            }

            System.out.println("Giocatore " + numPlayer + " inserisci la tua mossa 'x,y'");
            String playerInput = input.nextLine();
            String[] moves = playerInput.split(",");
            int coordX = Integer.parseInt(moves[0]);
            int coordY = Integer.parseInt(moves[1]);

            if (coordX < 0 || coordX >= N_COLUMNS || coordY < 0 || coordY >= N_COLUMNS)
                System.out.println("Input non valido");
            else {
                if (grid[coordX][coordY] != '.')
                    System.out.println("Casella non disponibile");
                else {
                    grid[coordX][coordY] = action;
                    System.out.print(fieldToString(grid, N_COLUMNS));
                    result = checkVictory(grid, N_COLUMNS);

                    if (result != 0)
                        gameEnd = true;
                    else
                        turn = !turn;
                }
            }
        } while (!gameEnd);
        input.close();

        System.out.println("Ha vinto il giocatore " + result);
    }

    public static String fieldToString(char[][] grid, int nCol) {
        String field = new String();
        for (int i = 0; i < nCol; i++) {
            field += "|";
            for (int j = 0; j < nCol; j++) {
                field += " " + grid[i][j];
            }
            field += " |\n";
        }
        return field;
    }

    public static int checkVictory(char[][] grid, int nCol) {
        // check row
        for (int i = 0; i < nCol; i++) {
            int rowSum = 0;
            for (int j = 0; j < nCol; j++)
                rowSum += grid[i][j];

            if (rowSum == 88 * 3) // vince player1
                return 1;
            else if (rowSum == 79 * 3) // vince player2
                return 2;
        }

        // check col
        for (int i = 0; i < nCol; i++) {
            int colSum = 0;
            for (int j = 0; j < nCol; j++)
                colSum += grid[j][i];

            if (colSum == 88 * 3) // vince player1
                return 1;
            else if (colSum == 79 * 3) // vince player2
                return 2;
        }

        // check col
        for (int i = 0; i < 2; i++) {
            int diagonalSum = 0;

            if (i == 0)
                for (int j = 0; j < nCol; j++)
                    diagonalSum += grid[j][j];
            else
                for (int j = 0; j < nCol; j++)
                    diagonalSum += grid[nCol - 1 - j][j];

            if (diagonalSum == 88 * 3) // vince player1
                return 1;
            else if (diagonalSum == 79 * 3) // vince player2
                return 2;
        }
        return 0;
    }
}