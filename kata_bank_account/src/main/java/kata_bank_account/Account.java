package kata_bank_account;

public class Account {
    protected float balance;
    protected int numDeposits;
    protected int numWithdrawals;
    protected float annualInterestRate;
    protected float monthlyFee;

    public Account(float initialBalance, float annualInterestRate) {
        this.balance = initialBalance;
        this.annualInterestRate = annualInterestRate;
        this.monthlyFee = 0;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            numDeposits++;
        }
    }

    public void withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            numWithdrawals++;
        }
    }

    public void calculateMonthlyInterest() {
        float monthlyInterestRate = annualInterestRate / 12 / 100;
        float interest = balance * monthlyInterestRate;
        balance += interest;
    }

    public void monthlyStatement() {
        balance -= monthlyFee;
        calculateMonthlyInterest();
    }

    public String print() {
        return String.format("Balance: %.2f\nDeposits: %d\nWithdrawals: %d\nAnnual Interest Rate: %.2f%%\nMonthly Fee: %.2f",
                             balance, numDeposits, numWithdrawals, annualInterestRate, monthlyFee);
    }
}
