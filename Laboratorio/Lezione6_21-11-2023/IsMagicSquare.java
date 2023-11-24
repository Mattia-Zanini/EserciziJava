import java.util.Scanner;

public class IsMagicSquare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nums = new int[0];
        int numsSize = 0;
        String buffer = new String();
        while (true) {
            System.out.println("Inserisci un numero o una sequenza di numeri separati da uno spazio");
            buffer = input.nextLine();
            if (buffer.compareTo("") == 0)
                break;
            else {
                String[] numbers = buffer.split(" ");
                for (int i = 0; i < numbers.length; i++) {
                    int tmp = Integer.parseInt(numbers[i]);
                    numsSize++;
                    nums = ArrayUtilClass.resize(nums, numsSize);
                    nums[numsSize - 1] = tmp;
                }
            }
        }
        input.close();

        // se la radice è un numero intero la differenza è 0
        if (Math.sqrt(numsSize) - (int) (Math.sqrt(numsSize)) != 0)
            System.out.println("input non corretto");
        else {
            int[] numeri = new int[numsSize];
            // generazione numeri
            for (int i = 0; i < numsSize; i++)
                numeri[i] = i + 1;

            int count = 0;
            for (int i = 0; i < numsSize; i++) {
                for (int j = 0; j < numsSize; j++) {
                    if (numeri[i] == nums[j])
                        count++;
                }
            }

            if (count != numsSize) {
                System.out.println("Hai inserito dei numeri non corretti");
                System.exit(1);
            }

            int n = (int) Math.sqrt(numsSize);
            int[][] magicSquare = new int[n][n];
            int c = 0;
            // columns
            for (int i = 0; i < n; i++) {
                // row
                for (int j = 0; j < n; j++) {
                    magicSquare[i][j] = nums[c];
                    c++;
                }
            }

            // verifica somma delle righe
            int rowSum = 0;
            boolean sameRowSum = true;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    if (i == 0)
                        rowSum += magicSquare[i][j];
                    else
                        sum += magicSquare[i][j];
                }

                if (rowSum != sum && i != 0) {
                    sameRowSum = false;
                    break;
                }
            }

            if (sameRowSum == false) {
                System.out.println("L'ordine dei numeri inseriti non è corretto (row)");
                System.exit(1);
            }

            // verifica somma delle colonne
            int colSum = 0;
            boolean sameColSum = true;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    if (i == 0)
                        colSum += magicSquare[j][i];
                    else
                        sum += magicSquare[j][i];
                }

                if (colSum != sum && i != 0) {
                    sameColSum = false;
                    break;
                }
            }

            if (sameColSum == false) {
                System.out.println("L'ordine dei numeri inseriti non è corretto (col)");
                System.exit(1);
            }

            // verifica somma delle diagonali
            int sxToDx = 0; // diagonale da sinistra verso destra
            int dxToSx = 0; // diagonale da destra verso sinistra
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < n; i++) {
                    if (j == 0)
                        sxToDx += magicSquare[i][i];
                    else
                        dxToSx += magicSquare[i][i];
                }
            }

            if (sxToDx != dxToSx) {
                System.out.println("L'ordine dei numeri inseriti non è corretto (diagonal)");
                System.exit(1);
            }

            System.out.println("Complimenti i numeri che hai inserito fanno parte di un quadrato magico");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(magicSquare[i][j]);
                    System.out.print("\t");
                }
                System.out.print("\n");
            }
        }
    }
}