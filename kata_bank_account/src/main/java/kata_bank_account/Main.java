package kata_bank_account;

public class Main {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(15000, 3);
        savingsAccount.deposit(5000);
        savingsAccount.withdraw(2000);
        savingsAccount.monthlyStatement();
        System.out.println(savingsAccount.print());

        CheckingAccount checkingAccount = new CheckingAccount(10000, 2);
        checkingAccount.withdraw(12000);
        checkingAccount.deposit(5000);
        checkingAccount.monthlyStatement();
        System.out.println(checkingAccount.print());
    }
}
