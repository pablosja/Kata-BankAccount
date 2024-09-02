package kata_bank_account;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingAccountTest {

    @Test
    void testDeposit() {
        CheckingAccount account = new CheckingAccount(1000, 5);
        account.deposit(500);
        assertEquals(1500, account.balance, 0.01);
        assertEquals(1, account.numDeposits);
        assertEquals(0, account.overdraft, 0.01);

        account = new CheckingAccount(0, 5);
        account.overdraft = 500;
        account.deposit(600);
        assertEquals(100, account.balance, 0.01);
        assertEquals(1, account.numDeposits);
        assertEquals(0, account.overdraft, 0.01);
    }

    @Test
    void testWithdraw() {
        CheckingAccount account = new CheckingAccount(1000, 5);
        account.withdraw(400);
        assertEquals(600, account.balance, 0.01);
        assertEquals(0, account.numWithdrawals);
        assertEquals(0, account.overdraft, 0.01);

        account = new CheckingAccount(500, 5);
        account.withdraw(800);
        assertEquals(0, account.balance, 0.01);
        assertEquals(300, account.overdraft, 0.01);
        assertEquals(0, account.numWithdrawals);
    }
}
