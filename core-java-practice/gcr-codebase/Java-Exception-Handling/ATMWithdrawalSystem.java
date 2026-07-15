class InsufficientBalanceException extends Exception {
    private final double balance;
    private final double requestedAmount;

    public InsufficientBalanceException(double balance, double requestedAmount) {
        super("Insufficient Balance! Available Balance: ₹" + balance +
              ", Requested Amount: ₹" + requestedAmount);
        this.balance = balance;
        this.requestedAmount = requestedAmount;
    }

    public double getBalance() {
        return balance;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }
}

class ATM {
    private double balance = 5000;

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }

        balance -= amount;
        System.out.println("Withdrawal Successful!");
        System.out.println("Remaining Balance: ₹" + balance);
    }
}

public class ATMWithdrawalSystem {
    public static void main(String[] args) {
        ATM atm = new ATM();

        try {
            atm.withdraw(8000); // Withdrawal request
        } catch (InsufficientBalanceException e) {
            System.out.println("Transaction Failed!");
            System.out.println(e.getMessage());
        }
    }
}