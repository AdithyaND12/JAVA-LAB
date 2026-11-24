package reports;

import transaction.Account;

public class TransactionReport {
    public void generate(Account account) {
        System.out.println("Transaction Report");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.printf("Current Balance: Rs. %.2f%n", account.getBalance());
    }
}
