// Source code is decompiled from a .class file using FernFlower decompiler.
public class BankAccount {
   private double balance;

   public BankAccount(double var1) {
      this.balance = var1;
   }

   public BankAccount() {
      this.balance = 0.0;
   }

   public double getBalance() {
      return this.balance;
   }

   public void withdraw(double var1) {
      this.balance -= var1;
   }

   public void deposit(double var1) {
      this.balance += var1;
   }
}
