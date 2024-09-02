package kata_bank_account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
@Test
void testDeposit() {
    SavingsAccount activeAccount = new SavingsAccount(15000, 3);
    activeAccount.deposit(500); 
    assertEquals(15500, activeAccount.balance, 0.01);
    assertEquals(1, activeAccount.numDeposits);

    SavingsAccount inactiveAccount = new SavingsAccount(9000, 3);
    inactiveAccount.deposit(500);
    assertEquals(9000, inactiveAccount.balance, 0.01);
    assertEquals(0, inactiveAccount.numDeposits);
}


@Test
void testMonthlyStatement() {
    SavingsAccount account = new SavingsAccount(15000, 3);
    account.numWithdrawals = 6;
    account.monthlyFee = 500;

    account.monthlyStatement();
    
    float monthlyInterestRate = 3 / 12f / 100;
    float interest = (15000 - 500 - 2000) * monthlyInterestRate;
    float expectedBalance = 15000 - 500 - (2 * 1000) + interest;
    
    assertEquals(expectedBalance, account.balance, 0.01);
}



    @Test
    void testPrint() {

    }

    @Test
    void testWithdraw() {
        SavingsAccount activeAccount = new SavingsAccount(15000, 3);
        activeAccount.withdraw(2000);
        assertEquals(13000, activeAccount.balance, 0.01);
        assertEquals(1, activeAccount.numWithdrawals);
    
        SavingsAccount inactiveAccount = new SavingsAccount(9000, 3);
        inactiveAccount.withdraw(1000);
        assertEquals(9000, inactiveAccount.balance, 0.01);
        assertEquals(0, inactiveAccount.numWithdrawals);
    }
    
}
