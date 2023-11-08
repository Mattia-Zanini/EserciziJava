import java.util.Scanner;

public class SimpleTriangleTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String tipoLati = "", tipoAngoli = "";
        int lato1, lato2, lato3, angolo;

        System.out.println("Inserisci il primo lato");
        lato1 = input.nextInt();
        System.out.println("Inserisci il secondo lato");
        lato2 = input.nextInt();
        System.out.println("Inserisci il terzo lato");
        lato3 = input.nextInt();

        input.close();

        if ((lato1 < Math.abs(lato2 - lato3) || lato2 < Math.abs(lato1 - lato3) || lato3 < Math.abs(lato2 - lato1))
                && (lato1 > lato2 + lato3 || lato2 > lato1 + lato3 || lato3 > lato2 + lato1)) {
            System.out.println("Inserisci lati validi");
            System.exit(1);
        }

        if (lato1 == lato2 && lato2 == lato3)
            tipoLati = "Equilatero";
        else if ((lato1 == lato2) || (lato1 == lato3) || (lato2 == lato3))
            tipoLati = "Isoscele";
        else if (lato1 != lato2 && lato2 != lato3)
            tipoLati = "Scaleno";

        angolo = (lato3 * lato3) - (lato1 * lato1) - (lato2 * lato2);

        if (angolo < 0)
            tipoAngoli = "Acutangolo";
        else if (angolo == 0)
            tipoAngoli = "Rettangolo";
        else if (angolo > 0)
            tipoAngoli = "Ottusangolo";

        System.out.println("Triangolo " + tipoLati + " " + tipoAngoli);
    }
}