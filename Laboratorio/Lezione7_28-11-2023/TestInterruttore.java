import java.util.Scanner;

public class TestInterruttore {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Interruttore int1 = new Interruttore();
        Interruttore int2 = new Interruttore();
        int action = 0;

        do {
            System.out.println("Interruttore 1: " + int1.printStatus());
            System.out.println("Interruttore 1: " + int2.printStatus());
            System.out.println("Scegli l'interruttore 1 o 2 (0 per uscire)");
            action = Integer.parseInt(console.nextLine());
            if (action == 1)
                int1.changeStatus();
            else if (action == 2)
                int2.changeStatus();
        } while (action != 0);
        console.close();
    }
}

class Interruttore {
    private boolean status;

    // Costruttore: inizializza l'interruttore in stato "down"
    // Assumiamo "down" corrisponda a false e "up" a true
    public Interruttore() {
        status = false;
    }

    // Metodo di accesso della variabile di esemplare interruttore
    public boolean getStatusInterruttore() {
        return status;
    }

    // Metodo di accesso alla variabile statica lampadina
    public boolean isBulbOn() {
        return true & status;
    }

    // Modificatore: cambia lo stato dell'interruttore
    // (e della lampadina!)
    public void changeStatus() {
        status = !status;
        if (status)
            System.out.println("Lampadina accessa");
        else
            System.out.println("Lampadina spenta");
    }

    // Stampa lo stato dell'interruttore: up/down a seconda
    // che status sia true o false
    public String printStatus() {
        if (status)
            return "up";
        return "down";
    }
}