package transaction;

public class Account {
    private final long accountNumber;
    private double balance;

    public Account(long accountNumber, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        balance -= amount;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
