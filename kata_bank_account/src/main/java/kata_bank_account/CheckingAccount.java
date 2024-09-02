package kata_bank_account;

public class CheckingAccount extends Account {
    protected float overdraft;

    public CheckingAccount(float initialBalance, float annualInterestRate) {
        super(initialBalance, annualInterestRate);
        this.overdraft = 0;  // Initialize overdraft
    }

    @Override
    public void deposit(float amount) {
        if (amount > 0) {
            if (overdraft > 0) {
                if (amount >= overdraft) {
                    balance += (amount - overdraft);  // Apply remaining amount to balance
                    overdraft = 0;
                } else {
                    overdraft -= amount;  // Reduce overdraft
                }
            } else {
                balance += amount;  // Simply add to balance if no overdraft
            }
            numDeposits++;
        }
}

    @Override
    public void withdraw(float amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                overdraft += (amount - balance);
                balance = 0;
            }
        }
    }
}
