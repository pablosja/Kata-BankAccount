package kata_bank_account;

public class CheckingAccount extends Account {
    private float overdraft;

    public CheckingAccount(float initialBalance, float annualInterestRate) {
        super(initialBalance, annualInterestRate);
        this.overdraft = 0;
    }

    @Override
    public void withdraw(float amount) {
        if (amount <= balance) {
            super.withdraw(amount);
        } else {
            overdraft += (amount - balance);
            balance = 0;
            numWithdrawals++;
        }
    }

    @Override
    public void deposit(float amount) {
        if (overdraft > 0) {
            if (amount >= overdraft) {
                amount -= overdraft;
                overdraft = 0;
            } else {
                overdraft -= amount;
                amount = 0;
            }
        }
        super.deposit(amount);
    }

    @Override
    public String print() {
        return super.print() + "\n" +
               "Overdraft: " + overdraft;
    }
}
