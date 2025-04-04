public class Main {
    public static void main(String[] args) {
        Bank account = new Account(1000.0);
        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(1500.0);
    }
}
