package kata_bank_account;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void testDeposit() {
        Account account = new Account(1000, 5);
        account.deposit(500);
        assertEquals(1500, account.balance, 0.01);
        assertEquals(1, account.numDeposits);
    }

    @Test
    void testWithdraw() {
        Account account = new Account(1000, 5);
        account.withdraw(200);
        assertEquals(800, account.balance, 0.01);
        assertEquals(1, account.numWithdrawals);
        
        account.withdraw(1000);
        assertEquals(800, account.balance, 0.01);
        assertEquals(1, account.numWithdrawals);
    }

    @Test
    void testCalculateMonthlyInterest() {
        Account account = new Account(1000, 12);
        account.calculateMonthlyInterest();
    
        float monthlyInterestRate = 12 / 12 / 100f;
        float expectedInterest = 1000 * monthlyInterestRate;
        float expectedBalance = 1000 + expectedInterest;
    
        assertEquals(expectedBalance, account.balance, 0.01);
    }
    
    @Test
    void testMonthlyStatement() {
        Account account = new Account(1000, 12);
        account.monthlyFee = 50;
  
        account.monthlyStatement();

        float monthlyInterestRate = 12 / 12f / 100;
        float interest = (1000 - 50) * monthlyInterestRate;
        float expectedBalance = 1000 - 50 + interest;

        assertEquals(expectedBalance, account.balance, 0.01);
    }   

    @Test
    void testPrint() {
        Account account = new Account(1000, 5);
        account.numDeposits = 2;
        account.numWithdrawals = 1;
        account.monthlyFee = 30;
        
        String expectedOutput = "Balance: 1000,00\n" +
                                "Deposits: 2\n" +
                                "Withdrawals: 1\n" +
                                "Annual Interest Rate: 5,00%\n" +
                                "Monthly Fee: 30,00";
        
        String actualOutput = account.print();
        System.out.println("Expected Output:\n" + expectedOutput);
        System.out.println("Actual Output:\n" + actualOutput);
    
        assertEquals(expectedOutput, actualOutput);
    }
}
