public class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;
    private String password;

    public Account(String accountNumber, String ownerName, String password) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.password = password;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
