package kata_bank_account;

// Account.java
public class Account {
    protected float balance;
    protected int numDeposits;
    protected int numWithdrawals;
    protected float annualInterestRate;
    protected float monthlyFee;

    public Account(float initialBalance, float annualInterestRate) {
        this.balance = initialBalance;
        this.annualInterestRate = annualInterestRate;
        this.numDeposits = 0;
        this.numWithdrawals = 0;
        this.monthlyFee = 0;
    }

    public void deposit(float amount) {
        balance += amount;
        numDeposits++;
    }

    public void withdraw(float amount) {
        if (amount <= balance) {
            balance -= amount;
            numWithdrawals++;
        } else {
            System.out.println("Cannot withdraw an amount greater than the available balance.");
        }
    }

    public void calculateMonthlyInterest() {
        float monthlyInterest = (balance * (annualInterestRate / 12)) / 100;
        balance += monthlyInterest;
    }

    public void monthlyStatement() {
        balance -= monthlyFee;
        calculateMonthlyInterest();
    }

    public String print() {
        return "Balance: " + balance + "\n" +
               "Deposits: " + numDeposits + "\n" +
               "Withdrawals: " + numWithdrawals + "\n" +
               "Annual Interest Rate: " + annualInterestRate + "%\n" +
               "Monthly Fee: " + monthlyFee;
    }
}
