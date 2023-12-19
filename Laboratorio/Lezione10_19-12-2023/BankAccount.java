import java.lang.Comparable;

public class BankAccount implements Comparable
{
    public BankAccount()
    {
        balance = 0;
    }

    public BankAccount(double initialBalance)
    {   
        deposit(initialBalance);
    }

    public void deposit(double amount)
    {
        if (amount <= 0)
            throw new IllegalArgumentException();
        balance = balance + amount;
    }

    public void withdraw(double amount)
    {
        if (amount > balance || amount <= 0)
            throw new IllegalArgumentException();
        balance = balance - amount;
    }

    public void transfer(double amount, BankAccount other)
    { 
        withdraw(amount);
        other.deposit(amount);
    }


    // ------- metodi di accesso --------

    public double getBalance()
    {   
        return balance;
    }
    
    public int compareTo(Object other) {
    	BankAccount o = (BankAccount)other;
    	if(this.getBalance() > o.getBalance()) return 1;
    	else if(this.getBalance() < o.getBalance()) return -1;
    	else return 0;
    }


    // ------ metodi di Object da sovrascrivere ---------
    // ......... toString e equals ......................



    // -------- campi di esemplare ---------

    private double balance;
}

