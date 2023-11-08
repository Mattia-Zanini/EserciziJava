import java.util.Scanner;

public class PrintTimeInterval {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstHour, secondHour;

        System.out.println("Inserisci la prima ora, nel formato hhmm, tipo '0928'");
        firstHour = input.nextLine();
        System.out.println("Inserisci la seconda ora");
        secondHour = input.nextLine();

        input.close();

        if (firstHour.length() > 4 || secondHour.length() > 4)
            System.exit(1);

        int hour1, hour2, minute1, minute2;
        hour1 = Integer.parseInt(firstHour.substring(0, 2));
        hour2 = Integer.parseInt(secondHour.substring(0, 2));

        minute1 = Integer.parseInt(firstHour.substring(2, 4));
        minute2 = Integer.parseInt(secondHour.substring(2, 4));

        System.out.println("orario 1: " + hour1 + ":" + minute1);
        System.out.println("orario 2: " + hour2 + ":" + minute2);

        if (hour1 < 0 || hour1 > 23 || hour2 < 0 || hour2 > 23) {
            System.exit(1);
        }
        if (minute1 < 0 || minute1 > 59 || minute2 < 0 || minute2 > 59) {
            System.exit(1);
        }

        int diffHour, diffMin;

        if (hour1 >= hour2)
            diffHour = (hour2 - hour1) + 24; //es: 09:00 - 17:30 --> 9 - 17 = -8 --> -8 + 24 = 16
        else
            diffHour = hour2 - hour1;

        diffMin = Math.abs(minute1 - minute2);

        if (diffMin > 0)//es: 09:00 - 17:30 --> 16 ore e 30 minuti --> 15 ore e 30 minuti, perchè si contano i 30 minuti
            diffHour -= 1;

        System.out.println("Tempo trascorso: " + diffHour +
                " ore e " + diffMin + " minuti");
    }
}