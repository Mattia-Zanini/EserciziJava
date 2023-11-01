/*
 * Creare due conti bancari (account1 e account2). Depositare in account1 1000 euro.
 * Depositare in account2 100 euro. Stampare a video il valore del saldo di
 * ciascun conto. Prelevare da account1 400 euro e depositare la stessa quantita' 
 * in account2. Stampare a video il valore del saldo di ciascun conto. Abbiamo 
 * simulato un bonifico dal primo conto al secondo!
 * 
 * Costruttore:
 * BankAccount()
 * 
 * Metodi pubblici non statici:
 * - void deposit(double)
 * - double getBalance()
 * - void withdraw(double)
 */

public class Bonifico {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        account1.deposit(1000.0);
        account2.deposit(100.0);

        System.out.println("Saldo di account 1: " + account1.getBalance());
        System.out.println("Saldo di account 2: " + account2.getBalance());

        double bonifico = 400.0;

        account1.withdraw(bonifico);
        account2.deposit(bonifico);

        System.out.println("Bonifico effetuato con successo");

        System.out.println("Saldo di account 1: " + account1.getBalance());
        System.out.println("Saldo di account 2: " + account2.getBalance());
    }
}