import reports.TransactionReport;
import transaction.Account;

public class TransactionApp {
    public static void main(String[] args) {
        Account account = new Account(123456789L, 5000.00);
        account.deposit(1500.00);
        account.withdraw(750.00);

        TransactionReport report = new TransactionReport();
        report.generate(account);
    }
}
