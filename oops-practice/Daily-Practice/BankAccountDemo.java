class BankAccount {

    private final String accountNumber;
    private final String holder;
    private double balance;

    // Static field to track total accounts created
    private static int totalAccounts = 0;

    // Constructor
    public BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + " into Account " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method with Overdraft Check
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Withdrawal of ₹" + amount +
                    " failed. Insufficient balance in Account " + accountNumber);
        } else {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + " from Account " + accountNumber);
        }
    }

    // Account Statement
    public void getStatement() {
        System.out.println("\n Account Statement ");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + holder);
        System.out.println("Current Balance: ₹" + balance);
        System.out.println(" ");
    }

    // Static Method
    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class BankAccountDemo {

    public static void main(String[] args) {

        // Create 3 Accounts
        BankAccount acc1 = new BankAccount("A101", "Aman", 10000);
        BankAccount acc2 = new BankAccount("A102", "Priya", 15000);
        BankAccount acc3 = new BankAccount("A103", "Rahul", 20000);

        // ===== Account 1 : 5 Transactions =====
        acc1.deposit(2000);
        acc1.withdraw(1500);
        acc1.deposit(3000);
        acc1.withdraw(5000);
        acc1.withdraw(1000);

        // ===== Account 2 : 5 Transactions =====
        acc2.deposit(5000);
        acc2.withdraw(2000);
        acc2.withdraw(10000);
        acc2.deposit(1500);
        acc2.withdraw(1000);

        // ===== Account 3 : 5 Transactions =====
        acc3.deposit(4000);
        acc3.withdraw(2500);
        acc3.deposit(3500);
        acc3.withdraw(30000); // Overdraft attempt
        acc3.withdraw(1000);

        // Print Statements
        acc1.getStatement();
        acc2.getStatement();
        acc3.getStatement();

        // Total Accounts Created
        System.out.println("\nTotal Accounts Created: "
                + BankAccount.getTotalAccounts());
    }
}