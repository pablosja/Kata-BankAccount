package kata_bank_account;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void testCalculateMonthlyInterest() {
        Account account = new Account(10000, 6); 
        account.calculateMonthlyInterest();
        assertEquals(10050, account.balance, 0.01);
    }

    @Test
    void testDeposit() {
        Account account = new Account(10000, 6);
        account.deposit(5000);
        assertEquals(15000, account.balance, 0.01);
        assertEquals(1, account.numDeposits);
    }

    @Test
    void testMonthlyStatement() {
        Account account = new Account(10000, 6);
        account.monthlyFee = 500;
        account.monthlyStatement();
        assertEquals(10000 - 500 + 47.5, account.balance, 0.01);
    }

    @Test
    void testPrint() {
        Account account = new Account(10000, 6);
        String expectedOutput = "Balance: 10000.0\n" +
                                "Deposits: 0\n" +
                                "Withdrawals: 0\n" +
                                "Annual Interest Rate: 6.0%\n" +
                                "Monthly Fee: 0.0";
        assertEquals(expectedOutput, account.print());
    }

    @Test
    void testWithdraw() {
        Account account = new Account(10000, 6);
        account.withdraw(3000);
        assertEquals(7000, account.balance, 0.01);
        assertEquals(1, account.numWithdrawals);

        account.withdraw(8000);
        assertEquals(7000, account.balance, 0.01);
}
