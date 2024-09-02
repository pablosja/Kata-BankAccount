package kata_bank_account;

public class SavingsAccount extends Account {
    boolean accountActive;

    public SavingsAccount(float initialBalance, float annualInterestRate) {
        super(initialBalance, annualInterestRate);
        this.accountActive = initialBalance >= 10000;
    }

    @Override
    public void deposit(float amount) {
        if (accountActive) {
            super.deposit(amount);
        }
    }

    @Override
    public void withdraw(float amount) {
        if (accountActive) {
            super.withdraw(amount);
        }
    }

    @Override
    public void monthlyStatement() {
        if (numWithdrawals > 4) {
            monthlyFee += (numWithdrawals - 4) * 1000;
        }
        super.monthlyStatement();
        accountActive = balance >= 10000;
    }

    @Override
    public String print() {
        return super.print() + "\n" +
               "Account Active: " + (accountActive ? "Yes" : "No");
    }
}
