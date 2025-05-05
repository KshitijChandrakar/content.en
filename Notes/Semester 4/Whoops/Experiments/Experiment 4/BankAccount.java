// Create a BankAccount1 class with a private variable balance to store the account balance.
// Implement a public method deposit(double amount) to add funds, a protected method
// withdraw(double amount) to deduct funds, and a default-access method checkBalance() to
// display the current balance. Create an object of the class and demonstrate which methods
// and variables can be accessed both inside and outside the class
class BankAccount1 {
    private double balance;
    public BankAccount1(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    protected void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount!");
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class BankAccount {
    public static void main(String[] args) {

      BankAccount1 myAccount = new BankAccount1(1000);

      myAccount.deposit(500);

      myAccount.checkBalance();

      myAccount.withdraw(300);

      myAccount.checkBalance();

      // System.out.println(myAccount.balance); // No

    }
}
